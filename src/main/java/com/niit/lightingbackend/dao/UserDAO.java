package com.niit.lightingbackend.dao;

import java.util.List;

import com.niit.lightingbackend.model.UserCustomer;
public interface UserDAO {

	public List<UserCustomer> list();

	public UserCustomer validate(String id, String password);

	public void save(UserCustomer user);
	
	public UserCustomer get(String username);

	public boolean update(UserCustomer user);
}
