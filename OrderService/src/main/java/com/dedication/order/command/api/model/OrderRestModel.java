package com.dedication.order.command.api.model;

public class OrderRestModel {

	private String productId;

	private String userId;

	private String addressId;

	private Integer quantity;

	public OrderRestModel() {

	}

	public OrderRestModel(String productId, String userId, String addressId, Integer quantity) {
		this.productId = productId;
		this.userId = userId;
		this.addressId = addressId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
