<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ page import="employee.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet" href="./css/mystyle.css" type="text/css" />
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
							<td width="750" valign="top">
								<div align=center class=boldblack>List of Employees</div>
								<hr bgcolor="#AAAAAA">
								<table border="0" width=100%>
									<%!EmployeeDBObj employeeDBObj;
									ArrayList employeeList; // = new ArrayList();
									%>
									<%
										String todo = "";
										todo = (String) session.getAttribute("todo");
									%>
									<tr class="whitetext" height=20>
										<td bgcolor='#AAAAAA'>Emp Id</td>
										<td bgcolor='#AAAAAA'>F Name</td>
										<td bgcolor='#AAAAAA'>L Name</td>
										<td bgcolor='#AAAAAA'>Designation</td>
										<td bgcolor='#AAAAAA'>DOB</td>
										<td bgcolor='#AAAAAA' align='center'>Edit</td>
										<td bgcolor='#AAAAAA' align='center'>Delete</td>
									</tr>

									<%
										employeeList = new ArrayList();
										employeeList = (ArrayList) session.getAttribute("EmployeeList");
										if (employeeList != null && employeeList.size() > 0) {
											for (int size = 1; size <= employeeList.size(); size++) {
												employeeDBObj = new EmployeeDBObj();
												employeeDBObj = (EmployeeDBObj) employeeList.get(size - 1);
												System.out.println(employeeDBObj.emp_f_name);
									%>
									<form name="form1" method="post">
										<tr bgcolor='#AAAAAA' height=18>
											<td align='left'><%=employeeDBObj.emp_id%></td>
											<td align='left'><%=employeeDBObj.emp_f_name%></td>
											<td align='left'><%=employeeDBObj.emp_l_name%></td>
											<td align='left'><%=employeeDBObj.level_id%></td>
											<td align='left'><%=employeeDBObj.dob%></td>
											<td align='center' bgcolor="#AAAAAA"><a
												href='/PeopleMgmt/PeopleEmployee?todo=edit'
												class="yellowlink">Edit </a></td>
											<td align='center' bgcolor="#AAAAAA"><a
												href='/PeopleMgmt/PeopleEmployee?todo=delete&&emp_id=<%=employeeDBObj.emp_id%>'
												class="yellowlink">Delete </a></td>
											<%
												}
												}
											%>
										</tr>
									
								</table>
						</tr>
						<tr>
								<td align='center' colspan='4'>
								<button type="button" name="back" onclick="history.back()">Back</button>
								</td>
						</tr>
						</table>
						<%@include file="./people_footer.jsp"%>
				</div>
			</div>
		</div>
	</div>

</body>
</html>