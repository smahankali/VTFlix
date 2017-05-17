import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SQLBean {
	private String user = " ";
	private String pass = " ";
	private String data = " ";
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String Validate()
	{
		if(user.equals("user") && pass.equals("password"))
		{
			return "welcomeUser.xhtml";
		}
		else if(user.equals("user1") && pass.equals("password1"))
		{
			return "welcomeUser.xhtml";
		}
		else
			return "failure";
	}
}

