package com.niit.lightingbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.lightingbackend.dao.UserDAO;
import com.niit.lightingbackend.model.Cart;
import com.niit.lightingbackend.model.UserCustomer;

@SuppressWarnings("deprecation")
@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<UserCustomer> list() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	@Transactional
	public UserCustomer get(int id) {
		return (UserCustomer) sessionFactory.getCurrentSession().get(UserCustomer.class, id);
	}

	@Transactional
	public UserCustomer validate(String id, String password) {
		System.out.println("inside validate");
		String hql = "from User where id ='" + id + "'  and password='" + password + "'";
		System.out.println("After hql");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("after query");
		return (UserCustomer) query.uniqueResult();

	}

	@Transactional
	public void save(UserCustomer user) {
		System.out.println("save user");

		Session session = sessionFactory.getCurrentSession();
		user.setRole("ROLE_USER");
		Cart cart = new Cart();
		user.setCart(cart);
		cart.setUserCustomer(user);
		// user.setRole("ROLE_ADMIN");
		session.saveOrUpdate(user);
	}

	@Transactional
	public boolean update(UserCustomer user) {

		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public UserCustomer get(String username) {

		Session session = this.sessionFactory.openSession();
		System.out.println("Hello1");
		Query query = session.createQuery("from UserCustomer where username=?");
		System.out.println("Hello 2");
		query.setString(0, username);
		System.out.println("Hello3");
		UserCustomer user = (UserCustomer) query.uniqueResult();
		System.out.println("Hello4");
		// logger.info("USer loaded successfully, User details="+User);
		// session.flush();
		// session.close();
		return user;

	}

}
