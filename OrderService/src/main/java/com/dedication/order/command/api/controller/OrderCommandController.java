package com.dedication.order.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dedication.order.command.api.commands.CreateOrderCommand;
import com.dedication.order.command.api.model.OrderRestModel;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {

	
		private CommandGateway commandGateway;
		
		public OrderCommandController(CommandGateway commandGateway) {
			this.commandGateway=commandGateway;
		}
	
		@PostMapping
		public String createOrder(@RequestBody OrderRestModel orderRestModel) {
			
			String ordeId=UUID.randomUUID().toString();
			
			CreateOrderCommand createOrderCommand=new CreateOrderCommand();
						createOrderCommand.setOrderId(ordeId);
						createOrderCommand.setAddressId(orderRestModel.getAddressId());
						createOrderCommand.setProductId(orderRestModel.getProductId());
						createOrderCommand.setQuantity(orderRestModel.getQuantity());
						createOrderCommand.setOrderStatus("CREATED");
					
			commandGateway.sendAndWait(createOrderCommand);
			return "Order Created";
		}
		
		
	
		
}
