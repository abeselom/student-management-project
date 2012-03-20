<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Class information</title>
</head>
<body>
	<h1>Show class information</h1>
	<table border="1" cellpadding="0" cellspacing="0">
		<c:choose>
			<c:when test="${!empty classesList }">
				<thead>
					<tr>
						<th>Class Id</th>
						<th>Date</th>
						<th>Subject</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${classesList}" var="classes">
						<tr>
							<td>${classes.clazz_ID}</td>
							<td>${classes.daytime}</td>
							<td>${classes.subject}</td>
							<td><a href="/student-management-web/classes/edit?classId=${classes.clazz_ID}">Edit</a></td>
							<td><a href="/student-management-web/classes/delete?classId=${classes.clazz_ID}">Delete</a></td>
							<td><a href="/student-management-web/classes/detail?classId=${classes.clazz_ID}">Detail</a></td>
						</tr>
					</c:forEach>
			</c:when>
			<c:otherwise>
				<p>No class in database</p>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<a href="/student-management-web/classes/add">Add</a>
</body>
</html>