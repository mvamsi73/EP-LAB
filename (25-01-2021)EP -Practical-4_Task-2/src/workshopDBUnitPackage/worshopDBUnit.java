package workshopDBUnitPackage;

import java.sql.*;
public class worshopDBUnit 
{
	final static String fornameurl="com.mysql.cj.jdbc.Driver";
	final static String DBURL="jdbc:mysql://localhost:3306/workshopBean";
	final static String user="root";
	final static String password="root";
	public static Connection DBConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName(fornameurl);
		Connection con=DriverManager.getConnection(DBURL,user,password);
		return con;
	}
}
