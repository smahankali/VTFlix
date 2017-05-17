/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surekha
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Sample
{
	public static void main (String args [])
		       throws SQLException, ClassNotFoundException 
		 {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
	try 
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
					String connectionUrl = "jdbc:mysql://localhost:3306/vtflix";
					String connectionUser = "root";
					String connectionPassword = "";
					conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select v.vid, v.title, c.name as Certification, vg.type as Genre,p.pname as Producer,"
							+ "d.name as Director, v.country, avg(r.rating ) as Rating "
							+ "from video v, certification c, videogenre vg, producer p, director d, directedby db, "
							+ "rating r where v.certid=c.cid AND vg.vid=v.vid AND "
							+ "p.vid=v.vid AND d.did=db.did AND db.vid=v.vid AND r.vid=v.vid "
							+ "group by v.title");
					while (rs.next()) 
					{
						String id = rs.getString("vid");
						String name = rs.getString("title");
						String cert = rs.getString("Certification");
						String genre = rs.getString("Genre");
						String prod = rs.getString("Producer");
						String dir = rs.getString("Director");
						String coun = rs.getString("country");
						String rat = rs.getString("Rating");
						System.out.println(id);
						   System.out.println(name);
						   System.out.println(cert);
						   System.out.println(genre);
						   System.out.println(prod);
						   System.out.println(dir);
						  System.out.println(coun);
						   System.out.println(rat);
						  						   
						}


		}catch (Exception e) {
	e.printStackTrace();
	} 	
	finally 
	{
try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
}
}
	

