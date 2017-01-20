package com.niit.lightingbackend.dao;

import java.util.List;

import com.niit.lightingbackend.model.User;
public interface UserDAO {

	public List<User> list();

	public User get(int id);

	public User validate(int id, String password);

	public void save(User user);

	public boolean update(User user);
}
