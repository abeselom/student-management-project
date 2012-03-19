<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit user</title>
</head>
<body>
	<h1>Edit class</h1>
	<c:url var="addUrl" value="/classes/edit" />
	<h3>Insert Information Of Class</h3>
	
	<form action="${addUrl}" method="post" name="updateClassForm" onsubmit="">
		<input name="classId" type="hidden" value="${class.clazz_ID }"/>
		<table>
			<tr>
				<td>Date:</td>
				<td><input name="date" type="text" value="${class.daytime }"/></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input type="text" name="subject" value="${class.subject }"/></td>
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