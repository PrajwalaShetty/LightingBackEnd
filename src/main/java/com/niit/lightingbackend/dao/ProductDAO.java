package com.niit.lightingbackend.dao;
import java.util.List;

import com.niit.lightingbackend.model.Category;
import com.niit.lightingbackend.model.Product;
import com.niit.lightingbackend.model.Supplier;

public interface ProductDAO {

		public void save(Product product);

		public void update(Product product);

		public void delete(int id);

		public Product get(int productid);

		public List<Product> list();
		
		public List<Category>listcategoryname();
		
		public List<Supplier>listsuppliername();

}
