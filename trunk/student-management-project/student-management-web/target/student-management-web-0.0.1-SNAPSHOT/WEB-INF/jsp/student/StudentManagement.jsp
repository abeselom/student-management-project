<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Student Management</title>
<link rel="SHORTCUT ICON"
	href="<c:url value="Resources/images/icon.ico"/>" />
<script type="text/javascript"
	src="<c:url value="Resources/js/jquery-1.5.1.min.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/jquery-ui-1.8.14.custom.min.js"/> "></script>
<link type="text/css" rel="stylesheet"
	href="<c:url value="Resources/css/jquery-ui-1.8.14.custom.css"/>"></link>
<script type="text/javascript"
	src="<c:url value="Resources/js/jquery.client.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/iscroll.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/humane.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/dialog_list_objects.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/common.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="Resources/js/studentInput.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="Resources/css/bold-light.css" media="all" />
<link rel="stylesheet" type="text/css" href="Resources/css/style_6.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="Resources/css/default.css"
	media="all" />

</head>
<body>
	<form method="post" action="studentmanagement">
		<div class="header">
			<div class="header_1">
				<div class="header_1_1">
					<div class="header_content_1">Student Management</div>
					<div class="header_content_2">
						<img src="Resources/images/logo.png" />
					</div>

				</div>
				<div class="header_1_2">
					<div class="div_button">
						<input type="submit" value="Close" class="button1"
							 />
					</div>
				</div>
			</div>
			<div style="clear: both"></div>
			<div class="header_1">
				<div class="header_1_2">
					<div class="div_button_1">
						<input type="button" value="Save" class="button1"
							onclick="SaveStudent();" />
					</div>
					`
				</div>
			</div>
		</div>
		<!--main -->
		<div style="clear: both"></div>
		<div class="main">
			<div class="box_header"></div>
			<div class="box_body">
				<h2>Student Information</h2>
				<!-- div box1 -->
				<div class="box_5">
					<div class="box_body_content">
						<div class="box_body_content_1">FullName:</div>
						<div class="box_body_content_2">
							<div class="div_text_box">
								<input type="text" class="text_box" id="fullnameID" name="fullnameID" />
							</div>
						</div>						
					</div>					
				</div>
				<!-- div box1 -->
				<div style="clear: both"></div>
				<!-- div box1 -->
				<div class="box_5">
					<div class="box_body_content">
						<div class="box_body_content_1">Email:</div>
						<div class="box_body_content_2">
							<div class="div_text_box">
								<input type="text" class="text_box" id="plantid" name="plantid" />
							</div>
						</div>						
					</div>					
				</div>
				<!-- div box1 -->
				<div style="clear: both"></div>
				<!-- div box1 -->
				<div class="box_5">
					<div class="box_body_content">
						<div class="box_body_content_1">Address</div>
						<div class="box_body_content_2">
							<div class="div_text_box">
								<input type="text" class="text_box" id="storeid" name="storeid" />
							</div>
						</div>						
					</div>					
				</div>
				<!-- div box1 -->
				<div style="clear: both"></div>
				<!-- div box1 -->
				<div class="box_5">						
				</div>
				<!-- div box1 -->
				<div style="clear: both"></div>			
				
			</div>
			<div class="box_footer"></div>

		</div>


	</form>
</body>
</html>
