// Http Session Servlet with basic session information and Access counts.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowSession
 */
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String heading;
		 Integer accessCount =
		 (Integer)session.getAttribute("accessCount");
		 if (accessCount == null) {
		 accessCount = new Integer(0);
		 heading = "Welcome, Newcomer";
		 } else {
		 heading = "Welcome Back";
		 accessCount = new Integer(accessCount.intValue() + 1);
		 }
		 // Integer is an immutable data structure. So, you
		 // cannot modify the old one in-place. Instead, you
		 // have to allocate a new one and redo setAttribute.
		 session.setAttribute("accessCount", accessCount);
		 PrintWriter out = response.getWriter();
		 String title = "Session Tracking Example";
		 String docType =
		 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		 "Transitional//EN\">\n";
		 out.println(docType +
		 "<HTML>\n" +
		 "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
		 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		 "<CENTER>\n" +
		 "<H1>" + heading + "</H1>\n" +
		 "<H2>Information on Your Session:</H2>\n" +
		 "<TABLE BORDER=1>\n" +
		 "<TR BGCOLOR=\"#FFAD00\">\n" +
		 " <TH>Info Type<TH>Value\n" +
		 "<TR>\n" +
		 " <TD>ID\n" +
		 " <TD>" + session.getId() + "\n" +
		 "<TR>\n" +
		 " <TD>Creation Time\n" +
		 " <TD>" +
		 new Date(session.getCreationTime()) + "\n" +
		 "<TR>\n" +
		 " <TD>Time of Last Access\n" +
		 " <TD>" +
		 new Date(session.getLastAccessedTime()) + "\n" +
		 "<TR>\n" +
		 " <TD>Number of Previous Accesses\n" +
		 " <TD>" + accessCount + "\n" +
		 "</TABLE>\n" +
		 "</CENTER></BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
