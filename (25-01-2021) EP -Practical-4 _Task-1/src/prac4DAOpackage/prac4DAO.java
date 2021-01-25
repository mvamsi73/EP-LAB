package prac4DAOpackage;
import prac4beanpackage.marketBean;
import prac4DBUtilpackage.marketDBUtil;
import java.sql.*;
public class prac4DAO 
{
	public int insert(marketBean mb,String database,String table) throws ClassNotFoundException, SQLException
	{
		Connection con=marketDBUtil.DBConnection();
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		PreparedStatement ps=con.prepareStatement("insert into "+table+" values(?,?,?)");
		ps.setInt(1, mb.getItemID());
		ps.setString(2, mb.getItemName());
		ps.setDouble(3, mb.getCost());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public void display(String database,String table) throws ClassNotFoundException, SQLException
	{
		Connection con=marketDBUtil.DBConnection();
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		PreparedStatement ps=con.prepareStatement("select * from "+table);
		ResultSet rst=ps.executeQuery();
		System.out.println("ITEM-ID\t\tNAME\t\tCOST");
		while(rst.next())
		{
			System.out.println(rst.getInt(1)+"\t\t"+rst.getString(2)+"\t\t"+rst.getDouble(3));
		}
		con.close();
	}
	public double getcost(String database,String table) throws SQLException, ClassNotFoundException
	{
		Connection con=marketDBUtil.DBConnection();
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		PreparedStatement ps=con.prepareStatement("select sum(cost) from "+table);
		ResultSet rst=ps.executeQuery();
		double res=0;
		while(rst.next())
		{
			res=rst.getDouble(1);
		}
		con.close();
		return res;
	}
	public void initialize(String database,String table) throws SQLException, ClassNotFoundException
	{
		Connection con=marketDBUtil.DBConnection();
		Statement stmt1 = con.createStatement();
		stmt1.execute("create database "+database);
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		Statement stmt2=con.createStatement();
		stmt2.execute("create table "+table+"(itemID int,itemName varchar(50),cost double)");
		con.close();
	}

}
