package com.gotraining.productcatalogapi.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotraining.productcatalogapi.file.model.DBFile;
import com.gotraining.productcatalogapi.file.payload.UploadFileResponse;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Product {
	
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int productid;

private String productname;
private long quantity;
private long price;
String image_uri;



public Product() {
	super();
}



public Product(int productid, String productname, long quantity, long price) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.quantity = quantity;
	this.price = price;
}

public Product(String fileName, String contentType, byte[] bytes) {
	// TODO Auto-generated constructor stub
}


public Product(int productid) {
	super();
	this.productid = productid;
}
@ApiModelProperty(hidden = true)
public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}


public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

public long getQuantity() {
	return quantity;
}

public void setQuantity(long quantity) {
	this.quantity = quantity;
}

public long getPrice() {
	return price;
}



public void setImage_uri(String image_uri) {
	this.image_uri = image_uri;
}



public void setPrice(long price) {
	this.price = price;
}


@ManyToOne(fetch=FetchType.LAZY)
private Category category;

@ApiModelProperty(hidden = true)
public Category getCategory() {
	return new Category(getCategoryId(),getCategoryName());
}

@JsonIgnore
public int getCategoryId() {
	return category.getCategoryid();
}

@JsonIgnore
public String getCategoryName() {
	return category.getCategoryname();
}

public Product setCategory(Category category) {
	this.category = category;
	return this;
}

@ApiModelProperty(hidden = true)
public String getImage_uri() {
	return image_uri;
}


@Override
public String toString() {
	return "Product [productid=" + productid + ", quantity=" + quantity + ", price=" + price + "]";
}


	
}