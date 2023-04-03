package com.dedication.common.models;


public class User {

		private String userId;
		private String firstName;
		private String lastName;
		private CardDetails cardDetails;
		
		public User() {
			
		}
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public CardDetails getCardDetails() {
			return cardDetails;
		}
		public void setCardDetails(CardDetails cardDetails) {
			this.cardDetails = cardDetails;
		}
		
		
}
