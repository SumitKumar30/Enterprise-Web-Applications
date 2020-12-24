<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ page import="employee.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
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
							<td width="750" valign="top" align="center">
								<p>&nbsp;</p> Employee Detail
								<hr width=100% color=#AAAAAA>
								<table border="0" align="top" width=100%>

									<%
										EmployeeDBObj employeeDBObj = new EmployeeDBObj();
										employeeDBObj = (EmployeeDBObj) session.getAttribute("employeeDBObj");
									%>
									<form name="form1" method="post">
										<input type='hidden' name='emp_id' id='emp_id' size='10'
											value="<%=employeeDBObj.emp_id%>" /> <input type='hidden'
											name='emp_f_name' id='emp_f_name ' size='10'
											value="<%=employeeDBObj.emp_f_name%>" />
									
									<tr>
										<td>Employee Id</td>
										<td align='left'><input type='text' disabled='disabled'
											name='emp_id_dup' id='emp_id_dup' size='10'
											value="<%=employeeDBObj.emp_id%>" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
								
									<tr>
										<td>First Name</td>
										<td align='left'><input type='text' disabled='disabled'
											name='emp_f_name_dup' id='emp_f_name_dup' size='10'
											value="<%=employeeDBObj.emp_f_name%>" /></td>
										<td colspan=2>Middle Name&nbsp;&nbsp;&nbsp; <input
											type='text' name='emp_m_name' id='emp_m_name' size='10'
											value="<%=employeeDBObj.emp_m_name%>" />
											&nbsp;&nbsp;&nbsp;Last Name&nbsp;&nbsp;&nbsp; <input
											type='text' disabled='disabled' name='emp_l_name'
											id='emp_l_name' size='10'
											value="<%=employeeDBObj.emp_l_name%>" />
										</td>
									</tr>
									<tr>
										<td>Org Id</td>
										<td align='left'><input type='text' disabled='disabled'
											name='org_id' id='org_id' size='10'
											value="<%=employeeDBObj.org_id%>" /></td>
										<td>Designation</td>
										<td align='left'><input type='text' name='level_id'
											id='level_id' size='10' value="<%=employeeDBObj.level_id%>" />
										</td>
									</tr>
									<tr>
										<td>Dept</td>
										<td align='left'><input type='text' name='dept_id'
											id='dept_id' size='10' value="<%=employeeDBObj.dept_id%>" />
										</td>
										<td>DOB</td>
										<td align='left'><input type='text' disabled='disabled'
											name='dob' id='dob' size='10' value="<%=employeeDBObj.dob%>" />
											(yyyy-mm-dd)</td>
									</tr>
									<tr>
										<td>Join Date</td>
										<td align='left'><input type='text' disabled='disabled'
											name='dojoin' id='dojoin' size='10'
											value="<%=employeeDBObj.dojoin%>" /> (yyyy-mm-dd)</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Address1</td>
										<td align='left' colspan='2'><input type='text'
											name='address_1' id='address_1' size='40'
											value="<%=employeeDBObj.address_1%>" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Address2</td>
										<td align='left' colspan='2'><input type='text'
											disabled='disabled' name='address_2' id='address_2' size='40'
											value="<%=employeeDBObj.address_2%>" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>City</td>
										<td align='left'><input type='text' name='city' id='city'
											size='10' value="<%=employeeDBObj.city%>" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>State</td>
										<td align='left'><input type='text' name='state'
											id='state' size='10' value="<%=employeeDBObj.state%>" /></td>
										<td>Nationality</td>
										<td align='left'><input type='text' name='nationality'
											id='nationality' size='10'
											value="<%=employeeDBObj.nationality%>" /></td>
									</tr>
									<tr>
										<td align='center' colspan='4'><input type='submit'
											name='submit' id='submit' size='10' value='Edit' style="padding: 5px 35px;" /></td>
										<input type='hidden' name='action_edit' id='action_edit'
											size='10' value='people_employee_edit_submit' />
										</td>
									</tr>

								
								</table>
								<hr width=100% color=#AAAAAA>
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