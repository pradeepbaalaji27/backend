package com.ecom.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.UserDetailDao;
import com.ecom.model.UserDetail;

public class UserDetailDaotest {
	 static UserDetailDao userdao;

		@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecom");
	context.refresh();

	userdao=(UserDetailDao)context.getBean("userDao");
	}
	
	@Test
	public void registeruserTest()
	{
	UserDetail userdetail=new UserDetail();
	userdetail.setAddress("velachery");
	userdetail.setEmailId("frtg.@gmail.com");
	userdetail.setCustomerName("Kavi");
	userdetail.setMobileNumber("8766443243");
	userdetail.setUsername("Tamilselvi");
	userdetail.setPassword("iuygfds5r6ty");
	userdetail.setRole("user_user");
	
	
	 assertTrue("problem in adding the userdetail",userdao.registeruser(userdetail));
	}
 @Ignore
	@Test
	public void UpdateuserTest()
	{
		UserDetail user=userdao.getusers("Pradeep");
		user.setCustomerName("Baalaji");
		user.setMobileNumber("9876543210");

		 assertTrue("problem in adding the userdetail",userdao.updateuser(user));

	}
	

}
