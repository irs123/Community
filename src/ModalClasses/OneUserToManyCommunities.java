package ModalClasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneUserToManyCommunities {

	public static void main(String args[])
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(RmeUser.class).addAnnotatedClass(Community.class);
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try
		{
			transaction=session.beginTransaction();

			RmeUser u1=new RmeUser();
			u1.setUserId(1);
			u1.setUserName("kunal");
			
			RmeUser u2 =new RmeUser();
			u2.setUserId(2);
			u2.setUserName("Irsahd");
			
			
			Community c1 =new Community();
			c1.setCommunityId(101);
			c1.setCommunityName("abc");
			c1.setDescription("///abc");
			c1.setStatus(PrivatePublic.PRIVATE);
			
			Community c2 =new Community();
			c2.setCommunityId(102);
			c2.setCommunityName("xyz");
			c2.setCommunityName("/.//xyz");
			c2.setDescription("///xyz");
			c2.setStatus(PrivatePublic.PUBLIC);
			
			c1.setAdminId(u2);
			c2.setAdminId(u2);
			
			session.save(u1);
			session.save(u2);
			session.save(c1);
			session.save(c2);
			 transaction.commit();
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}

	}
	
}
