package com.dedication.shipment.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dedication.common.events.OrderShippedEvent;
import com.dedication.shipment.command.api.data.Shipment;
import com.dedication.shipment.command.api.data.ShipmentRepository;

@Component
public class ShipmentEventHandler {

		
		@Autowired
		ShipmentRepository repository;
	
		@EventHandler
		public void on(OrderShippedEvent event) {
			
			Shipment shipment=new Shipment();
			BeanUtils.copyProperties(event, shipment);
			repository.save(shipment);
			
			
		}
	
}
