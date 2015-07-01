package com.usertest.testapp.services;

import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.usertest.testapp.dao.Employeedao;
import com.usertest.testapp.domains.Employee;

@Service("employeeServices")
public class EmployeeSvc {
	
	@Autowired
	Employeedao employeedao;
	
	@Autowired
	MessageSource messageSource;
	
	Logger logger = LoggerFactory.getLogger(EmployeeSvc.class);
	@Transactional
	public void addEmployee(Employee user) {
		logger.info("->		@EmployeeSvc.addEmployee");
		user.setBadgeId(generateBadgeNumber());
		employeedao.addEmployee(user);
		logger.info("->		@EmployeeSvc.addEmployee Completed");
	}
	
	@Transactional
	public List<Employee> listAllEmployees() {
		logger.info("->		@EmployeeSvc.listAllEmployees");
		List<Employee> users = employeedao.listAllEmployees();
		logger.info("->		@EmployeeSvc.listAllEmployees Completed");
		return users;
	}
	
	public String generateBadgeNumber() {
		logger.info("->		@EmployeeSvc.generateBadgeNumber");
		String badgeId = null;
		int userCount = 1;
		if (!(listAllEmployees().isEmpty())) {
			userCount = listAllEmployees().size();
		}
		badgeId = messageSource.getMessage("companyName", new Object[] {null}, Locale.getDefault())+"00"+ (userCount);
		logger.info("->		@EmployeeSvc.generateBadgeNumber printing Badge Number: " + badgeId);
		logger.info("->		@EmployeeSvc.generateBadgeNumber Completed");
		return badgeId;
	}
	
	@Transactional
	public boolean deleteEmployeeByEmployeeId(int userId) {
		logger.info("->		@EmployeeSvc.deleteEmployeeByEmployeeId");
		logger.info("->		@EmployeeSvc.deleteEmployeeByEmployeeId Completed");
		return employeedao.deleteEmployee(userId);
	}
}
