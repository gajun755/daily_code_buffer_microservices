package com.dedication.product.command.api.events;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.dedication.product.command.api.data.Product;
import com.dedication.product.command.api.data.ProductRepository;

@Component
@ProcessingGroup("product")
public class ProductEventsHandler {

	private ProductRepository productRepository;

	public ProductEventsHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@EventHandler
	public void on(ProductCreatedEvent productCreatedEvent) throws Exception {

		Product product = new Product();
		BeanUtils.copyProperties(productCreatedEvent, product);
		productRepository.save(product);
		throw new Exception("Expeption occured");

	}
	
	@ExceptionHandler
	public void handle(Exception exception) throws Exception {
		throw exception;
	}
	
}
