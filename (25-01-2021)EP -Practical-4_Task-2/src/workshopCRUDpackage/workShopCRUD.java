package workshopCRUDpackage;
import workshopBeanPackage.workshopBean;
import workshopDBUnitPackage.worshopDBUnit;
import newworkshoppackage.newworkshop;
import java.sql.*;
public class workShopCRUD 
{
	public void createstudentsTable() throws SQLException, ClassNotFoundException
	{
		Connection con=worshopDBUnit.DBConnection();
		Statement st=con.createStatement();
		st.execute("create table if not exists students(ID int,name varchar(50),email varchar(50),dob varchar(20))");
	}
	public void createworkshopTable() throws SQLException, ClassNotFoundException
	{
		Connection con=worshopDBUnit.DBConnection();
		Statement st=con.createStatement();
		st.execute("create table if not exists workshop(ID int,phno bigint)");
	}
	public int studentinsert(workshopBean wb) throws SQLException, ClassNotFoundException
	{
		Connection con=worshopDBUnit.DBConnection();
		PreparedStatement st=con.prepareStatement("insert into students values (?,?,?,?)");
		st.setInt(1, wb.getId());
		st.setString(2, wb.getName());
		st.setString(3, wb.getEmail());
		st.setString(4, wb.getDob());
		int i=st.executeUpdate();
		con.close();
		return i;
	}
	public int workshopinsert(newworkshop nw) throws SQLException, ClassNotFoundException
	{
		Connection con=worshopDBUnit.DBConnection();
		PreparedStatement st=con.prepareStatement("insert into workshop values (?,?)");
		st.setInt(1, nw.getID());
		st.setLong(2, nw.getPh());
		int i=st.executeUpdate();
		con.close();
		return i;
	}
	public void processworkshop() throws SQLException, ClassNotFoundException
	{
		Connection con=worshopDBUnit.DBConnection();
		Statement st=con.createStatement();
		st.execute("ALTER TABLE workshop ADD COLUMN name VARCHAR(50)");
		Statement st1=con.createStatement();
		st1.execute("ALTER TABLE workshop ADD COLUMN email VARCHAR(50)");
		Statement s3=con.createStatement();
		s3.execute("update workshop w,students s set w.name=s.name where w.ID=s.ID");
		Statement s4=con.createStatement();
		s4.execute("update workshop w,students s set w.email=s.email where w.ID=s.ID");
		displayworkshop();
	}
	public int deleteworkshop(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=worshopDBUnit.DBConnection();
		PreparedStatement st=con.prepareStatement("delete from workshop where ID="+id);
		int i=st.executeUpdate();
		return i;
	}
	public void displayworkshop() throws ClassNotFoundException, SQLException
	{
		Connection con=worshopDBUnit.DBConnection();
		PreparedStatement ps=con.prepareStatement("select * from workshop");
		ResultSet rs=ps.executeQuery();
		System.out.println("ID\t\tPhone\t\tName\t\tEmail");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getLong(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4));
		}
	}

}
