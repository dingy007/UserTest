package com.usertest.testapp.services;

import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.usertest.testapp.dao.Detailsdao;
import com.usertest.testapp.domains.Details;
import com.usertest.testapp.domains.Employee;

@Service("detailsServices")
public class DetailsSvc {

	Logger logger = LoggerFactory.getLogger(DetailsSvc.class);
	
	@Autowired
	Detailsdao detailsDao;
	@Autowired
	MessageSource messageSource;
	
	@Transactional
	public void addDetails(Details details) {
		logger.info("->		@DetailsSvc.addDetails");
		details.setEmailAddress(generateEmailAddress(details.getEmployee()));
		detailsDao.addEmployeeDetails(details);
		logger.info("->		@DetailsSvc.addDetails Completed");
	}
	
	@Transactional
	public List<Details> getAllDetails() {
		logger.info("->		@DetailsSvc.getAllDetails");
		List<Details> detailsList = detailsDao.getAllDetails();
		logger.info("->		@DetailsSvc.getAllDetails Completed");
		return detailsList;
	}
	
	public String generateEmailAddress(Employee employee) {
		logger.info("->		@DetailsSvc.getEmailAddress");
		String emailAddress = employee.getFname().toString() + "@" + messageSource.getMessage("companyName", new Object[] {null}, Locale.getDefault())+".com";
		logger.info("->		@DetailsSvc.getEmailAddress generated an email: " + emailAddress);
		logger.info("->		@DetailsSvc.getEmailAddress Completed");
		return emailAddress;
	}
}
