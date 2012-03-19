<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<h1>Add User</h1>
	<c:url var="addUrl" value="/student-management-web/user/add" />
	<h3>Insert User Project's Information</h3>
	
	<form action="${addUrl}" method="post" name="addUserForm" onsubmit="">
		<table>
			<tr>
				<td>Username</td>
				<td><input name="userName" type="text"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>Retype password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="email" type="text"/></td>
			</tr>
			<tr>
				<td>Type</td>
				<td>
					<select name="selection">
						<option value="1">Admin</option>
						<option value="2">User</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>