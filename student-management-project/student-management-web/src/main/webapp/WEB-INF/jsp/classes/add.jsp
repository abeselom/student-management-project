<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Class</title>
<style type="text/css">
table, td, th
{
border:0px solid green;
}
td
{
font-size: 20px;

}
th
{
background-color:green;
color:white;
}
</style>
<script type="text/javascript">
	// check date
	var dtCh = "/";
	var currentTime = new Date();
	var minYear = 1900;
	var maxDate = currentTime.getDate();
	var maxMonth = currentTime.getMonth() + 1;
	var maxYear = currentTime.getFullYear();

	function isInteger(s) {
		var i;
		for (i = 0; i < s.length; i++) {
			// Check that current character is number.
			var c = s.charAt(i);
			if (((c < "0") || (c > "9")))
				return false;
		}
		// All characters are numbers.
		return true;
	}

	function stripCharsInBag(s, bag) {
		var i;
		var returnString = "";
		// Search through string's characters one by one.
		// If character is not in bag, append to returnString.
		for (i = 0; i < s.length; i++) {
			var c = s.charAt(i);
			if (bag.indexOf(c) == -1)
				returnString += c;
		}
		return returnString;
	}

	function daysInFebruary(year) {
		// February has 29 days in any year evenly divisible by four,
		// EXCEPT for centurial years which are not also divisible by 400.
		return (((year % 4 == 0) && ((!(year % 100 == 0)) || (year % 400 == 0))) ? 29
				: 28);
	}
	function DaysArray(n) {
		for ( var i = 1; i <= n; i++) {
			this[i] = 31
			if (i == 4 || i == 6 || i == 9 || i == 11) {
				this[i] = 30
			}
			if (i == 2) {
				this[i] = 29
			}
		}
		return this
	}

	function isDate(dtStr) {
		var daysInMonth = DaysArray(12)
		var pos1 = dtStr.indexOf(dtCh)
		var pos2 = dtStr.indexOf(dtCh, pos1 + 1)
		var strMonth = dtStr.substring(0, pos1)
		var strDay = dtStr.substring(pos1 + 1, pos2)
		var strYear = dtStr.substring(pos2 + 1)
		strYr = strYear
		if (strDay.charAt(0) == "0" && strDay.length > 1)
			strDay = strDay.substring(1)
		if (strMonth.charAt(0) == "0" && strMonth.length > 1)
			strMonth = strMonth.substring(1)
		for ( var i = 1; i <= 3; i++) {
			if (strYr.charAt(0) == "0" && strYr.length > 1)
				strYr = strYr.substring(1)
		}
		month = parseInt(strMonth)
		day = parseInt(strDay)
		year = parseInt(strYr)
		if (pos1 == -1 || pos2 == -1) {
			document.getElementById("datestring").innerHTML = "The date format should be : mm/dd/yyyy";
			return false
		}
		if (strMonth.length < 1 || month<1 || month>maxMonth) {
			document.getElementById("datestring").innerHTML = "Please enter a valid month(less more current month)";
			return false
		}
		if (strDay.length < 1 || day<1 || day>maxDate
				|| (month == 2 && day > daysInFebruary(year))
				|| day > daysInMonth[month]) {
			document.getElementById("datestring").innerHTML = "Please enter a valid day (less more current date)";
			return false
		}
		if (strYear.length != 4 || year == 0 || year<minYear || year>maxYear) {
			document.getElementById("datestring").innerHTML = "Please enter a valid 4 digit year between "
					+ minYear + " and " + maxYear
			return false
		}
		if (dtStr.indexOf(dtCh, pos2 + 1) != -1
				|| isInteger(stripCharsInBag(dtStr, dtCh)) == false) {
			document.getElementById("datestring").innerHTML = "Please enter a valid date";
			return false
		}
		return true
	}

	function ValidateDate() {
		var dt = document.getElementById("date").value;
		if (isDate(dt) == false) {
			dt.focus()
			document.getElementById("dateFail").innerHTML = "date does not correct";
			return false;
		}
		return true;
	}

	function Validate() {
		var rs = new Boolean();
		rs = true;
		var date = document.getElementById("date");
		var subject = document.getElementById("subject");

		rs = ValidateDate();
		if (subject.value == "") {
			document.getElementById("subjectFail").innerHTML = "subject can not be empty";
			rs = false;
		}
		return rs;
	}
</script>
</head>
<body>
	<h1>Add Class</h1>
	<c:url var="addUrl" value="/classes/add" />
	<h3>Insert Information Of Class</h3>

	<form action="${addUrl}" method="post" name="addClassForm"
		onsubmit="return Validate();">
		<table>
			<tr>
				<td>Date:</td>
				<td><input name="date" id="date" type="text" /></td>
				<td id="dateFail"></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input type="text" name="subject" id="subject" /></td>
				<td  id="subjectFail"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>