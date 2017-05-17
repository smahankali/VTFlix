import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rate
 */
@WebServlet("/Ratings")
public class Ratings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ratings() {
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
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
						String connectionUrl = "jdbc:mysql://localhost:3306/vtflix";
						String connectionUser = "root";
						String connectionPassword = "";
						conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
					//	conn = DriverManager.getConnection(url, user, password)
						stmt = conn.createStatement();
						String rate = request.getParameter("rate");
						String title = request.getParameter("title");
						rs =stmt.executeQuery("select Vid from video where Title='"+title+"'");
						
						while(rs.next())
						{
							String vid = rs.getString("Vid");
							String query = "insert into rating values("+rate+",'"+vid+"','"+title.trim()+"')";
							//ResultSet rs1 = stmt.executeQuery("insert into rating values("+rate+",'"+vid+"','"+title+"')");
							stmt.executeUpdate(query);
							
								out.println("<html><body>");
								out.println("<h2>thanks for the rating<h2>");
								out.println("<form action='welcome.html'>");
								out.println("<table><tr>");
								out.println("<td><input type='submit' value='Home' class='login-submit'/></td></tr>");
								out.println("</table></form>");
								out.println("</body></html>");
						}
						}catch (Exception e) {
							e.printStackTrace();
							} 	finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
						
						
	}

}
