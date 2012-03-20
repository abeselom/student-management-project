<%@ page import="java.util.*;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<body>
<head>
<link rel="stylesheet" href="Resources/css/displaytag.css"
	type="text/css" />
<link rel="stylesheet" href="Resources/css/screen.css" type="text/css" />
<link rel="stylesheet" href="Resources/css/site.css" type="text/css" />
</head>

<h1 align="center" style="color: olive;">List of Student</h1>


<display:table uid="student" name="sessionScope.userList" defaultsort="1"
	defaultorder="ascending" pagesize="10" requestURI="" export="true"
	sort="list">
	<display:column property="name" sortable="true" title="Student FullName"
		maxLength="25">
	</display:column>
	<display:column property="address" sortable="true" title="Student Address"
		maxLength="25" headerClass="sortable">

	</display:column>
	<display:column property="email" sortable="true" title="Email Address"
		maxLength="25" headerClass="sortable" />	
	<display:column>	
		<a href="/student-management-web/student/edit?username=${student.name}" >Edit</a>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="paging.banner.group_size" value="10" />
	<display:setProperty name="paging.banner.item_name" value="user" />
	<display:setProperty name="paging.banner.item_names" value="users" />
	<display:setProperty name="paging.banner.item_names" value="users" />


</display:table>
</form>
</body>