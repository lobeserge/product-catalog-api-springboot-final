package com.gotraining.productcatalogapi.file.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gotraining.productcatalogapi.entity.Product;
import com.gotraining.productcatalogapi.file.exception.FileStorageException;
import com.gotraining.productcatalogapi.file.exception.MyFileNotFoundException;
import com.gotraining.productcatalogapi.file.model.DBFile;
import com.gotraining.productcatalogapi.file.repo.DBFileRepository;
import com.gotraining.productcatalogapi.service.ProductService;

import java.io.IOException;
import java.util.Optional;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;
    @Autowired
	private ProductService productService;

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName,file.getContentType(), file.getBytes());
            
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
    
    public void getproduct(int id,String url) {
    	Optional<Product> product=productService.getProductById(id);
    	Product myproduct=product.get();
    	myproduct.setImage_uri(url);
    	productService.createProduct(myproduct);
    }
    
}
