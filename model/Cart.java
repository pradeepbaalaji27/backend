package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Cart {
	 @Id
	  @GeneratedValue
	  int CartId;
	  int ProductId;
	  String UserName;
	  String ProductName;
	  int Quantity;
	  String Status;
	  int Price;
	  
	  
	public int getCartId() 
	{
		return CartId;
	}
	public void setCartId(int cartId) 
	{
		CartId = cartId;
	}
	public int getProductId() 
	{
		return ProductId;
	}
	public void setProductId(int productId) 
	{
		ProductId = productId;
	}
	public String getUserName() 
	{
		return UserName;
	}
	public void setUserName(String userName) 
	{
		UserName = userName;
	}
	public String getProductName() 
	{
		return ProductName;
	}
	public void setProductName(String productName) 
	{
		ProductName = productName;
	}
	public int getQuantity() 
	{
		return Quantity;
	}
	public void setQuantity(int quantity) 
	{
		Quantity = quantity;
	}
	public String getStatus()
	{
		return Status;
	}
	public void setStatus(String status) 
	{
		Status = status;
	}
	public int getPrice()
	{
		return Price;
	}
	public void setPrice(int price)
	{
		Price = price;
	}
	  
	  
	}


