<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Class Information Detail</title>
</head>
<body>
	<h1>Class Information Detail</h1>
	<h2>Number of Student: ${number}</h2>
	<ul>
		<li>Class Id: ${clazz.clazz_ID}</li>
		<li>Class Subject: ${clazz.subject}</li>
		<li>Class Date: ${clazz.daytime}</li>
		<c:if test="${!empty studentList }">
		<li>Student:</li>
			<ul>
				<c:forEach items="${studentList}" var="student">
					<li>
						<p>Student Name: ${student.name}</p>
						<p>Student Email: ${student.email}</p>
						<p>Student Address: ${student.address}</p>
						<a href="/student-management-web/classes/unenroll?classId=${clazz.clazz_ID}&&studentId=${student.studentId}">Delete</a>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</ul>
	<a href="/student-management-web/classes/">Back</a>
</body>
</html>