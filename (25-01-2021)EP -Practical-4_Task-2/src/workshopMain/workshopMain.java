package workshopMain;
import workshopBeanPackage.workshopBean;
import workshopCRUDpackage.workShopCRUD;
import newworkshoppackage.newworkshop;
import java.sql.SQLException;
import java.util.*;
public class workshopMain 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		workshopBean wb=new workshopBean();
		workShopCRUD wc=new workShopCRUD();
		newworkshop nw=new newworkshop();
		Scanner s=new Scanner(System.in);
		int c=1;
		wc.createstudentsTable();
		System.out.println("The Table Students is Created now insert some details of the students to insert into table");
		while(true)
		{
			System.out.println("ID of student "+c+" :");
			wb.setId(s.nextInt());
			System.out.println("Name of student "+c+" :");
			wb.setName(s.next());
			System.out.println("Email of student "+c+" :");
			wb.setEmail(s.next());
			System.out.println("Date Of Birth of student "+c+" :");
			wb.setDob(s.next());
			c+=1;
			int i=wc.studentinsert(wb);
			if(i>0)
			{
				System.out.println("Insertion of Student "+(c-1)+" is complete");
			}
			else
			{
				System.out.println("Insertion is Failed");
			}
			System.out.println("Do you want to \n1. Add Another Student\n2. Exit");
			int ch=s.nextInt();
			if(ch>=2 || ch<=0)
			{
				break;
			}
		}
		wc.createworkshopTable();
		System.out.println("The Workshop Table is Created Now Insert the ID and Contact numbers of Interested Students");
		c=1;
		while(true)
		{
			System.out.println("Enter the ID of the Interested Student "+c+" :");
			nw.setID(s.nextInt());
			System.out.println("Enter the Contact of the Interested Student "+c+" :");
			nw.setPh(s.nextLong());
			int i=wc.workshopinsert(nw);
			if(i>0)
			{
				System.out.println("Insertion of Interested Student "+c+" is completed");
			}
			else
			{
				System.out.println("Insertion is failed");
			}
			c+=1;
			System.out.println("Do you want to \n1. Add another Interested Student\n2. Exit");
			int ch=s.nextInt();
			if(ch>=2 ||ch<=0)
			{
				break;
			}
		}
		System.out.println("Processing and displaying Your new Updated workshop table");
		wc.processworkshop();
		while(true)
		{
			System.out.println("Do you want to \n1. Delete a Student from workshop\n2. exit");
			int ch=s.nextInt();
			if(ch==1)
			{
				System.out.println("Enter the ID of the student you want to delete");
				int id=s.nextInt();
				wc.deleteworkshop(id);
				System.out.println("--The Updated Workshop table is --");
				wc.displayworkshop();
			}
			else
			{
				break;
			}
			
		}
		s.close();
	}

}
