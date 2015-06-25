package com.usertest.testapp.services;

import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.usertest.testapp.dao.Userdao;
import com.usertest.testapp.domains.User;

@Service("userServices")
public class UserSvc {
	
	@Autowired
	Userdao userdao;
	
	@Autowired
	MessageSource messageSource;
	
	Logger logger = LoggerFactory.getLogger(UserSvc.class);
	@Transactional
	public void addUser(User user) {
		logger.info("->		@UserSvc.addUser");
		user.setBadgeId(generateBadgeNumber());
		userdao.addUser(user);
		logger.info("->		@UserSvc.addUser Completed");
	}
	
	@Transactional
	public List<User> listAllUsers() {
		logger.info("->		@UserSvc.listAllUsers");
		List<User> users = userdao.listAllUsers();
		logger.info("->		@UserSvc.listAllUsers Completed");
		return users;
	}
	
	public String generateBadgeNumber() {
		logger.info("->		@UserSvc.generateBadgeNumber");
		String badgeId = null;
		int userCount = 1;
		if (!(listAllUsers().isEmpty())) {
			userCount = listAllUsers().size();
		}
		badgeId = messageSource.getMessage("companyName", new Object[] {null}, Locale.getDefault())+"00"+ (userCount);
		logger.info("->		@UserSvc.generateBadgeNumber printing Badge Number: " + badgeId);
		logger.info("->		@UserSvc.generateBadgeNumber Completed");
		return badgeId;
	}
}