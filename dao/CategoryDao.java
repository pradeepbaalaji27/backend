package com.ecom.dao;

import java.util.List;

import com.ecom.model.Category;



public interface CategoryDao {
	
	public boolean addcategory(Category category);
	public boolean deletecategory(Category category);
	public boolean Updatecategory(Category category);
	public  List<Category>listcategories();
	public Category getcategory(int category);

}
