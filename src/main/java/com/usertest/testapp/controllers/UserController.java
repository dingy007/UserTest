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
import com.usertest.testapp.domains.Employee;
import com.usertest.testapp.services.DetailsSvc;
import com.usertest.testapp.services.EmployeeSvc;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	EmployeeSvc employeeServices;
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

	@RequestMapping(value="/showEmployeeForm", method=RequestMethod.GET)
	public String showAddEmployeeForm(@ModelAttribute("employee") Employee employee, BindingResult result) {
		logger.info("    -> @UserController.showAddEmployeeForm");
		logger.info("    -> @UserController.showAddEmployeeForm serving addEmployee.jsp");
		return "addEmployee";
	}

	@RequestMapping(value="/listAllEmployees",method=RequestMethod.GET)
	public ModelAndView showListAllEmployees() {
		logger.info("    -> @UserController.showListAllEmployees");
		List<Employee> employeeList = employeeServices.listAllEmployees();

		logger.info("    -> @UserController.showListAllEmployees : Listing all usersList");
		
		ModelAndView mav = new ModelAndView("listAllEmployees");
		mav.addObject("employeesList", employeeList);
		logger.info("    -> @UserController.showListAllEmployees serving listAllEmployees.jsp");
		return mav;
	}

	@RequestMapping(value="/listAllEmployeeDetails",method=RequestMethod.GET)
	public String showListAllUserDetails() {
		logger.info("    -> @UserController.listAllEmployeeDetails");
		logger.info("    -> @UserController.listAllEmployeeDetails completed serving listAllEmployeeDetails.jsp");

		return "listAllEmployeeDetails";
	}

	@RequestMapping(value="/addNewEmployee", method=RequestMethod.POST)
	public ModelAndView addNewEmployee(@ModelAttribute("user") @Valid Employee employee, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("    -> @UserController.addNewEmployee has Errors");
			mav.setViewName("addEmployee");
			logger.info("    -> @UserController.addNewEmployee serving addUser.jsp again");
		}
		else {
				mav.setViewName("addedNewEmployee");
				logger.info("    -> @UserController.addNewEmployee adding to table using the UserSvc(userServices)");
				logger.info("    -> @UserController.addNewEmployee user has the values: " + employee.toString());
				employeeServices.addEmployee(employee);
				logger.info("    -> @UserController.addNewEmployee adding to table using the UserSvc(userServices) Completed");
				Details details = new Details();
				details.setEmployee(employee);
				detailsServices.addDetails(details);
				logger.info("    -> @UserController.addNewEmployee printing Details: " + details.toString());
				logger.info("    -> @UserController.addNewEmployee adding to table Completed, serving addedNewEmployee.jsp.");
		}
		return mav;
	}
	
	@RequestMapping(value="/delete/{employeeId}")
	public String deleteEmployeeByEmployeeId(@PathVariable("employeeId") int employeeId) {
		logger.info("    -> @UserController.deleteEmployeeByEmployeeId.");
		boolean success = false;
		success = employeeServices.deleteEmployeeByEmployeeId(employeeId);
		if (!success) throw new DataAccessException("Unable to delete User with User Id: " + employeeId) {
			private static final long serialVersionUID = 1L;}; 
		logger.info("    -> @UserController.deleteEmployeeByEmployeeId Completed serving listAllEmployees.jsp");
		return "listAllEmployees";
	}
	
	@RequestMapping(value="/admin")
	public String showAdminPage() {
		logger.info("    -> @UserController.showAdminPage.");
		logger.info("    -> @UserController.showAdminPage completed serving admin.jsp");
		return "admin";
	}

}
