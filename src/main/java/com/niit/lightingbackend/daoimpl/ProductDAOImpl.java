package com.niit.lightingbackend.daoimpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.lightingbackend.dao.ProductDAO;
import com.niit.lightingbackend.model.Category;
import com.niit.lightingbackend.model.Product;
import com.niit.lightingbackend.model.Supplier;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void save(Product product) {

		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

    @Transactional
	public void update(Product product) {
    	sessionFactory.getCurrentSession().update(product);
		
	}

    @Transactional
	public void delete(int id) {
    	Product ProductToDelete = new Product();
		ProductToDelete.setProductid(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		
		
	}

    @Transactional
	public Product get(int productid) {
    	return (Product) sessionFactory.getCurrentSession().get(Product.class, productid);
	}

    @Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

    @Transactional
	public List<Category> listcategoryname() {
		String hql = "Select categoryname from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

    @Transactional
	public List<Supplier> listsuppliername() {
		String hql = "Select suppliername from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
}
		