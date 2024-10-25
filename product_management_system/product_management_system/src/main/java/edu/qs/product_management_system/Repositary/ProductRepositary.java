package edu.qs.product_management_system.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.qs.product_management_system.model.Product;

public interface ProductRepositary extends JpaRepository<Product, Integer> {

	

	
	
}
