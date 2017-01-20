package com.niit.lightingbackend.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.lightingbackend.dao.UserDAO;
import com.niit.lightingbackend.model.User;


@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public List<User> list() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
	@Transactional
	public User get(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
	@Transactional
	public User validate(int id, String password) {
		System.out.println("inside validate");
		String hql = "from User where id ='" + id + "'  and password='" + password + "'";
		System.out.println("After hql");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("after query");
		return (User) query.uniqueResult();


	}
	@Transactional
	public void save(User user) {
		System.out.println("save user");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		user.setRole("ROLE_USER");
	}
	@Transactional
	public boolean update(User user) {

		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	}
