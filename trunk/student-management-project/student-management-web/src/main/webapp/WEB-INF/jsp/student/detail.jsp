<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information Detail</title>
</head>
<body>
	<h1>Student Information Detail</h1>
	<h2>Name of Student: ${student.name}</h2>
	<ul>
		<li>Student Id: ${student.studentId}</li>
		<li>Student Email: ${student.email}</li>
		<li>Student Address: ${student.address}</li>
		<c:if test="${!empty classList }">
		<li>Classes Of Student:</li>
			<ul>
				<c:forEach items="${classList}" var="classes">
					<li>
						<p>Class Id: ${classes.clazz_ID}</p>
						<p>Subject: ${classes.subject}</p>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</ul>
	<a href="/student-management-web/student/">Back</a>
</body>
</html>