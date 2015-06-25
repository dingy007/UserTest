package com.usertest.testapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usertest.testapp.domains.User;

@Repository("userdao")
public class Userdao {
	
	Logger logger = LoggerFactory.getLogger(Userdao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		logger.info("->		@Userdao.addUser");
		sessionFactory.getCurrentSession().save(user);
		logger.info("->		@Userdao.addUser Completed");
	}
	
	
	public List<User> listAllUsers() {
		logger.info("->		@Userdao.listAllUsers");
		List<User> users = null;
		users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
		logger.info("Obtained Users list: " + users.toString());
		logger.info("->		@Userdao.listAllUsers Completed");
		return users;
	}
}
