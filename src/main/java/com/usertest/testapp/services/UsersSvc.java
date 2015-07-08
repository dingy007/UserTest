package com.usertest.testapp.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.usertest.testapp.dao.Employeedao;
import com.usertest.testapp.dao.Usersdao;
import com.usertest.testapp.domains.Authorities;
import com.usertest.testapp.domains.Users;

@Service("userServices")
public class UsersSvc {
	
	@Autowired
	Usersdao usersDao;
	
	Logger logger = LoggerFactory.getLogger(UsersSvc.class);
	
	@Transactional
	public void addUser(Users user) {
		logger.info("->		@UsersSvc.addUser");
		user.setEnabled(true);
		Authorities authority = new Authorities("ROLE_ADMIN", user);
		usersDao.addUser(user, authority);
		logger.info("->		@UsersSvc.addUser Completed");
	}
/*	
	@Transactional
	public List<Employee> listAllEmployees() {
		logger.info("->		@EmployeeSvc.listAllEmployees");
		List<Employee> employees = employeeDao.listAllEmployees();
		logger.info("->		@EmployeeSvc.listAllEmployees Completed");
		return employees;
	}
	
	public String generateBadgeNumber() {
		logger.info("->		@EmployeeSvc.generateBadgeNumber");
		String badgeId = null;
		int employeeCount = 1;
		if (!(listAllEmployees().isEmpty())) {
			employeeCount = listAllEmployees().size();
		}
		badgeId = messageSource.getMessage("companyName", new Object[] {null}, Locale.getDefault())+"00"+ (employeeCount);
		logger.info("->		@EmployeeSvc.generateBadgeNumber printing Badge Number: " + badgeId);
		logger.info("->		@EmployeeSvc.generateBadgeNumber Completed");
		return badgeId;
	}
	
	@Transactional
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		logger.info("->		@EmployeeSvc.deleteEmployeeByEmployeeId");
		logger.info("->		@EmployeeSvc.deleteEmployeeByEmployeeId Completed");
		return employeeDao.deleteEmployee(employeeId);
	}
*/
}
