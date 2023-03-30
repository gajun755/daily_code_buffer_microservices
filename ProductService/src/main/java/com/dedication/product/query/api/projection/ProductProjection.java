package com.dedication.product.query.api.projection;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.dedication.product.command.api.data.Product;
import com.dedication.product.command.api.data.ProductRepository;
import com.dedication.product.command.api.model.ProductRestModel;
import com.dedication.product.query.api.queries.GetProductsQuery;

@Component
public class ProductProjection {

	private ProductRepository productRepository;

	public ProductProjection(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@QueryHandler
	public List<ProductRestModel> handle(GetProductsQuery getProductsQuery){
		
		List<Product> products=
				productRepository.findAll();
		
		List<ProductRestModel> productRestModels=
				products.stream()
					.map(product->{ProductRestModel model =new ProductRestModel();
							model.setQuantity(product.getQuantity());
							model.setPrice(product.getPrice());
							model.setName(product.getName());
							return model;
					}).collect(Collectors.toList());
		
		return productRestModels;
	}
}
