package edu.qs.product_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.product_management_system.Repositary.ProductRepositary;
import edu.qs.product_management_system.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	

	@Autowired
	private ProductRepositary productRepo;
	@Override
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllproduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		
		Product product = productRepo.findById(id).get();
		
		if(product!= null) {
			productRepo.delete(product);
			return "product delete successfully";
		}
		
		return "something wrong on server";
	}
	
	@Override
	public Product editProduct(Product p, Integer id) {
		Product oldProduct = productRepo.findById(id).get();
		
		oldProduct.setProductName(p.getProductName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());
		return productRepo.save(oldProduct);
	}

	
}
