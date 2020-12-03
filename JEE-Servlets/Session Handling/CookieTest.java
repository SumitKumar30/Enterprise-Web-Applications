// Servlet program to demonstrate the difference between Session Cookie & Persistent Cookie

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest
 */
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		for(int i=0; i<3; i++) {
			 // Default maxAge is -1, indicating cookie
			 // applies only to current browsing session.
			 Cookie cookie = new Cookie("Session-Cookie-" + i,
			 "Cookie-Value-S" + i);
			 response.addCookie(cookie);
			 cookie = new Cookie("Persistent-Cookie-" + i,
			 "Cookie-Value-P" + i);
			 // Cookie is valid for an hour, regardless of whether
			 // user quits browser, reboots computer, or whatever.
			 cookie.setMaxAge(3600);
			 response.addCookie(cookie);
			 }
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 String docType =
			 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			 "Transitional//EN\">\n";
			 String title = "Active Cookies";
			 out.println(docType +
					 "<HTML>\n" +
					 "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
					 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
					 "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
					 "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
					 "<TR BGCOLOR=\"#FFAD00\">\n" +
					 " <TH>Cookie Name\n" +
					 " <TH>Cookie Value");
					 Cookie[] cookies = request.getCookies();
					 if (cookies == null) {
					 out.println("<TR><TH COLSPAN=2>No cookies");
					 } else {
					 Cookie cookie;
					 for(int i=0; i<cookies.length; i++) {
					 cookie = cookies[i];
					 out.println("<TR>\n" +
					 " <TD>" + cookie.getName() + "\n" +
					" <TD>" + cookie.getValue());
					 }
					 }
					 out.println("</TABLE></BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
