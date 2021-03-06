package com.usertest.testapp.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.usertest.testapp.domains.Users;
import com.usertest.testapp.services.UsersSvc;

@Controller
public class LoginController {
	
	@Autowired
	UsersSvc userServices;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String showLogin() {
		logger.info("    -> @LoginController.showLogin");
		logger.info("    -> @LoginController.showLogin serving login.jsp");
		return "login";
	}
	
	@RequestMapping("/logout")
	public String showLoggedOut() {
		logger.info("    -> @LoginController.showLoggedOut");
		logger.info("    -> @LoginController.showLoggedOut serving loggedout.jsp");
		return "loggedout";
	}
	
	@RequestMapping("/denied")
	public String showAccessDenied() {
		logger.info("    -> @LoginController.showAccessDenied");
		logger.info("    -> @LoginController.showAccessDenied serving denied.jsp");
		return "denied";
	}
	
	@RequestMapping("/newAccount")
	public String showNewAccount(Model model) {
		logger.info("    -> @LoginController.showNewAccount");
		model.addAttribute("user", new Users());
		logger.info("    -> @LoginController.showNewAccount serving newAccount.jsp");
		return "newAccount";
	}
	
	@RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute ("user") @Valid Users user, BindingResult result  ) {
		logger.info("    -> @LoginController.createAccount");
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			logger.error("    -> @LoginController.createAccount BindingResult has Error!");
			logger.error("    -> @LoginController.createAccount Error: " + result.getAllErrors());
			mav.setViewName("newAccount");
		}
		else {
			
			logger.info("    -> @LoginController.createAccount Creating account.");
			try {
				userServices.addUser(user);				
			} catch (ConstraintViolationException ex) {
				result.rejectValue("username", "DuplicateKey.user.username", "This username already exists!");
				mav.setViewName("newAccount");
				return mav;
			}
			mav.setViewName("accountCreated");
		}
		
		
		logger.info("    -> @LoginController.createAccount serving accountCreated.jsp");
		return mav;
//		return "accountCreated";
	}
	
	// Produces a JSON value to JavaScript
	@RequestMapping(value="/getmessages", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map<String, Object> getMessages(Principal principal) {
		List<String> messages = null;
		if (principal == null) {
			messages = new ArrayList<String>();
		}
		else {
//			String username = principal.getName();
			messages = new ArrayList<String>();
			messages.add("This is message 1");
			messages.add("This is message 2");
			messages.add("This is message 3");
			messages.add("This is message 4");
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("messages", messages);
		data.put("number", messages.size());
		
		return data;
	}
}
