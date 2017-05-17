import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validations
 */
@WebServlet("/Validations")
public class Validations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String uname = request.getParameter("user");
			String pwd = request.getParameter("pass");
			out.println("<html><body>");
			
			if((uname.equals("user") && pwd.equals("password"))||(uname.equals("user1") && pwd.equals("password1"))){
				response.sendRedirect("welcomeUser.html");
				
				out.println("<h2> Login successful</h2");
			}
			else{
				
				out.println("<h2> Login Unsuccessful. Please Try Again</h2>");
				out.println("<div class='welcome'>");
				out.println("<form action='login.html'>");
				out.println("<table><tr>");
				out.println("<td><input type='submit' value='Login'/></td></tr>");
				out.println("</div></table></form>");
			}
			
			out.println("</html></body>");
	}

}
