package com.usertest.testapp.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	Logger logger = LoggerFactory.getLogger(Employee.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	@Column
	@NotBlank
	private String fname;
	@Column
	@NotBlank
	private String lname;
	@Column
	private String badgeId;
	@OneToOne(mappedBy="employee",targetEntity=Details.class, orphanRemoval=true, fetch=FetchType.LAZY, optional=true, cascade=CascadeType.ALL)
	private Details details;

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getBadgeId() {
		return badgeId;
	}
	public void setBadgeId(String badgeId) {
		this.badgeId = badgeId;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + employeeId + ", fname=" + fname + ", lname="
				+ lname + ", badgeId=" + badgeId + ", details=" + details + "]";
	}
	public Details getDetails() {
		return details;
	}
	public void setDetails(Details details) {
		this.details = details;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
