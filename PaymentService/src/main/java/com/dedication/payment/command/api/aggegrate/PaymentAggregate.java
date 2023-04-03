package com.dedication.payment.command.api.aggegrate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;

import com.dedication.common.commands.ValidatePaymentCommand;
import com.dedication.common.events.PaymentProcessedEvent;

@Aggregate
public class PaymentAggregate {
		
	
		Logger logger;
	
		@AggregateIdentifier
		private String paymentId;
		private String orderId;
		private String paymentStatus;
	
		public PaymentAggregate() {
			
		}
		
		@CommandHandler
		public PaymentAggregate(ValidatePaymentCommand validatePaymentCommand) {
			//Validate the payment details
			//publish the payment Processed events
			logger.info("Executing ValidatePaymentCommand for  "+"Order Id:{} and Payment Id: {}",validatePaymentCommand.getOrderId(),validatePaymentCommand.getPaymentId());
			
			PaymentProcessedEvent paymentProcessedEvent
						=new PaymentProcessedEvent(
						  validatePaymentCommand.getPaymentId(),validatePaymentCommand.getOrderId());
			
			AggregateLifecycle.apply(paymentProcessedEvent);
			logger.info("PaymentProcessedEvent Applied");
		}
		
		@EventSourcingHandler
		public void on(PaymentProcessedEvent event) {
				this.paymentId=event.getPaymentId();
				this.orderId=event.getOrderId();
		}
		
}
