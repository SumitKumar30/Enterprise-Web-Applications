// Servlet class to perform CRUD operations over input form data.

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormHandler
 */
public class FormHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		// Step 1: Fetch the request & store the data inside String variable
		/** String name = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("Name: "+name);
		System.out.println("Password is: "+pass);
		// Step 2: Send the response back to the client/user
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!doctype HTML>");
		out.println("<html>");
		out.println("<head><Title> Input Form Response</title></head>");
		out.println("<body><h1> "+name+" your response is submitted successfully!! </h1>");
		out.println("</body> </html>");
		out.flush();**/
		// Set the response message's MIME type
	      response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();

	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Echo Servlet</title></head>");
	         out.println("<body><h2>You have entered</h2>");

	         // Retrieve the value of the query parameter "username" (from text field)
	         String username = request.getParameter("username");
	         if (username == null) {
	        	 System.out.println("Username is missing!");
	         }
	         else {
	        	 out.println("<p>Name: " + username + "</p>");
	         }
	      // Retrieve the value of the query parameter "password" (from password field)
	         String password = request.getParameter("password");
	         if (password == null) {
	        	 System.out.println("Password is missing!!");
	         }
	         else {
	        	 out.println("<p>Password: " + password + "</p>");
	         }
	         // Retrieve the value of the query parameter "gender" (from radio button)
	         String gender = request.getParameter("gender");
	         if (gender == null) {
	             System.out.println("Please enter your gender!!");
	          } else if (gender.equals("m")) {
	             out.println("<p>Gender: male</p>");
	          } else {
	             out.println("<p>Gender: female</p>");
	          }
	      // Retrieve the value of the query parameter "age" (from pull-down menu)
	         String age = request.getParameter("age");
	         if (age == null) {
	            System.out.println("Please enter your age!!");
	         } else if (age.equals("1")) {
	            out.println("<p>Age: &lt; 1 year old</p>");
	         } else if (age.equals("99")) {
	            out.println("<p>Age: 1 to 99 years old</p>");
	         } else {
	            out.println("<p>Age: &gt; 99 years old</p>");
	         }
	      // Retrieve the value of the query parameter "language" (from checkboxes).
	         // Multiple entries possible.
	         // Use getParameterValues() which returns an array of String.
	         String[] languages = request.getParameterValues("language");
	         // Get null if the parameter is missing from query string.
	         if (languages == null || languages.length == 0) {
	            System.out.println("Languages None!");
	         } else {
	            out.println("<p>Languages: ");
	            for (String language : languages) {
	               if (language.equals("c")) {
	                  out.println("C/C++ ");
	               } else if (language.equals("cs")) {
	                  out.println("C# ");
	               } else if (language.equals("java")) {
	                  out.println("Java ");
	               }
	            }
	            out.println("</p>");
	         }
	      // Retrieve the value of the query parameter "instruction" (from text area)
	         String instruction = request.getParameter("instruction");
	         if (instruction == null) {
	        	 System.out.println("Instructions Empty!");
	         }
	         else {
	        	 out.println("<p>Instruction: " + instruction + "</p>");
	         }
	      // Retrieve the value of the query parameter "secret" (from hidden field)
	         String secret = request.getParameter("secret");
	         out.println("<p>Secret: " + secret + "</p>");
	      // Hyperlink "BACK" to input page
	         out.println("<a href='index.jsp'>BACK</a>");

	         out.println("</body></html>");

	      }
	      finally {
	          out.close();  // Always close the output writer
	       }
	}

}
