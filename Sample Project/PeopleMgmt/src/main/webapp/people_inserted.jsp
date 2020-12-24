<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link href="./css/mystyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="page-out">
		<div class="page-in">
			<div class="page">
				<div class="main">
					<%@ include file="./people_header.jsp"%>

					<table width="900" border="0" align="center">

						<tr>
							<td width="750" align="center" valign="top"><%@include
									file="/design.jsp"%> <%
 	String msg = (String) session.getAttribute("lErrorMsg");
 	if (msg != null && msg.length() > 0) {
 %> <%
 	out.println(msg);
 %> <br /> <%
 	}
 %> <a
								href="/PeopleMgmt/PeopleEmployee?todo=create"> Add More
									Employees </a> <br /> <a href="/PeopleMgmt/user_default.jsp">Goto
									Home Page </a></td>

						</tr>

					</table>

					<%@include file="./people_footer.jsp"%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>