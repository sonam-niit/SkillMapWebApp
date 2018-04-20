<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="search">
	<input type="text" placeholder="enter a key to search" name="key">
	<input type="submit" value="Search"/>
	
	
<h2>All Details</h2> 
	<table border=1>
	<tr><th>Id:</th> <th>Name:</th> <th>Email:</th> <th>Phone:</th><th>City:</th>
	<th>Qualification:</th> <th>Skill Set:</th> <th>Certification:</th></tr>
	 <c:forEach var="employee" items="${requestScope.employeeList}" >
	<tr>
		<td>${employee.employeeId}</td>
		<td>${employee.employeeName}</td>
		<td>${employee.employeeEmail}</td>
		<td>${employee.employeePhone}</td>
		<td>${employee.employeeCity}</td>
		<td>${employee.employeeQualification}</td>
		<td>${employee.employeeSkill}</td>
		<td>${employee.employeeCertification}</td>
	</c:forEach>
	</table> 
</form>
</body>
</html>