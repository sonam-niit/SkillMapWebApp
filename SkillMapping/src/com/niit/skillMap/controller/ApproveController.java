package com.niit.skillMap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;

@WebServlet("/employee/employeeList")
public class ApproveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ttttt");
		if(request.getContextPath().equals("/employee/approve")) 
		{
		String id = request.getParameter("employeeId");
	        int employeeId = Integer.parseInt(id);        
	        Repository repository=new Repository();
	        Employee employee=new Employee();
	        employee.setStatus(true);
	        repository.updateEmployee(employee, employeeId);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/hr.jsp");
	        dispatcher.forward(request, response);
		}  
		if(request.getContextPath().equals("/employee/employeeList")) 
		{
		    System.out.println("heloo");  
	        Repository repository=new Repository();
	        List<Employee> list=repository.getAllEmployeeDetails();
	        request.setAttribute("employeeList", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/allDetails.jsp");
	        dispatcher.forward(request, response);
		}  
	}

}
