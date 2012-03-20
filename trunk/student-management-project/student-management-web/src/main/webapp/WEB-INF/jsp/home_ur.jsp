<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MainMenu</title>
<link rel="SHORTCUT ICON" href="<c:url value="Resources/images/icon.ico"/>"/>
<link rel="stylesheet" type="text/css" href="Resources/css/default.css" media="all" />
<link rel="stylesheet" type="text/css" href="Resources/css/style_2.css" media="all" />
 <script type="text/javascript"  src="Resources/js/jquery-1.5.1.js"></script>
  <script type="text/javascript">
  function Class_Manage()
  {
	  $(location).attr('href',"/student-management-web/classes/");
  }
  function Permission_Manage()
  {
	  $(location).attr('href',"/student-management-web/user/");
  }
   function Subject_Manage()
  {
	  $(location).attr('href',"/student-management-web/classes/");
  }
     function Student_Manage()
  {
	  $(location).attr('href',"/student-management-web/student/");
  }
 
  </script>
</head>

<body>
   
   <div style="width: 100%;margin-top: 20px;" align="right">
            <span style='cursor: pointer' class="link" onclick="window.location='/student-management-web/logout'">&nbsp;<label>Log out</label> &nbsp;</span>
        </div>
 <div class="logo">
    <div class="logo_1"></div>
    <div class="logo_2">
        <div class="button" align="center"><input type="submit" class="button_1" onclick="Student_Manage()"   name="button_1" value="Student Management"/></div>    
   </div>
 </div>
</body>
</html>
