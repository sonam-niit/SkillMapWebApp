<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
	<tr><th>Id:</th><td>${requestScope.employee.employeeId}</td></tr>
	<tr><th>Name:</th><td>${requestScope.employee.employeeName}</td></tr>
	<tr><th>Email:</th><td>${requestScope.employee.employeeEmail}</td></td></tr>
	<tr><th>Phone:</th><td>${requestScope.employee.employeePhone}</td></td></tr>
	<tr><th>City:</th><td>${requestScope.employee.employeeCity}</td></tr>
	<tr><th>Qualification:</th><td>${requestScope.employee.employeeQualification}</td></tr>
	<tr><th>Skill Set:</th><td>${requestScope.employee.employeeSkill}</td></tr>
	<tr><th>Certification:</th><td>${requestScope.employee.employeeCertification}</td></tr>
	<tr><td colspan=2><a href="edit?employeeId=${requestScope.employee.employeeId}">Edit</a></td></tr>
	</table>
</body>
</html>