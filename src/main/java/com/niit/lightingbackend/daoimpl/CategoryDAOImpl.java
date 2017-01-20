package com.niit.lightingbackend.daoimpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.lightingbackend.dao.CategoryDAO;
import com.niit.lightingbackend.model.Category;



@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Category> list() {

		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}

	@Transactional
	public Category get(int categoryid) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryid);
	}

	@Transactional
	public void save(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	@Transactional
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	@Transactional
	public void delete(int categoryid) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setCategoryid(categoryid);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
		
	}
}
	
	