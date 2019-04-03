package com.ecom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.model.Cart;
@Repository("cartDao")
@Transactional

public class CartDaoImpl implements CartDao{
	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public boolean addToCart(Cart cart) {
		 try
		  {
			  sessionFactory.getCurrentSession().save(cart);
			  return true;
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception arised"+e);
			  return false;  
		  }
	}

	@Override
	public boolean updateCart(Cart cart) {
		 try
		  {
			  sessionFactory.getCurrentSession().update(cart);
			  return true;
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception arised"+e);
			  return false;  
		  }	

	}

	@Override
	public boolean deleteFromCart(Cart cart) {
		try
		  {
			  sessionFactory.getCurrentSession().delete(cart);
			  return true;
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception arised"+e);
			  return false;  
		  }

	}

	@Override
	public List<Cart> listcartitems(String UserName) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where UserName=:user and Status='N'");
		query.setParameter("user",UserName);
		List<Cart> listcartitems=query.list();
		return listcartitems;
	
	}

	@Override
	public Cart getCartitem(int cartId) {
		Session session=sessionFactory.openSession();
		  Cart cart=session.get(Cart.class,cartId);
		  return cart;
		
	}

}
