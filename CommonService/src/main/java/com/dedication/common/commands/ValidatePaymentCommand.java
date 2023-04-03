package com.dedication.common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.dedication.common.models.CardDetails;

public class ValidatePaymentCommand {

		@TargetAggregateIdentifier
		private String paymentId;
		private String orderId;
		private CardDetails cardDetails;
		
		public ValidatePaymentCommand() {
			
			
		}

		public String getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(String paymentId) {
			this.paymentId = paymentId;
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public CardDetails getCardDetails() {
			return cardDetails;
		}

		public void setCardDetails(CardDetails cardDetails) {
			this.cardDetails = cardDetails;
		}
		
		
}
