package com.niit.skillMap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;

@WebServlet("/updateProfile")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		
		Repository repository=new Repository();
		int status=repository.updateEmployee(employee, employeeId);
		if(status>0)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mydata.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);
			
		}
	}

}
