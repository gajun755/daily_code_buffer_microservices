package com.dedication.common.queries;

public class GetUserPaymentDetailsQuery {

	private String userId;

	public GetUserPaymentDetailsQuery() {

	}
	
	public GetUserPaymentDetailsQuery(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
