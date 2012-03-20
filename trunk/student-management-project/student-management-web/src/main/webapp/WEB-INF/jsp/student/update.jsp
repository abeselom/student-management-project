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
	<h1>Edit user</h1>
	<c:url var="addUrl" value="/student/edit" />
	<h3>Insert User Project's Information</h3>
	
	<form action="${addUrl}" method="post" name="updateStudentForm" onsubmit="">
		<input name="studentId" type="hidden" value="${student.studentId }"/>
		<table>
			<tr>
				<td>Student Name</td>
				<td><input name="name" type="text" value="${student.name }"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${student.email }"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input name="address" type="text" value="${student.address }"/></td>
			</tr>
			<tr>
				<td>Class</td>
				<td>
					<select name="classId">
						<option>Choose...</option>
						<c:forEach items="${classList}" var="classes">
							<option value="${classes.clazz_ID}">${classes.subject}</option>
						</c:forEach>
					</select>
				</td>
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