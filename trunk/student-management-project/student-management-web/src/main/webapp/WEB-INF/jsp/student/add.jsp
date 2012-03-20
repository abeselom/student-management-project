<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<script type="text/javascript">
	function Validate() {
		var rs = new Boolean();
		rs = true;
		var name = document.getElementById("name");
		var address = document.getElementById("address");
		var email = document.getElementById("email");

		if (name.value == "") {
			document.getElementById("nameFail").innerHTML = "Please enter a name";
			rs = false;
		}
		if (address.value == "") {
			document.getElementById("addressFail").innerHTML = "Please enter a address";
			rs = false;
		}

		if (email.value == "") {
			document.getElementById("emailFail").innerHTML = "Please enter a email";
			rs = false;
		} else {
			var regMail = new RegExp(
					"\\b[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\\b");
			if (!email.match(regMail)) {
				var temp = document.getElementById("emailfail");
				temp.innerHTML = "Please enter a valid email";
				rs = false;
			}
		}

		return rs;
	}
</script>
</head>
<body>
	<h1>Add User</h1>
	<c:url var="addUrl" value="/student/add" />
	<h3>Insert Student's Information</h3>

	<form action="${addUrl}" method="post" name="addStudentForm"
		onsubmit="return Validate();">
		<table>
			<tr>
				<td>Student Name</td>
				<td><input name="name" id="name" type="text" /></td>
				<td><p id=nameFail></p></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email" /></td>
				<td><p id=emailFail></p></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" id="address" /></td>
				<td><p id=addressFail></p></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>