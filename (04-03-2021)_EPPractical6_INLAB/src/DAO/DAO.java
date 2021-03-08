package DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bean.*;
public class DAO 
{
	public void insert(registrationbean rb)
	{
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=meta.getSessionFactoryBuilder().build();
			Session session=sf.openSession();
			Transaction t=session.beginTransaction();
			session.save(rb);
			t.commit();
			session.close();
			sf.close();
	}

}
