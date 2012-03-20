<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student</title>
</head>
<body>
	<h1>Edit Student</h1>
	<c:url var="addUrl" value="/student/edit" />
	<h3>Insert Student Project's Information</h3>
	
	<form action="${addUrl}" method="post" name="updateUserForm" onsubmit="">
		<table>
			<tr>
				<td>FullName:</td>
				<td><input name="userName" type="text" value="${student.name }"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${student.email }"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input name="email" type="text" value="${student.address }"/></td>
			</tr>			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" value="Update"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>