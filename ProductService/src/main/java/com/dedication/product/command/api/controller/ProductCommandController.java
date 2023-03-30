package com.dedication.product.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dedication.product.command.api.commands.CreateProductCommand;
import com.dedication.product.command.api.model.ProductRestModel;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

		
		private CommandGateway commandGateway;
	
		public ProductCommandController(CommandGateway commandGateway) {
			this.commandGateway=commandGateway;
		}
		
		@PostMapping
		public String addProduct(@RequestBody ProductRestModel productRestModel) {
			
			CreateProductCommand createProductCommand=new CreateProductCommand();
						createProductCommand.setProductId(UUID.randomUUID().toString());
						createProductCommand.setName(productRestModel.getName());
						createProductCommand.setPrice(productRestModel.getPrice());
						createProductCommand.setQuantity(productRestModel.getQuantity());
			
			String result =commandGateway.sendAndWait(createProductCommand);
			
			return result;
		}
	
}
