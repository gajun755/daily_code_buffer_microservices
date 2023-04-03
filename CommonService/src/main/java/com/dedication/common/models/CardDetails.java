package com.dedication.common.models;

public class CardDetails {

	private String name;
	private String cardNumber;
	private Integer valiUntilMonth;
	private Integer validUntilYear;
	private Integer cvv;

	public CardDetails() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getValiUntilMonth() {
		return valiUntilMonth;
	}

	public void setValiUntilMonth(Integer valiUntilMonth) {
		this.valiUntilMonth = valiUntilMonth;
	}

	public Integer getValidUntilYear() {
		return validUntilYear;
	}

	public void setValidUntilYear(Integer validUntilYear) {
		this.validUntilYear = validUntilYear;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

}
