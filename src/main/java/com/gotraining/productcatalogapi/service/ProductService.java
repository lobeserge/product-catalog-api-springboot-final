package com.gotraining.productcatalogapi.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gotraining.productcatalogapi.dao.ProductRepository;
import com.gotraining.productcatalogapi.entity.Product;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository  productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	  public Optional<Product> getProductById(int id){
	    	return productRepository.findById(id);
	    }
	  
	  public  void  deleteProductById(int id){
		  productRepository.deleteById(id);
    }
	  
	  public Product createProduct(Product newproduct) {
	        return productRepository.save(newproduct);
	    }
	  public Product updateProduct(Product newproduct) {
	        return productRepository.save(newproduct);
	    }
	  @Autowired
	    private ProductRepository dbFileRepository;

	    public Product storeFile(MultipartFile file) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	              System.out.print("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            Product dbFile = new Product(fileName, file.getContentType(), file.getBytes());

	            return dbFileRepository.save(dbFile);
	        } catch (IOException ex) {
	           System.out.print("Could not store file " + fileName + ". Please try again!"+ ex);
	        }
	        return null;
	    }
	  
		
}
