package com.ecom.test;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.CategoryDao;
import com.ecom.model.Category;



public class CategoryDaoTest {
	
	static CategoryDao categoryDao;

	public static void initialize()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecom");
	context.refresh();
	categoryDao=(CategoryDao)context.getBean("categoryDAO");
	}

@Test
public void addcategorytest()
{
	Category category=new Category();

	category.setCategoryName("SamsungMobile");
	category.setCategorydesc("All smart mobile of samsung brand");
	category.setCategoryId(1);
	assertTrue("Problem in adding category",categoryDao.addcategory(category));
}
@Test
public void deleteCategoryTest()
{
	Category category=categoryDao.getcategory(2);
	assertTrue("Problem in deleting the category ",categoryDao.deletecategory(category));
	
}
@Test
public void UpdateCategoryTest()
{
	Category category=categoryDao.getcategory(3);
	category.setCategorydesc("ALL the smart mobile");
	assertTrue("problem in updating the category",categoryDao.Updatecategory(category));
	
	
}
@Test
public void retriveCategories()
{
	List<Category>ListCategories=categoryDao.listcategories();
	assertTrue("problem in retrieving category",ListCategories.size()>0);
	for(Category category:ListCategories)
	{
		System.out.println(category.getCategoryId()+"");
		System.out.println(category.getCategoryName()+"");
		System.out.println(category.getCategorydesc()+"");
		
	}
	
}
}