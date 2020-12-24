<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java"%>
<%@ page session="true"%>
<%@ page import="employee.*"%>
<%
	GenerateId gen = new GenerateId();
	int emp_id = gen.generateEmployeeId();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Profile</title>
<link href="./css/mystyle.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function validateForm() {
		var myName = document.form1.emp_f_name.value;
		if (myName == "") {
			alert("First name cannot be blank");
			document.form1.emp_f_name.focus();
			return false;

		}
		myName = document.form1.emp_l_name.value;
		if (myName == "") {
			alert("Last name cannot be blank");
			document.form1.emp_l_name.focus();
			return false;
		}
		myName = document.form1.dob.value;
		if (myName == "") {
			alert("Date Of Birth cannot be blank");
			document.form1.dob.focus();
			return false;
		}
		myName = document.form1.address_1.value;
		if (myName == "") {
			alert("Address1 cannot be blank");
			document.form1.address_1.focus();
			return false;
		}
		myName = document.form1.city.value;
		if (myName == "") {
			alert("City cannot be blank");
			document.form1.city.focus();
			return false;
		}
		myName = document.form1.state.value;
		if (myName == "") {
			alert("State cannot be blank");
			document.form1.state.focus();
			return false;
		}
		myName = document.form1.level_id.value;
		if (myName == "Select Designation") {
			alert("You Should select a Designation");
			document.form1.level_id.focus();
			return false;
		}
		myName = document.form1.dept_id.value;
		if (myName == "Select Department") {
			alert("You Should select a Department");
			document.form1.dept_id.focus();
			return false;
		}
		myName = document.form1.dojoin.value;
		if (myName == "") {
			alert("Date of Join field cannot be blank");
			document.form1.dojoin.focus();
			return false;
		}
		myName = document.form1.nationality.value;
		if (myName == "Select Nationality") {
			alert("You Should select a Nationality");
			document.form1.nationality.focus();
			return false;
		}
		form1.submit();
	}
</script>
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
								<p>&nbsp;</p> Enter Profile Detail for New Employee.
								<hr width=100% color=#AAAAAA>

								<table border="0" align="top" width=100%>
									<form action="PeopleEmployee" name="form1" method="post">
										<input type='hidden' name='emp_id' id='emp_id ' size='10'
											value='<%=emp_id%>' />
									<tr>

										<td>Employee Id</td>
										<td align='left'><input type='text' disabled='disabled'
											name='emp_id' id='emp_id ' size='10' value='<%=emp_id%>' /></td>
										<td>&nbsp;</td>
										<td align='left'>&nbsp;</td>
									</tr>
									<tr>
										<td>First Name<sup>*</sup></td>
										<td><input type='text' name='emp_f_name' id='emp_f_name '
											size='10' value='' /></td>
										<td>Middle Name</td>
										<td><input type='text' name='emp_m_name' id='emp_m_name'
											size='10' value='' /></td>
										<td>Last Name<sup>*</sup></td>
										<td><input type='text' name='emp_l_name' id='emp_l_name'
											size='10' value='' /></td>
									</tr>
									<tr>
										<td>Org Id</td>
										<input type='hidden' name='org_id' id='org_id' size='10'
											value="NCU" />
										<td align='left'><input type='text' name='org_id_dup'
											id='org_id_dup' disabled='disabled' size='10' value="NCU" /></td>
										<td>Designation<sup>*</sup></td>
										<td align='left'><select name="level_id" id="level_id">
												<option value='select Designation' selected>Select
													Designation
												<option value='CW'>Content Writer
												<option value='TS'>Tester
												<option value='HR'>Human Resource Manager
												<option value='AC'>Accountant
												<option value='AM'>Admin Manager
												<option value='EM'>Event Manager
												<option value='TL'>Team Leader
												<option value='PM'>Project Manager
												<option value='TR'>Trainer
										</select></td>
										</td>
									</tr>
									<tr>
										<td>Department<sup>*</sup></td>
										<td align='left'><select id='dept_id' name='dept_id'>
												<option value='select Department' selected>Select
													Department
												<option value='CS'>Content Solutions
												<option value='TS'>Testing
												<option value='HR'>Human Resource
												<option value='AC'>Accounts
												<option value='AD'>Administration
												<option value='EM'>Event Management
										</select></td>
										<td>DOB<sup>*</sup></td>
										<td align='left'><input type='date' name='dob' id='dob'
											size='10' value='' /> (yyyy-mm-dd)</td>
									</tr>
									<tr>
										<td>JoinDate<sup>*</sup></td>
										<td align='left' colspan='2'><input type='date'
											name='dojoin' id='dojoin' size='10' value='' />(yyyy-mm-dd)</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Address1<sup>*</sup></td>
										<td align='left' colspan='2'><input type='text'
											name='address_1' id='address_1' size='40' value='' /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Address2</td>
										<td align='left' colspan='2'><input type='text'
											name='address_2' id='address_2' size='40' value='' /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>City<sup>*</sup></td>
										<td align='left'><input type='text' name='city' id='city'
											size='10' value='' /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>State <sup>*</sup></td>
										<td align='left'><input type='text' name='state'
											id='state' size='10' value='' /></td>
										<td>Nationality<sup>*</sup></td>
										<td align='left'><select name='nationality'
											id='nationality'>
												<option selected>Select Nationality
												<option value='IN'>Indian
												<option value='RS'>Russian
												<option value='PK'>Pakistani
												<option value='AM'>American
												<option value='BR'>British
												<option value='SR'>Srilankan
										</select></td>
									</tr>

									<tr>
										<td>All the ( <sup>*</sup>) marked are mandatory
										</td>
									</tr>
									<tr>
										<td align='center' colspan='4'><input type="submit"
											name="submit" id="submit" size="10" value="Submit"
											onClick="return validateForm()" /> <input type='hidden'
											name='action_submit' id='action_submit' size='10'
											value='people_employee_insert_submit' /></td>
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