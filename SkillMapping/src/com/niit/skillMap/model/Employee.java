package com.niit.skillMap.model;

import java.sql.Date;
import java.util.LinkedList;

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
	private boolean status;
	
	//private Date date_of_joining;
	//private int no_of_student;
	//private String placement_company;
	
	Validation validate;
	
	public Employee() {
		validate=new Validation();
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
			validate.setMsg("Name should not be null");
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
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
	
	
	
	
}
