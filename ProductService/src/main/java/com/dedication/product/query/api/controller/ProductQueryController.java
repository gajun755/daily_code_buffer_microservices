package com.dedication.product.query.api.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dedication.product.command.api.model.ProductRestModel;
import com.dedication.product.query.api.queries.GetProductsQuery;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

		private QueryGateway queryGateway;
		
		@GetMapping
		public List<ProductRestModel> getAllProducts(){
			
			GetProductsQuery getProductsQuery=new GetProductsQuery();
			
			List<ProductRestModel> productRestModels=
			
			queryGateway.query(getProductsQuery, 
						ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
			
			return productRestModels;
		}
}
