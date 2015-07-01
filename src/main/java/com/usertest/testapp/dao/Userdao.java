package com.usertest.testapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usertest.testapp.domains.Employee;

@Repository("userdao")
public class Userdao {

	Logger logger = LoggerFactory.getLogger(Userdao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(Employee user) {
		logger.info("->		@Userdao.addUser");
		sessionFactory.getCurrentSession().save(user);
		logger.info("->		@Userdao.addUser Completed");
	}

	public List<Employee> listAllUsers() {
		logger.info("->		@Userdao.listAllUsers");
		List<Employee> users = null;
		users = (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		logger.info("Obtained Users list: " + users.toString());
		logger.info("->		@Userdao.listAllUsers Completed");
		return users;
	}
	
	public List<Employee> searchUserByUserFname(String search){
		Session session = sessionFactory.getCurrentSession();
		List<Employee> allContacts = null;
		String searchCrit = "%" + search + "%" ;
		
		Criteria crit = session.createCriteria(Employee.class);
		Criterion fname = Restrictions.like("fname", searchCrit);
//		Criterion lname = Restrictions.like("lastName", searchCrit);
//		LogicalExpression exp = Restrictions.or(fname, lname);
//		crit.add(exp);
		allContacts = crit.add(fname).list();
		return allContacts;
	}

	public boolean deleteUser(int userId) {
		logger.info("->		@Userdao.deleteUser");
		boolean success = false;
		Session session = sessionFactory.getCurrentSession();
		Object user = sessionFactory.getCurrentSession().load(Employee.class, userId);
		logger.info("->		@Userdao.deleteUser Printing User: " + user );
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
			success = true;
		}
		logger.info("->		@Userdao.deleteUser Completed");
		return success;
	}

}
