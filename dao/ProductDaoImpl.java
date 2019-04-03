package com.ecom.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.model.Product;
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public boolean add(Product product) {
		 try
		  {
			  sessionFactory.getCurrentSession().save(product);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }

	}

	@Override
	public boolean delete(Product product) {
		 try
		  {
			  sessionFactory.getCurrentSession().delete(product);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }

	}

	@Override
	public boolean update(Product product) {
		 try
		  {
			  sessionFactory.getCurrentSession().update(product);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	}

	@Override
	public List<Product> listproducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listproducts=query.list();
		session.close();
		return listproducts;
	}

	@Override
	public Product getProduct(int ProductId) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, ProductId);
		session.close();
		return product;
	
	}

	@Override
	public List<Product> listcategorywiseProducts(int categoryId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryId=:categoryId");
		query.setParameter("categoryId",categoryId);
		List<Product> listproducts=query.list();
		session.close();
		return listproducts;
	}

}
