package com.ecom.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.OrderDetailDao;
import com.ecom.model.OrderDetail;

public class OrderDetailDaoTest {
	static OrderDetailDao orderDao;
	   @BeforeClass
	   public static void executeFirst()
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.ecom");
			context.refresh();

			orderDao=(OrderDetailDao)context.getBean("orderDao");  
	   }
	   @Ignore
	   @Test
	   public void PaymentprocessTest()
	   {
		   OrderDetail orderdetail=new OrderDetail();
		   orderdetail.setUserName("Pradeep");
		   orderdetail.setOrderDate(new Date()); 
		   orderdetail.setPaymentmode("CC");
		   orderdetail.setTotalAmount(45000);
		   
		   assertTrue("Problem in entering payment",orderDao.PaymentProcess(orderdetail));
	   }
	   
	   @Test
	   public void UpdatecartTest()
	   {
		   assertTrue("Problem in entering payment",orderDao.UpdatecartitemStatus("Pradeep"));  
	   }

	

}


