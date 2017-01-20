package com.niit.lightingbackend.dao;
import java.util.List;

public interface ProductDAO {

	public List<ProductDAO> list();

	public ProductDAO get(String id);

	public boolean save(ProductDAO product);

	public boolean update(ProductDAO product);

}
