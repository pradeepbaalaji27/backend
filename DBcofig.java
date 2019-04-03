package com.ecom.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecom.model.Cart;
import com.ecom.model.Category;
import com.ecom.model.OrderDetail;
import com.ecom.model.Product;
import com.ecom.model.Supplier;
import com.ecom.model.UserDetail;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecom")
public class DBcofig 
{
	@Bean	
	public DataSource getH2Datasources(){
	
		DriverManagerDataSource datasources =new DriverManagerDataSource();
		datasources.setDriverClassName("org.h2.Driver");
		datasources.setUrl("jdbc:h2:tcp://localhost/~/demo");
		datasources.setUsername("pradeep");
		datasources.setPassword("123");
		System.out.println("Datasources object created");
		return datasources;
		
		
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		
		hibernateprop.put("hibernate.hbm2ddl.auto","update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2Datasources());

		factory.addProperties(hibernateprop);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Cart.class);
	    
		factory.addAnnotatedClass(OrderDetail.class);
		System.out.println(">>>>>>SessionFactory Object created<<<<<<");

		return factory.buildSessionFactory();
		
	}
	@Bean("txt Manager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hiberante transcation Manager");
		return new HibernateTransactionManager(sessionFactory);
		
		
		
	}
	

}
