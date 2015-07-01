package com.usertest.testapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usertest.testapp.dao.User;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping("/createAccount")
	public String createAccount() {
		return "accountCreated";
	}
}
