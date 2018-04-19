package com.niit.skillMap.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("employeeId");
	        int employeeId = Integer.parseInt(id);
	        Employee employee = new Repository().getEmployeeById(employeeId);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);

	}

}
