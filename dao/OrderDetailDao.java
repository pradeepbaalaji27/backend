package com.ecom.dao;

import com.ecom.model.OrderDetail;

public interface OrderDetailDao {
	public boolean PaymentProcess(OrderDetail orderdetail);
	public boolean UpdatecartitemStatus(String UserName);

}
