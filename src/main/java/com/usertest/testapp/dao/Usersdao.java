package com.usertest.testapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scala.annotation.meta.getter;

import com.usertest.testapp.domains.Authorities;
import com.usertest.testapp.domains.Employee;
import com.usertest.testapp.domains.Users;

@Repository("usersDao")
public class Usersdao {

	Logger logger = LoggerFactory.getLogger(Usersdao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(Users user, Authorities authorities) {
		logger.info("->		@Usersdao.addUser");
		sessionFactory.getCurrentSession()
			.save(user);
		sessionFactory.getCurrentSession()
			.save(authorities);
		logger.info("->		@Usersdao.addUser Completed");
	}
/*
	public List<Employee> listAllEmployees() {
		logger.info("->		@Employeedao.listAllEmployees");
		List<Employee> employees = null;
		employees = (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		logger.info("Obtained Employees list: " + employees.toString());
		logger.info("->		@Employeedao.listAllEmployees Completed");
		return employees;
	}

	public List<Employee> searchEmployeeByEmployeeFname(String search){
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

	public boolean deleteEmployee(int employeeId) {
		logger.info("->		@Employeedao.deleteEmployee");
		boolean success = false;
		Session session = sessionFactory.getCurrentSession();
		Object employee = sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		logger.info("->		@Employeedao.deleteEmployee Printing Employee: " + employee );
		if (employee != null) {
			sessionFactory.getCurrentSession().delete(employee);
			success = true;
		}
		logger.info("->		@Employeedao.deleteEmployee Completed");
		return success;
	}
*/
}
