package prac4mainpackage;
import prac4DAOpackage.prac4DAO;
import prac4beanpackage.marketBean;

import java.sql.SQLException;
import java.util.*;
public class prac4main 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		prac4DAO DAO=new prac4DAO();
		marketBean mb=new marketBean();
		Scanner s=new Scanner(System.in);
		System.out.println("You want to\n1. create a database \n2. use a database\nEnter your option here:");
		int ch=s.nextInt();
		String database;
		String table;
		if(ch==1)
		{
			System.out.println("Enter the Database name and Table name you want to create respectively");
			database=s.next();
			table=s.next();
			DAO.initialize(database, table);
		}
		else
		{
			System.out.println("Enter the Database name and Table name you want to use respectively");
			database=s.next();
			table=s.next();
		}
		System.out.println("Enter the number of Items you have bought Dany:");
		int ct=s.nextInt();
		for(int i=0;i<ct;i++)
		{
			System.out.println("Enter ITEM ID for item "+(i+1)+" :");
			mb.setItemID(s.nextInt());
			System.out.println("Enter ITEM NAME for item "+(i+1)+" :");
			mb.setItemName(s.next());
			System.out.println("Enter ITEM COST for item "+(i+1)+" :");
			mb.setCost(s.nextDouble());
			int j=DAO.insert(mb,database,table);
			if(j>0)
			{
				System.out.println("Insertion is Successfull for item "+(i+1));
			}
			else
			{
				System.out.println("Insertion is Failed for item "+(i+1));
			}
		}
		s.close();
		System.out.println("\n--Insertion of all items is Completed--\nNow displaying all the items\n\n");
		DAO.display(database,table);
		System.out.println("The Total cost of the Items is : "+DAO.getcost(database,table));
	}

}
