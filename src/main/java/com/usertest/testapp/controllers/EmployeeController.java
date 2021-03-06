package com.usertest.testapp.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.usertest.testapp.domains.Details;
import com.usertest.testapp.domains.Employee;
import com.usertest.testapp.services.DetailsSvc;
import com.usertest.testapp.services.EmployeeSvc;

@Controller
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeSvc employeeServices;
	@Autowired
	DetailsSvc detailsServices;

	@RequestMapping("/")
	public String homePage() {
		logger.info("    -> @EmployeeController.homePage");
		logger.info("    -> @EmployeeController.homePage serving home.jsp");
		return "home";
	}
	
	@RequestMapping("/home")
	public String gotoHomePage() {
		logger.info("    -> @EmployeeController.gotoHomePage");
		logger.info("    -> @EmployeeController.gotoHomePage serving home.jsp");
		return "home";
	}

	@RequestMapping(value="/showEmployeeForm", method=RequestMethod.GET)
	public String showAddEmployeeForm(@ModelAttribute("employee") Employee employee, BindingResult result) {
		logger.info("    -> @EmployeeController.showAddEmployeeForm");
		logger.info("    -> @EmployeeController.showAddEmployeeForm serving addEmployee.jsp");
		return "addEmployee";
	}

	@RequestMapping(value="/listAllEmployees",method=RequestMethod.GET)
	public ModelAndView showListAllEmployees() {
		logger.info("    -> @EmployeeController.showListAllEmployees");
		List<Employee> employeeList = employeeServices.listAllEmployees();

		logger.info("    -> @EmployeeController.showListAllEmployees : Listing all usersList");
		
		ModelAndView mav = new ModelAndView("listAllEmployees");
		mav.addObject("employeesList", employeeList);
		logger.info("    -> @EmployeeController.showListAllEmployees serving listAllEmployees.jsp");
		return mav;
	}

	@RequestMapping(value="/listAllEmployeeDetails",method=RequestMethod.GET)
	public String showListAllUserDetails() {
		logger.info("    -> @EmployeeController.listAllEmployeeDetails");
		logger.info("    -> @EmployeeController.listAllEmployeeDetails completed serving listAllEmployeeDetails.jsp");

		return "listAllEmployeeDetails";
	}

	@RequestMapping(value="/addNewEmployee", method=RequestMethod.POST)
	public ModelAndView addNewEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("    -> @EmployeeController.addNewEmployee has Errors");
			mav.setViewName("addEmployee");
			logger.info("    -> @EmployeeController.addNewEmployee serving addUser.jsp again");
		}
		else {
				mav.setViewName("addedNewEmployee");
				logger.info("    -> @EmployeeController.addNewEmployee adding to table using the UserSvc(userServices)");
				logger.info("    -> @EmployeeController.addNewEmployee user has the values: " + employee.toString());
				// employeeServices.addEmployee(employee);
				employeeServices.saveOrUpdate(employee);
				logger.info("    -> @EmployeeController.addNewEmployee adding to table using the UserSvc(userServices) Completed");
				Details details = new Details();
				details.setEmployee(employee);
				detailsServices.addDetails(details);
				logger.info("    -> @EmployeeController.addNewEmployee printing Details: " + details.toString());
				logger.info("    -> @EmployeeController.addNewEmployee adding to table Completed, serving addedNewEmployee.jsp.");
		}
		return mav;
	}
	
	@RequestMapping(value="/delete/{employeeId}")
	public String deleteEmployeeByEmployeeId(@PathVariable("employeeId") int employeeId) {
		logger.info("    -> @EmployeeController.deleteEmployeeByEmployeeId.");
		boolean success = false;
		success = employeeServices.deleteEmployeeByEmployeeId(employeeId);
		if (!success) throw new DataAccessException("Unable to delete User with User Id: " + employeeId) {
			private static final long serialVersionUID = 1L;}; 
		logger.info("    -> @EmployeeController.deleteEmployeeByEmployeeId Completed serving listAllEmployees.jsp");
		return "redirect:/listAllEmployees";
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView showAdminPage(@ModelAttribute String user, BindingResult result, Principal principal) {
		logger.info("    -> @EmployeeController.showAdminPage.");
		logger.info("    -> @EmployeeController.showAdminPage completed serving admin.jsp");
		// Use the principal to get the User
		ModelAndView mav = new ModelAndView("admin", "user", principal.getName());
		return mav;
		//model.addAttribute("user", principal.getName());
		//return "admin";
	}
	
	@RequestMapping(value="/uploadFile")
	public String showUploadFilePage() {
		logger.info("    -> @EmployeeController.showUploadFilePage.");
		logger.info("    -> @EmployeeController.showUploadFilePage completed serving uploadFile.jsp");
		return "uploadFile";
	}
	
	@RequestMapping(value="/uploadingFile", method=RequestMethod.POST)
	public String handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		logger.info("    -> @EmployeeController.handleFileUpload.");
//		File filePath = new File("C:/Users/dineshkp/Desktop/GitRepo_local/tempdir/" + name);
		// String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		File filePath = new File(name);
		
		if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				//Create the file on the Server
				File serverFile = new File(dir.getAbsoluteFile() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				logger.info("Server file location: " + serverFile.getAbsolutePath());
				logger.info("    -> @EmployeeController.handleFileUpload File uploaded successfully!");
			}
			catch (Exception err) {
				logger.info("    -> @EmployeeController.handleFileUpload Exception during File Creation.");
				return "errors";
			}
		}
		else {
			logger.info("    -> @EmployeeController.handleFileUpload File is empty!");
			return "errors";
		}
		logger.info("    -> @EmployeeController.handleFileUpload completed serving uploadSuccess.jsp");
		return "uploadSuccess";
	}

}
