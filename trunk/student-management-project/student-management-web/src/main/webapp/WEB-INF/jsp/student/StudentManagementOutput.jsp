<%@ page import="java.util.*;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<body>
<head>
<link rel="stylesheet" href="Resources/css/displaytag.css"
	type="text/css" />
<link rel="stylesheet" href="Resources/css/screen.css" type="text/css" />
<link rel="stylesheet" href="Resources/css/site.css" type="text/css" />
<script type="text/javascript">
	function editStudent() {

		var stuId = ${test.id;}

		var sendData = "stuID=" + stuId;
		$.ajax({
			type : "GET",
			url : 'studentEdit', //'/login.htm', 
			data : sendData,
			success : function(msg) {
				alert("jialghhggk");
			}
		});

	}
</script>
</head>

<h1 align="center" style="color: olive;">List of Student</h1>


<display:table uid="user" name="sessionScope.userList" defaultsort="1"
	defaultorder="ascending" pagesize="10" requestURI="" export="true"
	sort="list">
	<display:column property="id" sortable="true" title="Student ID"
		maxLength="25">
	</display:column>
	<display:column property="fullname" sortable="true" title="Full Name"
		maxLength="25" headerClass="sortable">

	</display:column>
	<display:column property="email" sortable="true" title="Email Address"
		maxLength="25" headerClass="sortable" />
	<display:column property="phone" sortable="true" title="PhoneNumber"
		maxLength="25" />
	<display:column>
		<input type="button" value="Edit" onclick="editStudent();">
		<%-- <a href="editStudent();" />Edit--%>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="paging.banner.group_size" value="10" />
	<display:setProperty name="paging.banner.item_name" value="user" />
	<display:setProperty name="paging.banner.item_names" value="users" />
	<display:setProperty name="paging.banner.item_names" value="users" />


</display:table>
</form>
</body>