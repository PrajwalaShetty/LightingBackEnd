package com.niit.lightingbackend.dao;

import com.niit.lightingbackend.model.CustomerOrder;

public interface CustomerOrderDAO {
	
	void addCustomerOrder(CustomerOrder customerOrder);

	int getCustomerOrderGrandTotal(int cartId);


}
