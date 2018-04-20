package com.niit.skillMap.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Employee {

	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePhone;
	private String employeeCity;
	private String employeePassword;
	private String employeeQualification;
	private String employeeSkill;
	private String employeeCertification;
	private String employeeRole;
	private boolean status;
	
	
	Validation validate;
	List<String> errorMap;
	public Employee() {
		validate=new Validation();
		errorMap=new ArrayList<>();;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		if(validate.checkName(employeeName))
			this.employeeName = employeeName;
		else
			errorMap.add("Name Cannot be left Blank");
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		if(validate.checkEmail(employeeEmail))
			this.employeeEmail = employeeEmail;
		else
			errorMap.add("Invalid EmailId");
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		if(validate.checkPhone(employeePhone))
		this.employeePhone = employeePhone;
		else
			errorMap.add("Phone Not Valid");
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		if(validate.checkCity(employeeCity))
			this.employeeCity = employeeCity;
		else
			errorMap.add("City can not be left blank");
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		//if(validate.checkPassword(employeePassword))
			this.employeePassword = employeePassword;
		//else
			//errorMap.add("password must contain Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:");
	}

	public String getEmployeeQualification() {
		return employeeQualification;
	}

	public void setEmployeeQualification(String employeeQualification) {
		this.employeeQualification = employeeQualification;
	}
	public String getEmployeeSkill() {
		return employeeSkill;
	}

	public void setEmployeeSkill(String employeeSkill) {
		this.employeeSkill = employeeSkill;
	}

	public String getEmployeeCertification() {
		return employeeCertification;
	}

	public void setEmployeeCertification(String employeeCertification) {
		this.employeeCertification = employeeCertification;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Validation getValidate() {
		return validate;
	}

	public void setValidate(Validation validate) {
		this.validate = validate;
	}
	
	public List<String> getMap()
	{
		return errorMap;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	
	
	
	//private Date date_of_joining;
	//private int no_of_student;
	//private String placement_company;
	
}
