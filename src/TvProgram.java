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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TvProgram
 */
@WebServlet("/TvProgram")
public class TvProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TvProgram() {
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
					
						stmt = conn.createStatement();
						//String title = request.getParameter("title");
						String col = "collection";
						
                                                rs = stmt.executeQuery("select v.Vid as  id, v.Title as tit, c.Name as Certification, vg.Type as Genre,p.Pname as Producer, "
								+ "d.Name as Director, v.Country as country, avg(r.Rating ) as Rating "
								+ "from video v, certification c, videogenre vg, producer p, director d, directedby db, "
								+ "rating r where v.CertId=c.Cid AND vg.Vid=v.Vid AND "
								+ "p.Vid=v.Vid AND d.Did=db.Did AND db.Vid=v.Vid  AND v.Type= '"+col+"' "
								+ "group by v.Title "
								+ "order by v.Vid");
						   out.println("<html><body><table border = '1'>");
						   out.println("<tr bgcolor='blue'>");
						   out.println("<th> VID </th> ");
						   out.println("<th> Title </th>");
						   out.println("<th> Certification </th>");
						   out.println("<th> Genre </th>");
						   out.println("<th> Producer</th>");
						   out.println("<th> Director </th>");
						   out.println("<th> Country</th>");
						   out.println("<th> rating </th></tr>");
						
						while (rs.next()) {
							String id = rs.getString("id");
							String name = rs.getString("tit");
							String cert = rs.getString("Certification");
							String genre = rs.getString("Genre");
							String prod = rs.getString("Producer");
							String dir = rs.getString("Director");
							String coun = rs.getString("country");
							String rat = rs.getString("Rating");
							
						  
						   out.println("<tr>");
						   out.println("<td>"+id+"</td>");
						   out.println("<td>"+name+"</td>");
						   out.println("<td>"+cert+"</td>");
						   out.println("<td>"+genre+"</td>");
						   out.println("<td>"+prod+"</td>");
						   out.println("<td>"+dir+"</td>");
						   out.println("<td>"+coun+"</td>");
						   out.println("<td>"+rat+"</td>");
						   out.println("</tr>");
						   
						}
						
						out.println("</table>");
						out.println("<div class='welcome'>");
						out.println("<form action='welcomeUser.html'>");
						out.println("<input type='submit' name='Home' value='Back'/>");
						out.println("</form>");
						out.println("</div></body></html>");
				
			}			catch (Exception e) {
						e.printStackTrace();
						} 	finally {
		try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
	}

}
