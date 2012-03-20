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
		var username = document.getElementById("userName");
		var password = document.getElementById("password");
		var retypepassword = document.getElementById("retypepassword");
		var email = document.getElementById("email");

		if (username.value == "") {
			document.getElementById("usernameFail").innerHTML = "Please enter a username";
			rs = false;
		}
		if (password.value == "") {
			document.getElementById("passwordFail").innerHTML = "Please enter a password";
			rs = false;
		}
		if (retypepassword.value == "") {
			document.getElementById("retypepasswordFail").innerHTML = "Please enter retype password";
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

		if (password.value != retypepassword.value) {
			document.getElementById("passwordFail").innerHTML = "Password does not match";
			password.value = "";
			retypepassword.value = "";
			rs = false;
		}
		return rs;
	}
</script>
</head>
<body>
	<h1>Add User</h1>
	<c:url var="addUrl" value="/student-management-web/user/add" />
	<h3>Insert User Project's Information</h3>

	<form action="${addUrl}" method="post" name="addUserForm"
		onsubmit="return Validate();">
		<table>
			<tr>
				<td>Username</td>
				<td><input name="userName" id="userName" type="text" /></td>
				<td><p id="usernameFail"></p></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="password" name="password" /></td>
				<td><p id="passwordFail"></p></td>
			</tr>
			<tr>
				<td>Retype password</td>
				<td><input type="password" id="retypepassword"
					name="retypepassword" /></td>
				<td><p id="retypepasswordFail"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="email" id="email" type="text" /></td>
				<td><p id="emailFail"></p></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><select name="selection">
						<option value="1">Admin</option>
						<option value="2">User</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>