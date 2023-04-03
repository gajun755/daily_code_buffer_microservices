package com.dedication.common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ShipOrderCommand {

		@TargetAggregateIdentifier
		private String shipmentId;
		private String orderId;
		public String getShipmentId() {
			return shipmentId;
		}
		public void setShipmentId(String shipmentId) {
			this.shipmentId = shipmentId;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		
		
}
