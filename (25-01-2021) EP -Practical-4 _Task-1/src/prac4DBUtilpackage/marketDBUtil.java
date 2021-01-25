package prac4DBUtilpackage;
import java.sql.*;
public class marketDBUtil 
{
	final static String forNameURL="com.mysql.cj.jdbc.Driver";
	final static String dbURL="jdbc:mysql://localhost:3306";
	final static String username="root";
	final static String password="root";
	public static Connection DBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(forNameURL);
		Connection con=DriverManager.getConnection(dbURL,username,password);
		return con;
	}

}
