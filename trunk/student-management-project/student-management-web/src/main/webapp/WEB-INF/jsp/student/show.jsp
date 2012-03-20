<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show user information</title>
<style type="text/css">
table th {
	text-align: left;
	padding: 8px;
	border-bottom: solid thin #cccccc;
	color: #999999;
}

table tr {
	text-align: left;
}

table tr:hover {
	background-color: 	#00FF00;
}

table td {
	padding: 10px;
}

a:link, a:visited, a:active, a:hover
{
    color: #e2004a; text-decoration: none; font-weight: normal;
}
</style>
</head>
<body>
	<h1>Show user information</h1>
	<table border="0" cellpadding="0" cellspacing="0">
		<c:choose>
			<c:when test="${!empty studentList }">
				<thead>
					<tr>
						<th>Student Id</th>
						<th>Student Name</th>
						<th>Address</th>
						<th>Email</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${studentList}" var="student">
						<tr>
							<td>${student.studentId}</td>
							<td>${student.name}</td>
							<td>${student.address}</td>
							<td>${student.email}</td>
							<td><a href="/student-management-web/student/edit?studentId=${student.studentId}">Edit</a></td>
							<td><a href="/student-management-web/student/delete?studentId=${student.studentId}">Delete</a></td>
							<td><a href="/student-management-web/student/detail?studentId=${student.studentId}">Detail</a></td>
						</tr>
					</c:forEach>
			</c:when>
			<c:otherwise>
				<p>No user in database</p>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<p><a href="/student-management-web/student/add">Add</a></p>
	<p><a href="/student-management-web/">Back</a></p>
</body>
</html>