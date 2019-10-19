package com.gotraining.productcatalogapi.file.payload;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotraining.productcatalogapi.entity.Product;
import com.gotraining.productcatalogapi.file.model.DBFile;


@Entity
public class UploadFileResponse {
	
	@Id
	private String fileDownloadUri;
    private String fileName;
    private String fileType;
    private long size;

    
   
    


	
	public UploadFileResponse(String fileDownloadUri) {
		super();
		this.fileDownloadUri = fileDownloadUri;
	}

	public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
   

	public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
