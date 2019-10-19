package com.gotraining.productcatalogapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.gotraining.productcatalogapi.dao.CategoryRepository;
import com.gotraining.productcatalogapi.entity.Category;

@Component
@Order(1)
public class CategoryCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//populate some initial values into category
		Category Category1=new Category(1,"Toys & Games");
		Category Category2=new Category(2,"Electronic Accessories & Gadgets");
		Category Category3=new Category(3,"Video Games");
		Category Category4=new Category(4,"Camera & Photo Accessories");
		Category Category5=new Category(5,"Books");
		Category Category6=new Category(6,"Clothes, Shoes, and Jewelry");
		Category Category7=new Category(7,"Beauty And Personal Care");
		

		
		
		categoryRepository.save(Category1);
		categoryRepository.save(Category2);
		categoryRepository.save(Category3);
		categoryRepository.save(Category4);
		categoryRepository.save(Category5);
		categoryRepository.save(Category6);
		categoryRepository.save(Category7);
		
		
		
		
	}
}