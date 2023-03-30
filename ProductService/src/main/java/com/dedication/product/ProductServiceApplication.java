package com.dedication.product;

import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dedication.product.command.api.exeption.ProductServiceEventsErrorHandler;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	public void configure(EventProcessingConfigurer eventProcessingConfigurer) {
		
		eventProcessingConfigurer.registerListenerInvocationErrorHandler("product", 
				
				configuration-> new ProductServiceEventsErrorHandler()
				);
	}

}
