package com.dedication.order.command.api.saga;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dedication.common.commands.CompleteOrderCommand;
import com.dedication.common.commands.ShipOrderCommand;
import com.dedication.common.commands.ValidatePaymentCommand;
import com.dedication.common.events.OrderCompletedEvent;
import com.dedication.common.events.OrderShippedEvent;
import com.dedication.common.events.PaymentProcessedEvent;
import com.dedication.common.models.User;
import com.dedication.common.queries.GetUserPaymentDetailsQuery;
import com.dedication.order.command.api.events.OrderCreatedEvent;




@Saga
public class OrderProcessingSaga {

	private CommandGateway commandGateway;
	private QueryGateway queryGateway;

	
	private static final Logger log = LoggerFactory.getLogger(OrderProcessingSaga.class);

	
	@Autowired
	public OrderProcessingSaga(CommandGateway commandGateway, QueryGateway queryGateway) {

		this.commandGateway = commandGateway;
		this.queryGateway = queryGateway;

	}

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	private void handle(OrderCreatedEvent orderCreatedEvent) {

		
		GetUserPaymentDetailsQuery getUserPaymentDetailsQuery
					=new GetUserPaymentDetailsQuery(orderCreatedEvent.getUserId());
		
		User user=null;
		try {
		user=queryGateway.query(getUserPaymentDetailsQuery, ResponseTypes.instanceOf(User.class)).join();
		}catch (Exception e) {
			//start the Compensating transaction
		}
		
		ValidatePaymentCommand validatePaymentCommand= new ValidatePaymentCommand();
				validatePaymentCommand.setCardDetails(user.getCardDetails());
				validatePaymentCommand.setOrderId(orderCreatedEvent.getOrderId());
				validatePaymentCommand.setPaymentId(UUID.randomUUID().toString());
	
				commandGateway.sendAndWait(validatePaymentCommand);
	}

	@SagaEventHandler(associationProperty = "orderId")
	private void handle(PaymentProcessedEvent event) {
		
		log.info("PaymentProcessedEvent is Saga for Order Id: {}",event.getOrderId());
		
		try {
			ShipOrderCommand shipOrderCommand=new ShipOrderCommand();
				shipOrderCommand.setShipmentId(UUID.randomUUID().toString());
				shipOrderCommand.setOrderId(event.getOrderId());
			commandGateway.send(shipOrderCommand);
		} catch (Exception e) {
			
			log.error(e.getMessage());
			//start the compensating transaction
		}
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderShippedEvent event) {
		
			log.info("OrderShipmentEvent in Saga for order Id:  ",event.getOrderId());
		
			CompleteOrderCommand completeOrderCommand=new CompleteOrderCommand();
					completeOrderCommand.setOrderId(event.getOrderId());
					completeOrderCommand.setOrderStatus("APPROVED");
			commandGateway.send(completeOrderCommand);
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	@EndSaga
	public void handle(OrderCompletedEvent event) {
		
		log.info("OrderCompletedEvent in saga for orderId : ",event.getOrderId());
		
		
	}
	
}
