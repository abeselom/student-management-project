
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="SHORTCUT ICON"
	href="<c:url value="Resources/images/icon.ico"/>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<c:url value="Resources/js/jquery-1.5.1.min.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/jquery-ui-1.8.14.custom.min.js"/> "></script>
<link type="text/css" rel="stylesheet"
	href="<c:url value="Resources/css/jquery-ui-1.8.14.custom.css"/>"></link>
<script type="text/javascript"
	src="<c:url value="Resources/js/jquery.client.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/humane.js"/>"></script>
<link type="text/css" rel="stylesheet"
	href="<c:url value="Resources/css/style_1.css"/>"></link>
<link type="text/css" rel="stylesheet"
	href="<c:url value="Resources/css/default.css"/>"></link>
<script type="text/javascript">
	function LoginCheck() {
		var username = document.getElementById("txt_id");
		var password = document.getElementById("txt_pass");
		if (username.value == "" || password.value == "") {
			return false;
		}
		return true;
	}
</script>

<title>index</title>

</head>
<body>




	<div class="logo"></div>
	<div style="width: 100%">
		${result}
		<form action="/student-management-web/" name="loginForm" method="post"
			onsubmit="return LoginCheck();">
			<table style="width: 100%; text-align: center" border="0">
				<tr>
					<td style="width: 30%;">&nbsp;</td>
					<td colspan="2"><div class="logo_1"></div></td>
					<td style="width: 20%">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr>
					<td style="width: 30%">&nbsp;</td>
					<td><b> ID </b></td>
					<td>
						<div class="text">
							<input class="text_box" maxlength="40" type="text" name="txt_id"
								id="txt_id" onblur="textBoxOnKeyUp(this)"
								onkeyup="textBoxOnKeyUp(this) " />
						</div>
					</td>
					<td style="width: 30%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width: 30%">&nbsp;</td>
					<td><b> PASS </b></td>
					<td>
						<div class="text">
							<input class="text_box" maxlength="40" type="password"
								name="txt_pass" id="txt_pass" />
						</div>
					</td>
					<td style="width: 30%">&nbsp;</td>
				</tr>
				<tr>
					<td style="width: 30%">&nbsp;</td>
					<td align="left" colspan="3">
						<h4 style="color: red; margin-left: 30px;" id="lberror"></h4>
					</td>

				</tr>
				<tr>
					<td style="width: 30%">&nbsp;</td>
					<td>&nbsp;</td>
					<td style="text-align: left; padding-left: 50px"><div>
							<input type="submit"
								class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
								style="width: 150px; height: 35px; font-size: 12pt"
								name="btn_submit" id="btn_submit" value="Log in" />
						</div></td>
					<td style="width: 30%">&nbsp;</td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>
