package com.spring.dao;


import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public long saveUser(User user) {
		
		long i = (long) hibernateTemplate.save(user);
		return i;
	}

	@Override
	public User loginUser(String email, String password) {

		String sql = "from User where email=:em and password=:pwd";

		User us = (User) hibernateTemplate.execute(s -> {

			Query q = s.createQuery(sql);
			q.setString("em", email);
			q.setString("pwd", password);
			return q.uniqueResult();
		});

		return us;
	}

}
