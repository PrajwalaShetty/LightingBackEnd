package com.niit.lightingbackend.dao;
import java.util.List;

import com.niit.lightingbackend.model.Category;

public interface CategoryDAO {

	public List<Category> list();
	 
	public Category get(int id);

	public void save(Category category);

	public void update(Category category);

	public void delete(int id);
	
	
}
