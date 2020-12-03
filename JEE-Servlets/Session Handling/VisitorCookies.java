// Cookie handling by tracking the visitor as newbie or repeated visitor.

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitorCookies
 */
public class VisitorCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// flag will check whether a user is a first time visitor
		boolean newbie = true;

		// fetch the cookies info using request object
		// using getCookies() --> returns array of Cookie objects
		Cookie[] cookies = request.getCookies();

		// check if the user is a newbie or not
		if(cookies != null) {	// repeated visitor
			for(int i = 0 ; i < cookies.length; i++) {
					if(cookies[i].getName().equals("repeatedVisitor") && (cookies[i].getValue().equals("yes"))){
						newbie = false;
						break;
					}
			}
		}
		String greeting;
		if(newbie == true) {
			Cookie visitorCookie = new Cookie("repeatedVisitor", "yes");
			// persistent cookie --> setMaxAge(seconds)
			visitorCookie.setMaxAge(60*60*24*7);
			response.addCookie(visitorCookie);
			greeting = "Welcome Newbie!";
		}
		else {
				greeting = "Welcome Back!";
		}

		// send response in HTML form
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>\n"+
					"<head><title>"+greeting+"</title></head>\n"+
					"<body>\n"+
					"<h1>"+greeting+"<h1>\n"+
					"</body></html>"
				);

		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
