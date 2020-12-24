

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.EmployeeDBObj;
import employee.EmployeeDBMethods;

/**
 * Servlet implementation class PeopleEmployee
 */
public class PeopleEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String lDBUser = "";
	String lDBPswd = "";
	String lDBUrl = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeopleEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("initializing controller servlet.");
		ServletContext context = config.getServletContext();
//		Class.forName("com.mysql.cj.jdbc.Driver");
		lDBUser = "root";
		lDBPswd = "Admin@12345";
		lDBUrl = "jdbc:mysql://localhost:3306/people";
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("lErrorMsg",null);
		String target = "";
		String action = request.getParameter("action");
		String todo = "";
		EmployeeDBMethods employeeDBMethods = new EmployeeDBMethods(lDBUser,lDBPswd,lDBUrl);
		todo = (String)request.getParameter("todo");
		if( (todo != null && todo.length() > 0) && (todo.equals("create")) ){
			target = "/employee_insert.jsp";
		}
		else if( (todo != null && todo.length() > 0) && (todo.equals("edit")) ){
			target = "/employee_search.jsp";
		}
		else if( (todo != null && todo.length() > 0) && (todo.equals("show")) ){
			ArrayList employeeList = new ArrayList();
			String criteria = "";
			employeeList = (ArrayList)employeeDBMethods.selectEmployeeByCriteria(criteria);
			session.setAttribute("EmployeeList",employeeList);
			target = "/employee_list.jsp";			
			
		} 
	else if ( (todo != null && todo.length() > 0) && (todo.equals("delete")) ){
		String emp_Id = "";
		emp_Id = (String)request.getParameter("emp_id");
		employeeDBMethods.deleteEmployee(emp_Id);
		String criteria = "";
		ArrayList employeeList = new ArrayList();
		employeeList = (ArrayList)employeeDBMethods.selectEmployeeByCriteria(criteria);
		session.setAttribute("EmployeeList",employeeList);
		target = "/employee_list.jsp";
	}
	String action_submit = request.getParameter("action_submit");
    String action_edit = request.getParameter("action_edit");
	System.out.println("action_submit=="+action_submit);
	if ( action_submit != null || action_edit != null ){
		if ( request.getParameter("submit").equals("Submit") ){
			System.out.println("in the  Submit");
			if ( action_submit.equals("people_employee_insert_submit") ){
				System.out.println("in the people_employee_insert_submit ");
				action = "people_employee_insert_submit";
			}
			else
				if (action_submit.equals("login_pswd_change_submit")){
					action = "login_pswd_change_submit";
				}
				else
					if (action_submit.equals("people_employee_search_submit")){
						action = "people_employee_search_submit";
					}
		}
		else 
			if ( request.getParameter("submit").equals("Edit") ){
				if ( action_edit.equals("people_employee_edit_submit") ){
					action = "people_employee_edit_submit";

					EmployeeDBObj popEmployeeDBObj = new EmployeeDBObj();
						popEmployeeDBObj = (EmployeeDBObj)employeeDBMethods.populateEmployeeDBObjFromReq(request);
						int rval;
						try {
							rval = employeeDBMethods.updateEmployeeByPrimaryKey(popEmployeeDBObj);
						
						if ( rval > 0 ){ // record updated successfully  
							EmployeeDBObj employeeDBObj = new EmployeeDBObj();
                			employeeDBObj = (EmployeeDBObj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.emp_id,popEmployeeDBObj.emp_f_name);
							session.setAttribute("employeeDBObj",employeeDBObj);
							String lErrorMsg = "Employee is Updated!!"; 
							session.setAttribute("lErrorMsg",lErrorMsg);
							target = "/employee_list.jsp";// "/jsp/employee_edit.jsp";
						}
					}catch(ParseException e) {
						e.printStackTrace();
					}
				}
						
			}
	}
	if (action!=null){
		System.out.println("in the  "+action);
		if (action.equals("people_employee_search_submit")){
			String lEmpId = "";
			String lEmpFName = "";
			lEmpId = (String)request.getParameter("emp_id");
			lEmpFName = (String)request.getParameter("emp_f_name");
           		EmployeeDBObj employeeDBObj = new EmployeeDBObj();
			employeeDBObj = (EmployeeDBObj)employeeDBMethods.getRecordByPrimaryKey(lEmpId,lEmpFName);
			System.out.println("iiiii="+employeeDBObj.emp_id+"ffff="+employeeDBObj.emp_f_name);
			if ( (employeeDBObj.emp_id != null && employeeDBObj.emp_f_name != null) ){
				session.setAttribute("employeeDBObj",employeeDBObj);
				target = "/employee_edit.jsp";
			}
			else{
				String lErrorMsg = "Employee doesn't Exist"; 
				session.setAttribute("lErrorMsg",lErrorMsg);
				System.out.println("Employee:" + lErrorMsg);
				target = "/user_default.jsp"; 
			    }
		}   
		else
			if (action.equals("people_change_pswd_submit")){
				target = "/people_user_login_pswd_change.jsp";
			}
			else
				if (action.equals("people_employee_insert_submit")){
					EmployeeDBObj popEmployeeDBObj = new EmployeeDBObj(); 
					popEmployeeDBObj = (EmployeeDBObj)employeeDBMethods.populateEmployeeDBObjFromReq(request);
					EmployeeDBObj employeeDBObj = new EmployeeDBObj();
					employeeDBObj = (EmployeeDBObj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.emp_id,popEmployeeDBObj.emp_f_name);
					if ( (popEmployeeDBObj.emp_id).equals(employeeDBObj) && (popEmployeeDBObj.emp_f_name).equals(employeeDBObj.emp_f_name) ){
						String lErrorMsg = "Employee Already Exist"; 
						session.setAttribute("lErrorMsg",lErrorMsg);
						System.out.println("Employee:" + lErrorMsg);
						target = "/user_default.jsp";
					}
					else{
						try {
							int rval =  employeeDBMethods.insertEmployee(popEmployeeDBObj);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						EmployeeDBObj sEmployeeDBObj = new EmployeeDBObj();
						sEmployeeDBObj = (EmployeeDBObj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.emp_id,popEmployeeDBObj.emp_f_name);
						session.setAttribute("employeeDBObj",sEmployeeDBObj);
						String lErrorMsg = "Employee is Added!!"; 
						session.setAttribute("lErrorMsg",lErrorMsg);
						target = "/people_inserted.jsp";  
						}
	
  					}   
				else
					if (action.equals("people_employee_edit_submit")){ 
						ArrayList employeeList = new ArrayList();
						String criteria="";
						employeeList = (ArrayList)employeeDBMethods.selectEmployeeByCriteria(criteria);
						session.setAttribute("EmployeeList",employeeList);
						target = "/employee_list.jsp";
						
						int rval = 0;
						
						if ( rval > 0 ){   
							
						}
						
				else
					if (action.equals("people_employee_detail")){        
						/* Add code here */
						}
						else
							if (action.equals("people_employee_delete")){        
							/* Add code here */
						}
			}
	} // (action== null )
/* forwarding the request/response to the targeted view */
	RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(target);
	requestDispatcher.forward(request, response);
}
}
