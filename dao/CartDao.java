package com.ecom.dao;

import java.util.List;

import com.ecom.model.Cart;

public interface CartDao {
	public boolean addToCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteFromCart(Cart cart);
	public List<Cart> listcartitems(String UserName);
	public Cart getCartitem(int cartId);

}
