package com.dedication.shipment.command.api.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shipment {

	@Id
	private String shipmentId;
	private String orderId;
	private String shipmentStatus;

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

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

}