import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServletResponse;

public class DAO 
{
	public void initialize() throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		Statement st=con.createStatement();
		st.execute("create database if not exists professor");
		Statement st2=con.createStatement();
		st2.execute("use professor");
		Statement st3=con.createStatement();
		st3.execute("create table if not exists register(id int,name varchar(50),email varchar(20),year int,section varchar(10),password varchar(20))");
		Statement st4=con.createStatement();
		st4.execute("create table if not exists feedback(id int,feedback varchar(500))");
		con.close();
	}
	public int insert(RegisterBean rb) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		Statement st2=con.createStatement();
		st2.execute("use professor");
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?)");
		ps.setInt(1, rb.getId());
		ps.setString(2, rb.getName());
		ps.setString(3, rb.getEmail());
		ps.setInt(4, rb.getYear());
		ps.setString(5, rb.getSection());
		ps.setString(6, rb.getPassword());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public boolean validate(String email,String pass) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		Statement st2=con.createStatement();
		st2.execute("use professor");
		PreparedStatement ps=con.prepareStatement("select * from register");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.getString(3).equals(email) && rs.getString(6).equals(pass))
			{
				con.close();
				return true;
			}
		}
		con.close();
		return false;
	}
	public int sendfeedback(String email,String feedback) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		Statement st2=con.createStatement();
		st2.execute("use professor");
		PreparedStatement ps=con.prepareStatement("select * from register");
		ResultSet rs=ps.executeQuery();
		int id=0;
		while(rs.next())
		{
			if(rs.getString(3).equals(email))
			{
				id=rs.getInt(1);
			}
		}
		PreparedStatement ps2=con.prepareStatement("select * from feedback where id=?");
		ps2.setInt(1,id);
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next())
		{
			if(rs2.getInt(1)==id)
			{
				return 0;
			}
		}
		PreparedStatement ps3=con.prepareStatement("insert into feedback values(?,?)");
		ps3.setInt(1, id);
		ps3.setString(2, feedback);
		int i=ps3.executeUpdate();
		con.close();
		return i;
	}
	public void display(HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=DBUtil.DBConnection();
		Statement st=con.createStatement();
		st.execute("use professor");
		PreparedStatement ps=con.prepareStatement("select * from feedback");
		ResultSet rs=ps.executeQuery();
		PrintWriter pw=res.getWriter();
		pw.print("ID\tFEEDBACK\n--------------------------------------------\n");
		while(rs.next())
		{
			pw.print(rs.getInt(1)+"\t"+rs.getString(2)+"\n--------------------------------------------\n");
		}
		con.close();
	}
}

