package com.ecom.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.ProductDao;
import com.ecom.model.Product;

public class ProductDaoTest {
	 static ProductDao productDao;

		@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecom");
	context.refresh();

	productDao=(ProductDao)context.getBean("productDao");
	}
		
	@Test
	public void addProductTest()
	{
	Product product=new Product();

	product.setProductName("NoteBook");
	product.setProductDesc("All authors books and notes are available");
	product.setPrice(50);
	product.setStock(300);
	product.setSupplierId(90);
	product.setCategoryId(7);
	 assertTrue("problem in adding the Product",productDao.add(product));
	}
	@Ignore
	@Test
	public void UpdateProductTest()
	{
		Product product=productDao.getProduct(38);
		product.setProductName("candle");
		product.setProductDesc("Light");
     assertTrue("problem in adding the category",productDao.update(product));

	}
	@Ignore
	@Test
	public void DeleteProductTest()
	{
		Product product=productDao.getProduct(38);
		assertTrue("problem in adding the category",productDao.delete(product));
 }
	
	@Test
	public void listProductTest()
	{
		List<Product> listprod=productDao.listproducts();
		assertTrue("problem in adding the category",listprod.size()>0);
		for(Product product:listprod)
		{
			System.out.println(product);
		}
			}
		


}


