package com.usertest.testapp.controllers;

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
}
