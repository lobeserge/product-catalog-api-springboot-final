package com.gotraining.productcatalogapi.file.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.gotraining.productcatalogapi.entity.Product;
import com.gotraining.productcatalogapi.file.model.DBFile;
import com.gotraining.productcatalogapi.file.payload.UploadFileResponse;
import com.gotraining.productcatalogapi.service.ProductService;

@RestController
@CrossOrigin
public class FileController {

	@Autowired
	private ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private com.gotraining.productcatalogapi.file.service.DBFileStorageService DBFileStorageService;

    @PostMapping("/uploadFile/{prdid}")
    public UploadFileResponse uploadFile(@PathVariable("prdid") int id,@RequestParam("file") MultipartFile file) {
    	
		 DBFile dbfile= DBFileStorageService.storeFile(file);
		
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(dbfile.getId())
	                .toUriString();
		 DBFileStorageService.getproduct(id, fileDownloadUri);

        return new UploadFileResponse(dbfile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        DBFile dbFile = DBFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
        
    }

}
