package com.niit.lightingbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.lightingbackend.dao.SupplierDAO;
import com.niit.lightingbackend.model.Category;
import com.niit.lightingbackend.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
@Autowired
 private SessionFactory sessionFactory;
 
	@Transactional
	public List<SupplierDAO> list() {
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}

	@Transactional
	public Supplier get(int supplierid) {
		return sessionFactory.getCurrentSession().get(Supplier.class,supplierid);
		
	}

	@Transactional
	public void save(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
		
	}

	@Transactional
	public void update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		
	}

	@Transactional
	public void delete(int id) {
	Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setSupplierid(id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
	
		
	}

}
