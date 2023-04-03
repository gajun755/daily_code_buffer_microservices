package com.dedication.common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CompleteOrderCommand {

	
		@TargetAggregateIdentifier
		private String orderId;
		private String orderStatus;
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}
		
		
}
