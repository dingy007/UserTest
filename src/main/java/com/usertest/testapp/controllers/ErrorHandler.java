package com.usertest.testapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author dineshkp
 * This class handles all the exceptions that occur in the Spring project.
 *
 */
@ControllerAdvice
public class ErrorHandler {
	
	Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
/*	
	@ExceptionHandler(value= {DataAccessException.class})
	public String handleDataAccessExceptions(Exception ex) {
		logger.info("    -> @ErrorHandler.handleDataAccessExceptions");
		logger.info("    -> @ErrorHandler.handleDataAccessExceptions serving errors.jsp");
		return "errors";
	}
	
	@ExceptionHandler(value= {Exception.class})
	public String handleGenericExceptions(Exception ex) {
		logger.info("    -> @ErrorHandler.handleGenericExceptions");
		logger.info("    -> @ErrorHandler.handleGenericExceptions serving errors.jsp");
		return "errors";
	}*/
}
