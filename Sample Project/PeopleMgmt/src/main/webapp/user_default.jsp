<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/mystyle.css" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="page-out">
		<div class="page-in">
			<div class="page">
				<div class="main">
					<div class="header">
						<div class="header-top">
							<h1>
								Human Resource <span>Management</span>
							</h1>
						</div>
						<div class="header-bottom">
							<h2>
								Deck your hearts with lights of success.....<br> Sure!!
								that you will reach your destiny.
							</h2>
						</div>
						<div class="topmenu">
							<ul>
								<li
									style="background: transparent none repeat scroll 0% 50%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; padding-left: 0px;"><a
									href="#"><span>Home</span></a></li>
								<li><a href="#"><span>About&nbsp;us</span></a></li>
								<li><a href="#"><span>Contact&nbsp;us</span></a></li>
								<li><a href="./employee_insert.jsp"
									title="for new candidates only"><span>Employee
											Registration</span></a></li>
								<li><a href="/PeopleMgmt/time_management?todo=daily_attendance_summary" title="Enter/Update Employee Time In Time Out"><span>Time
											Management</span></a></li>
								<li><a href="/PeopleMgmt/UserLogin?todo=logout" title="Log out to home page"><span>Log Out
											</span></a></li>

							</ul>
						</div>
					</div>
					<%-- <%@ include file="./people_header.jsp"%> --%>
					<div class="content">
						<div class="content-left">
							<div class="row1">
								<h1 class="title">
									<%
										String name = (String) session.getAttribute("user_name");
										if (name != null && name.length() > 0) {
											out.println("Hello, <span>" + name + "</span>");
										}
									%>
								</h1>
								<p>
									<strong>Check Modules</strong>
								</p>
							</div>
							<div class="row2">
								<ul>
									<li><a href="./employee_insert.jsp"
										title="for registered employee's only">Employee
											Registration</a></li>
									<li><a href="./employee_search.jsp" title="for registered company's only">Search
											Employee Details</a></li>
									<li><a href="#">Edit Employee Details</a></li>
									<li><a href="/PeopleMgmt/PeopleEmployee?todo=show">View Employee Details</a></li>
									<li><a href="./employee_search.jsp">View Employee Profile</a></li>
									<li><a href="/PeopleMgmt/time_management?todo=daily_attendance_entry">Enter / Update Attendance</a></li>
									<li><a href="/PeopleMgmt/time_management?todo=daily_attendance_summary">Employee Attendance Summary</a></li>
									<li><a href="#">this is a dummy link 8</a></li>
									<li><a href="#">this is a dummy link 9</a></li>
									<li><a href="#">this is a dummy link 10</a></li>
								</ul>
								<%
									String msg = (String) session.getAttribute("lErrorMsg");
									if (msg != null && msg.length() > 0) {

										out.println("<div class=boldred>" + msg + "</div>");

									}
								%>

							</div>

						</div>
						<div class="content-right">
							<div class="contact">
								<h2 class="sidebar2">Contact</h2>
								<div class="contact-detail">
									<p class="green">
										<strong>Lorem Ipsum is simply dummy text</strong>
									</p>
									<p>
										<strong>Adress :</strong> Lorem Ipsum has been the<br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dummy
										text the 1500s,
									</p>
									<p>
										<strong>E-mail :</strong> &nbsp;&nbsp;&nbsp;when an unknown
										printer took a
									</p>
									<p>
										<strong>Phone :</strong> &nbsp;&nbsp;&nbsp;00-0000000000<br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;000-0000-0000
									</p>
								</div>
							</div>
						</div>
					</div>
					<%@include file="./people_footer.jsp"%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>