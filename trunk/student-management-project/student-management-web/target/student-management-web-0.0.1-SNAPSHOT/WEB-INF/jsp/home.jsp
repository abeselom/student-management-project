<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome to webapp</h1>
	<h2>Number Of Student: ${number}</h2>
<body>
	<h2>Student Manager</h2>
	<table border="1" cellpadding="0" cellspacing="0">
		<c:choose>
			<c:when test="${!empty studentList }">
				<p>Have many students</p>
			</c:when>
			<c:otherwise>
				<p>Project is empty now ^__^!!</p>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
</body>
</body>

</html>