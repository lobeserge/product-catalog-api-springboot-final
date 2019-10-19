package com.gotraining.productcatalogapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.gotraining.productcatalogapi.dao.ProductRepository;
import com.gotraining.productcatalogapi.entity.Category;
import com.gotraining.productcatalogapi.entity.Product;

@Component
@Order(2)
public class ProductCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Product product1=new Product(1,"Memory games",13,2000);
		product1.setCategory(new Category(1));
		productRepository.save(product1);
		Product product2=new Product(2,"Lego blocks",14,2000);
		product2.setCategory(new Category(1));
		productRepository.save(product2);
		
		Product product3=new Product(3,"Portable speakers",20,2000);
		product3.setCategory(new Category(2));
		productRepository.save(product3);
		Product product4=new Product(4,"USB devices",45,2000);
		product4.setCategory(new Category(2));
		productRepository.save(product4);
		
		Product product5=new Product(5,"Sony PlayStation",20,5000);
		product5.setCategory(new Category(3));
		productRepository.save(product5);
		
		Product product6=new Product(6,"GoPro",15,6990);
		product6.setCategory(new Category(4));
		productRepository.save(product6);
		
		Product product7=new Product(7,"NelKon",98,2000);
		product7.setCategory(new Category(5));
		productRepository.save(product7);
		
		Product product8=new Product(8,"Stylish shoes",75,23400);
		product8.setCategory(new Category(6));
		productRepository.save(product8);
		
		Product product9=new Product(9,"Branded makeup",45,3400);
		product9.setCategory(new Category(7));
		productRepository.save(product9);
		
		
		
		
			
	}
}