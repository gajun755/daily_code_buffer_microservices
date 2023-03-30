package com.dedication.product.command.api.aggregate;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.dedication.product.command.api.commands.CreateProductCommand;
import com.dedication.product.command.api.events.ProductCreatedEvent;

@Aggregate
public class ProductAggregate {
	
	@AggregateIdentifier
	private String productId;

	private String name;

	private BigDecimal price;

	private Integer quantity;
		
	@CommandHandler
	public ProductAggregate(CreateProductCommand createProductCommand){
		
		//you can perform all the validations
		ProductCreatedEvent productCreatedEvent= new ProductCreatedEvent();
		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
		AggregateLifecycle.apply(productCreatedEvent);
	}

	public ProductAggregate() {
		
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		
			this.quantity=productCreatedEvent.getQuantity();
			this.productId=productCreatedEvent.getProductId();
			this.price=productCreatedEvent.getPrice();
			this.name=productCreatedEvent.getName();		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}