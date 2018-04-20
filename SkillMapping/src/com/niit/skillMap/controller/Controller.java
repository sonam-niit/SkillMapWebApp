package com.niit.skillMap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Repository repository;
	public Controller() {
		repository=new Repository();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		RequestDispatcher dispatcher;
		switch(path)
		{
		case "/login":
			loginEmployee(request, response);
			break; 
		case "/register":
			registerEmployee(request, response);
			break;
		case "/search":
			searchEmployee(request, response);
			break;
		case "/approve":
			approveEmployee(request, response);
			break;
		case "/approvalPending":
			pendingEmployee(request, response);
			break;
		case "/registerPage":
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
			dispatcher.forward(request, response);
			break;
		case "/edit":
				editEmployee(request, response);
				break;
		case "/delete":
			deleteEmployee(request, response);
			break;
		case "/profile":
			getProfile(request, response);
			break;
		case "/viewAll":
			viewAllEmployee(request, response);
			break;
		case "/updateProfile":
			updateEmployee(request, response);
			break;	
				
		default:	
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
			break;
		}	
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void viewAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	List<Employee> list=repository.getAllEmployeeDetails();
	        request.setAttribute("employeeList", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/allDetails.jsp");
	        dispatcher.forward(request, response);

	}
	protected void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String key = request.getParameter("key");
	        List<Employee> list = new Repository().getAllApprovedEmployee(key);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employer.jsp");
	        request.setAttribute("employeeList", list);
	        dispatcher.forward(request, response);

}
	protected void approveEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("employeeId");
	        int employeeId = Integer.parseInt(id);
	        Employee employee=new Employee();
	        employee.setStatus(true);
	        repository.approveEmployee(employeeId);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/hr.jsp");
	        dispatcher.forward(request, response);

}
	protected void pendingEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	List<Employee> list=repository.getAllPendingDetails();
        request.setAttribute("employeeList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/approve.jsp");
        dispatcher.forward(request, response);

}
	protected void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("employeeId");
	        int employeeId = Integer.parseInt(id);
	        Employee employee = new Repository().getEmployeeById(employeeId);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employer.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);

	}
	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId=Integer.parseInt(request.getParameter("employeeId"));
		int count=repository.deleteEmployee(employeeId);
		if(count>0)
		{
		request.setAttribute("message", employeeId+" deleted");
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAll");
        dispatcher.forward(request, response);
		}


	}
	protected void getProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("employeeId");
	        int employeeId = Integer.parseInt(id);
	        Employee employee = new Repository().getEmployeeById(employeeId);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mydata.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);

	}

	protected void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String employeeEmail=request.getParameter("email");
		String employeePassword=request.getParameter("password");

		int count=repository.validateEmployee(employeeEmail,employeePassword);
		if(count>0)
		{
			HttpSession session=request.getSession();
			Employee employee=repository.getEmployeeDetails(employeeEmail);
			if(employee.getEmployeeRole().equals("hr"))
			{	
				request.setAttribute("employee", employee);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/hr.jsp");
				requestDispatcher.forward(request, response);
			}
			if(employee.getEmployeeRole().equals("employee"))
			{	
				request.setAttribute("employee", employee);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/mydata.jsp");
				requestDispatcher.forward(request, response);
			}
			if(employee.getEmployeeRole().equals("employer"))
			{	
				session.setAttribute("employee", employee);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/employer.jsp");
				requestDispatcher.forward(request, response);
			}
			
		}
		else
		{
			request.setAttribute("message","Wrong Username or Password try to login again");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			requestDispatcher.forward(request, response);
		}
			
		
	}
	
	
	protected void registerEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList=new ArrayList<>();
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
			status=repository.insert(employee);
			System.out.println("No insertion "+status);
	
		}
		if(status>0)
		{
			request.setAttribute("message", "Successfully Registered Try to login!");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("error", errorList);
			request.setAttribute("employee", employee);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/register.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
	protected void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		int employeeId=Integer.parseInt(request.getParameter("eid"));
		String employeeName=request.getParameter("name");
		String employeePhone=request.getParameter("phone");
		String employeeEmail=request.getParameter("email");
		String employeeCity=request.getParameter("city");
		String employeeQualification=request.getParameter("qualification");
		String employeeSkill=request.getParameter("skill");
		String employeeCertification=request.getParameter("certification");
		
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeePhone(employeePhone);
		employee.setEmployeeEmail(employeeEmail);
		employee.setEmployeeCity(employeeCity);
		employee.setEmployeeQualification(employeeQualification);
		employee.setEmployeeSkill(employeeSkill);
		employee.setEmployeeCertification(employeeCertification);
		
		int status=repository.updateEmployee(employee, employeeId);
		if(status>0)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mydata.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);
			
		}
	}
	

}
