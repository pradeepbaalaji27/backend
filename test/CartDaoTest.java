package com.ecom.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.CartDao;
import com.ecom.model.Cart;

public class CartDaoTest {
	 static CartDao cartDao;

		@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecom");
	context.refresh();

	cartDao=(CartDao)context.getBean("cartDao");
	}
		
	@Test
	public void Test()
	{
	Cart cart=new Cart();
	cart.setPrice(45000);
	cart.setProductId(35);
	cart.setProductName("Computer");
	cart.setQuantity(1);
	cart.setStatus("N");
	cart.setUserName("Rubi");
assertTrue("problem in adding cart",cartDao.addToCart(cart));
	}

		@Ignore
		@Test
		public void UpdatecartTest()
		{
			Cart cart=cartDao.getCartitem(40);
			cart.setUserName("Bindhu");
			cart.setProductName("Pen");
			cart.setQuantity(5);

			 assertTrue("problem in updating the category",cartDao.updateCart(cart));

		}
		@Ignore
		@Test
		public void DeleteCategoryTest()
		{

			Cart cart=cartDao.getCartitem(8);
			 assertTrue("problem in deleting the category",cartDao.deleteFromCart(cart));

		}
  @Ignore
		@Test
	    public void listcartitemsTest()
			{
			List<Cart> listitems=cartDao.listcartitems("Rupesh");
		   assertTrue("problem occured when list the items",listitems.size()>0);
				
				for(Cart cart:listitems)
				{
					System.out.println("ProductId"+cart.getProductId());
					System.out.println("ProductName"+cart.getProductName());
					System.out.println("price"+cart.getPrice());
					System.out.println("Quantity"+cart.getQuantity());
			}
		}

	


}
