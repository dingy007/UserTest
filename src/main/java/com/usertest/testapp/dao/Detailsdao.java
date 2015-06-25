package com.usertest.testapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usertest.testapp.domains.Details;

@Repository("UserDetailsdao")
public class Detailsdao {

	Logger logger = LoggerFactory.getLogger(Detailsdao.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addUserDetails(Details details) {
		logger.info("->		@Detailsdao.addUserDetails");
		sessionFactory.getCurrentSession().save(details);
		logger.info("->		@Detailsdao.addUserDetails Completed");
	}
	
	@SuppressWarnings("unchecked")
	public List<Details> getAllDetails() {
		logger.info("->		@Detailsdao.getAllDetails");
		List<Details> details = null;
		details = (List<Details>) sessionFactory.getCurrentSession().createCriteria(Details.class).list();
		logger.info("Obtained Details: " + details.toString());
		logger.info("->		@Detailsdao.getAllDetails Completed");
		return details;
	}
}
