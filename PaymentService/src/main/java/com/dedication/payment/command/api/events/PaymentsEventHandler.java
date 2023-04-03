package com.dedication.payment.command.api.events;

import java.util.Date;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dedication.common.events.PaymentProcessedEvent;
import com.dedication.payment.command.api.data.Payment;
import com.dedication.payment.command.api.data.PaymentRepository;

@Component
public class PaymentsEventHandler {

	
		@Autowired
		PaymentRepository paymentRepository;
	
		@EventHandler
		public void on(PaymentProcessedEvent paymentProcessedEvent) {
			
			Payment payment=new Payment();
				payment.setPaymentId(paymentProcessedEvent.getPaymentId());
				payment.setOrderId(paymentProcessedEvent.getOrderId());
				payment.setPaymentStatus("COMPLETED");
				payment.setTimeStamp(new Date());
				
			paymentRepository.save(payment);
			
		}
}
