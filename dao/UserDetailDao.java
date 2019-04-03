package com.ecom.dao;

import com.ecom.model.UserDetail;

public interface UserDetailDao {
	
	public boolean registeruser(UserDetail userdetail);
	public boolean updateuser(UserDetail userdetail);
	public UserDetail getusers(String username);
}
