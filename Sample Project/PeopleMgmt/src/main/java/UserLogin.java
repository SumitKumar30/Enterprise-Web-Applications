

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.UserLoginDBMethods;
import login.UserLoginDBObj;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String lDBUser = "";
	String lDBPswd = "";
	String lDBUrl = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("lErrorMsg",null);
		String target = "user_login.jsp";
		String todo = (String)request.getParameter("todo");
		String action = request.getParameter("action");
		String action_submit = request.getParameter("action_submit");
		String action_chngpswd = request.getParameter("action_chngpswd");
		System.out.println("action_submit== "+action_submit);
		if ( action_submit != null || action_chngpswd != null ){
			if ( request.getParameter("submit").equals("Submit") ){
				System.out.println("in the  Submit");
				if ( action_submit.equals("people_user_login_submit") ){
					System.out.println("in the people_user_login_submit ");
					action = "people_user_login_submit";
				}
				else
					if (action_submit.equals("login_pswd_change_submit")){
						action = "login_pswd_change_submit";
					}
			}
			else 
				if ( request.getParameter("submit").equals("Change Password") ){
					if ( action_chngpswd.equals("people_change_pswd_submit") )
					action = "people_change_pswd_submit";
				}  
		}
		else if( (todo != null && todo.length() > 0) && (todo.equals("logout")) ){
			session = request.getSession(false);
			if(session != null)
			    session.invalidate();
			//request.getRequestDispatcher("/index.jsp").forward(request,response);
			target = "/index.jsp";
		}
		if (action!=null) {
			System.out.println("in the  "+action);
			if (action.equals("people_user_login_submit")){
				String lUserId = "";
				String lUserName = "";
				String lUserPswd = "";
				lUserId = (String)request.getParameter("user_id");
				lUserName = (String)request.getParameter("user_name");
				lUserPswd = (String)request.getParameter("user_pswd");
				
				// Create a user login object
				UserLoginDBObj userLoginDBObj = new UserLoginDBObj();
				UserLoginDBMethods userLoginDBMethods = new UserLoginDBMethods(lDBUser,lDBPswd,lDBUrl);
				
				// Calling the database using user login --> getRecordByPrimaryKey()
				userLoginDBObj = (UserLoginDBObj)userLoginDBMethods.getRecordByPrimaryKey(lUserId,lUserName,lUserPswd);
				
				// If the user exists --> send to "user_default.jsp"
				if ( userLoginDBObj != null && ( userLoginDBObj.user_id != null && (userLoginDBObj.user_id).length() > 0) ){
					target = "/user_default.jsp";
					session.setAttribute("user_name", userLoginDBObj.user_name);
				}
				else{
					String lErrorMsg = "User Does Not Exist!!"; 
					session.setAttribute("lErrorMsg",lErrorMsg);
					target = "/user_login.jsp";
				}	
			}
			else
				if (action.equals("people_change_pswd_submit")){
					target = "/user_login_pswd_change.jsp";
				}
				else
				if (action.equals("login_pswd_change_submit")){ 
					UserLoginDBObj popUserLoginDBObj = new UserLoginDBObj();
					UserLoginDBMethods userLoginDBMethods = new UserLoginDBMethods(lDBUser,lDBPswd,lDBUrl);
					String lUserId = "";
					String lUserName = "";
					String lCurPswd = "";
					String lNewPswd = "";
					String lRetypePswd = "";
					popUserLoginDBObj = (UserLoginDBObj)userLoginDBMethods.populateUserLoginDBObjFromReq(request);  
					lRetypePswd = (String)request.getParameter("retype_pswd");
					if ( (popUserLoginDBObj.new_pswd).equals(lRetypePswd) ){
						UserLoginDBObj userLoginDBObj = new UserLoginDBObj();
						userLoginDBObj = (UserLoginDBObj)userLoginDBMethods.getRecordByPrimaryKey(popUserLoginDBObj.user_id,popUserLoginDBObj.user_name,popUserLoginDBObj.old_pswd);
						if ( userLoginDBObj != null && ( userLoginDBObj.user_id != null && (userLoginDBObj.user_id).length() > 0) ){
							int rval = userLoginDBMethods.updateUserLoginByPrimaryKey(popUserLoginDBObj);
							if ( rval > 0 ){
								target = "/user_login.jsp";
							}
							else{
								target = "/user_login_pswd_change.jsp";
							}
						}
						else{
							String lErrorMsg = "User Does Not Exist!!"; 
							session.setAttribute("lErrorMsg",lErrorMsg);
							target = "/user_login_pswd_change.jsp";
						}
					} 
					else{
						String lErrorMsg = "Retype Correct Password!!"; 
						session.setAttribute("lErrorMsg",lErrorMsg);
						target = "/user_login_pswd_change.jsp";
					}
				}
			} // (action== null )
			/* forwarding the request/response to the targeted view */
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(target);
			requestDispatcher.forward(request, response);
	}

}
