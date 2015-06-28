package com.usertest.testapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.usertest.testapp.domains.Details;
import com.usertest.testapp.domains.User;
import com.usertest.testapp.services.DetailsSvc;
import com.usertest.testapp.services.UserSvc;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserSvc userServices;
	@Autowired
	DetailsSvc detailsServices;

	@RequestMapping("/")
	public String homePage() {
		logger.info("    -> @UserController.homePage");
		logger.info("    -> @UserController.homePage serving home.jsp");
		return "home";
	}
	
	@RequestMapping("/home")
	public String gotoHomePage() {
		logger.info("    -> @UserController.gotoHomePage");
		logger.info("    -> @UserController.gotoHomePage serving home.jsp");
		return "home";
	}

	@RequestMapping(value="/showUserForm", method=RequestMethod.GET)
	public String showAddUserForm(@ModelAttribute("user") User user, BindingResult result) {
		logger.info("    -> @UserController.showAddUserForm");
		logger.info("    -> @UserController.showAddUserForm serving AddUser.jsp");
		return "addUser";
	}

	@RequestMapping(value="/listAllUsers",method=RequestMethod.GET)
	public ModelAndView showListAllUsers() {
		logger.info("    -> @UserController.showListAllUsers");
		List<User> usersList = userServices.listAllUsers();
		
		if (usersList.isEmpty()) {
			throw new RuntimeException("No Valid data.");
		}
		logger.info("    -> @UserController.showListAllUsers : Listing all usersList");
		
		for (User user: usersList) {
			logger.info("User: " + user.toString());
		}
		ModelAndView mav = new ModelAndView("listAllUsers");
		mav.addObject("usersList", usersList);
		logger.info("    -> @UserController.showListAllUsers serving listAllUsers.jsp");
		return mav;
	}

	@RequestMapping(value="/listAllUserDetails",method=RequestMethod.GET)
	public String showListAllUserDetails() {
		logger.info("    -> @UserController.showListAllUserDetails");
		logger.info("    -> @UserController.showListAllUserDetails serving listAllUserDetails.jsp");

		return "listAllUserDetails";
	}

	@RequestMapping(value="/addNewUser", method=RequestMethod.POST)
	public ModelAndView addNewUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("    -> @UserController.addNewUser has Errors");
			mav.setViewName("addUser");
			logger.info("    -> @UserController.addNewUser serving addUser.jsp again");
		}
		else {
				mav.setViewName("addedNewUser");
				logger.info("    -> @UserController.addNewUser adding to table using the UserSvc(userServices)");
				logger.info("    -> @UserController.addNewUser user has the values: " + user.toString());
				userServices.addUser(user);
				logger.info("    -> @UserController.addNewUser adding to table using the UserSvc(userServices) Completed");
				Details details = new Details();
				details.setUser(user);
				detailsServices.addDetails(details);
				logger.info("    -> @UserController.addNewUser printing Details: " + details.toString());
				logger.info("    -> @UserController.addNewUser adding to table Completed.");
		}
		return mav;
	}
	
	@RequestMapping(value="/delete/{userId}")
	public String deleteUserByUserId(@PathVariable("userId") int userId) {
		logger.info("    -> @UserController.deleteUserByUserId.");
		boolean success = false;
		success = userServices.deleteUserByUserId(userId);
		if (!success) throw new DataAccessException("Unable to delete User with User Id: " + userId) {
			private static final long serialVersionUID = 1L;}; 
		logger.info("    -> @UserController.deleteUserByUserId Completed.");
		return "listAllUsers";
	}

}
