package com.niit.skillMap.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

public class Repository {

	Connection connection=null;
	PreparedStatement pst;
	
	public Repository() {
		connection = DBConfig.connect();
	}
	
	public int insert(Employee employee)
	{
		int count=0;
		try {
			pst = connection.prepareStatement("insert into employee(employeeId,employeeName,employeeEmail,employeePhone,employeeCity,employeeQualification,employeeSkill,employeeCertification,employeePassword,employeeRole,status) values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, employee.getEmployeeId());
			pst.setString(2, employee.getEmployeeName());
			pst.setString(3, employee.getEmployeeEmail());
			pst.setString(4, employee.getEmployeePhone());
			pst.setString(5, employee.getEmployeeCity());
			pst.setString(6, employee.getEmployeeQualification());
			pst.setString(7, employee.getEmployeeSkill());
			pst.setString(8, employee.getEmployeeCertification());
			pst.setString(9, employee.getEmployeePassword());
			pst.setString(10, employee.getEmployeeRole());
			pst.setBoolean(11, employee.isStatus());
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}

	
	public int updateEmployee(Employee employee,int id)
	{
		int count=0;
		try {
			pst = connection.prepareStatement("update employee set employeeName=?,employeePhone=?,employeeEmail=?,employeeCity=?,employeeQualification=?,employeeSkill=?,employeeCertification=?,employeeRole=? where employeeId=?");
			pst.setInt(9, employee.getEmployeeId());
			pst.setString(1, employee.getEmployeeName());
			pst.setString(2, employee.getEmployeePhone());
			pst.setString(3, employee.getEmployeeEmail());
			pst.setString(4, employee.getEmployeeCity());
			pst.setString(5, employee.getEmployeeQualification());
			pst.setString(6, employee.getEmployeeSkill());
			pst.setString(7, employee.getEmployeeCertification());
			pst.setString(8, employee.getEmployeeRole());
			
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}
	public int approveEmployee(int id)
	{
		int count=0;
		try {
			pst = connection.prepareStatement("update employee set status=? where employeeId=?");
			pst.setBoolean(1, true);
			pst.setInt(2, id);
			
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}
	
	public int deleteEmployee(int id)
	{
		int count=0;
		try {
			pst = connection.prepareStatement("delete from employee where employeeId=?");
			pst.setInt(1,id);
			
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}
	
	public Employee getEmployeeDetails(String employeeEmail)
	{

		Employee employee=new Employee();
		try {
			pst = connection.prepareStatement("select * from employee where employeeEmail=?");
			pst.setString(1, employeeEmail);
			
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				employee.setEmployeeId(resultSet.getInt(1));
				employee.setEmployeeEmail(resultSet.getString(3));
				employee.setEmployeePhone(resultSet.getString(4));
				employee.setEmployeeCity(resultSet.getString(5));
				employee.setEmployeeQualification(resultSet.getString(6));
				employee.setEmployeeSkill(resultSet.getString(7));
				employee.setEmployeeCertification(resultSet.getString(8));
				employee.setEmployeeRole(resultSet.getString(10));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		
	}
	
	public Employee getEmployeeById(int employeeId)
	{

		Employee employee=new Employee();
		try {
			pst = connection.prepareStatement("select * from employee where employeeId=?");
			pst.setInt(1, employeeId);
			
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				employee.setEmployeeId(resultSet.getInt(1));
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeeEmail(resultSet.getString(3));
				employee.setEmployeePhone(resultSet.getString(4));
				employee.setEmployeeCity(resultSet.getString(5));
				employee.setEmployeeQualification(resultSet.getString(6));
				employee.setEmployeeSkill(resultSet.getString(7));
				employee.setEmployeeCertification(resultSet.getString(8));
				employee.setEmployeeRole(resultSet.getString(10));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		
	}
	
	public List<Employee> getAllEmployeeDetails()
	{
		List<Employee> list=new ArrayList<>();
		try {
			pst = connection.prepareStatement("select * from employee where status=?");
			pst.setBoolean(1, true);
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				Employee employee=new Employee();
				employee.setEmployeeId(resultSet.getInt(1));
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeeEmail(resultSet.getString(3));
				employee.setEmployeePhone(resultSet.getString(4));
				employee.setEmployeeCity(resultSet.getString(5));
				employee.setEmployeeQualification(resultSet.getString(6));
				employee.setEmployeeSkill(resultSet.getString(7));
				employee.setEmployeeCertification(resultSet.getString(8));
				employee.setEmployeeRole(resultSet.getString(10));
				employee.setStatus(resultSet.getBoolean(11));
				list.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Employee> getAllApprovedEmployee(String key)
	{
		List<Employee> list=new ArrayList<>();
		try {
			pst = connection.prepareStatement("select * from employee where employeeSkill like ? and status=? ");
			pst.setString(1, "%"+key+"%");
			pst.setBoolean(2, true);
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				Employee employee=new Employee();
				employee.setEmployeeId(resultSet.getInt(1));
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeeEmail(resultSet.getString(3));
				employee.setEmployeePhone(resultSet.getString(4));
				employee.setEmployeeCity(resultSet.getString(5));
				employee.setEmployeeQualification(resultSet.getString(6));
				employee.setEmployeeSkill(resultSet.getString(7));
				employee.setEmployeeCertification(resultSet.getString(8));
				employee.setEmployeeRole(resultSet.getString(10));
				employee.setStatus(resultSet.getBoolean(11));
				list.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Employee> getAllPendingDetails()
	{
		List<Employee> list=new ArrayList<>();
		try {
			pst = connection.prepareStatement("select * from employee where status=?");
			pst.setBoolean(1, false);
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				Employee employee=new Employee();
				employee.setEmployeeId(resultSet.getInt(1));
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeeEmail(resultSet.getString(3));
				employee.setEmployeePhone(resultSet.getString(4));
				employee.setEmployeeCity(resultSet.getString(5));
				employee.setEmployeeQualification(resultSet.getString(6));
				employee.setEmployeeSkill(resultSet.getString(7));
				employee.setEmployeeCertification(resultSet.getString(8));
				employee.setEmployeeRole(resultSet.getString(10));
				employee.setStatus(resultSet.getBoolean(11));
				list.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	public int validateEmployee(String employeeEmail,String employeePassword)
	{
		int count=0;
		try {
			pst = connection.prepareStatement("select * from employee where employeeEmail=? and employeePassword=?");
			pst.setString(1, employeeEmail);
			pst.setString(2,employeePassword);
			
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
				count++;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return count;
	
}
}

