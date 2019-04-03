package com.ecom.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.model.UserDetail;
@Repository("userDao")
@Transactional
public class UserDetailDaoImpl implements UserDetailDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registeruser(UserDetail userdetail) {
		 try
		  {
			  sessionFactory.getCurrentSession().save(userdetail);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }

	}

	@Override
	public boolean updateuser(UserDetail userdetail) {
		 try
		  {
			  sessionFactory.getCurrentSession().update(userdetail);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	}

	@Override
	public UserDetail getusers(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class, username);
		session.close();
		return user;
	}
	

}
