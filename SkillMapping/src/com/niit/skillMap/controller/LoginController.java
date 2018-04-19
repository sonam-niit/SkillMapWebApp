package com.niit.skillMap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String employeeEmail=request.getParameter("email");
		String employeePassword=request.getParameter("password");
		
		Repository repository=new Repository();
		int count=repository.validateEmployee(employeeEmail,employeePassword);
		if(count>0)
		{
			Employee employee=repository.getEmployeeDetails(employeeEmail);
			request.setAttribute("employee", employee);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/mydata.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			out.println("Wrong Username or Password try to login again");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			requestDispatcher.include(request, response);
		}
			
		
	}

}
