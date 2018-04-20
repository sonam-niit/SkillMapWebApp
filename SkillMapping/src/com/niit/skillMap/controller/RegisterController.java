package com.niit.skillMap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> errorList=new ArrayList<>();
    public RegisterController() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int employeeId=Integer.parseInt(request.getParameter("eid"));
		String employeeName=request.getParameter("name");
		String employeeEmail=request.getParameter("email");
		String employeePhone=request.getParameter("phone");
		String employeeCity=request.getParameter("city");
		String employeeQualification=request.getParameter("qualification");
		String employeeSkill=request.getParameter("skill");
		String employeeCertification=request.getParameter("certification");
		String employeePassword=request.getParameter("password");
		String employeeRole=request.getParameter("role");
		
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeeEmail(employeeEmail);
		employee.setEmployeePhone(employeePhone);
		employee.setEmployeeCity(employeeCity);
		employee.setEmployeeQualification(employeeQualification);
		employee.setEmployeeSkill(employeeSkill);
		employee.setEmployeeCertification(employeeCertification);
		employee.setEmployeePassword(employeePassword);
		employee.setEmployeeRole(employeeRole);
		employee.setStatus(false);
		errorList=employee.getMap();
		System.out.println(errorList);
		int status=0;
		if(errorList.size()==0)
		{			
			Repository repository=new Repository();
			status=repository.insert(employee);
			System.out.println("No insertion "+status);
	
		}
		if(status>0)
		{
			response.getWriter().println("Successfully registered Try to login");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			requestDispatcher.include(request, response);
		}
		else
		{
			request.setAttribute("error", errorList);
			request.setAttribute("employee", employee);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/register.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/register.jsp");
		requestDispatcher.forward(request, response);
	}

}
