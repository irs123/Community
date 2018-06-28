package ModalClasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class create {

	public static void main(String[] args)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(RmeUser.class).addAnnotatedClass(Community.class);
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try
		{
			transaction=session.beginTransaction();

			RmeUser user1 = new RmeUser();
			user1.setUserName("Irshad");
			user1.setUserId(11);

			RmeUser user2 = new RmeUser();
			user2.setUserName("Deepak");
			user2.setUserId(12);
			
			Community comm1 = new Community();
			comm1.setDescription("buljsdk contksnt klajskf klankdfh jdf");
			comm1.setStatus(PrivatePublic.PRIVATE);
			comm1.setCommunityName("community 1");
			comm1.setCommunityId(1);
			
			
			Community comm2 = new Community();
			comm2.setDescription(" ilsnafl buljsdk contksnt klajskf klankdfh jdf");
			comm2.setStatus(PrivatePublic.PUBLIC);
			comm2.setCommunityName("community 2");
			comm2.setCommunityId(2);
			Community comm3 = new Community();
			comm3.setDescription("community content ajskf klankdfh jdf");
			comm3.setStatus(PrivatePublic.PRIVATE);
			comm3.setCommunityName("community 3");
			comm3.setCommunityId(3);
			//--------------------mapping setting
			user1.getCommunities().add(comm3);
			user1.getCommunities().add(comm2);
			user1.getCommunities().add(comm1);
			user2.getCommunities().add(comm2);
			user2.getCommunities().add(comm1);
			comm1.getMembers().add(user2);
			comm1.getMembers().add(user1);
			comm2.getMembers().add(user2);
			comm2.getMembers().add(user1);
			comm3.getMembers().add(user1);
			
			session.save(comm1);
			session.save(comm2);
			session.save(comm3);
			session.save(user1);
			session.save(user1);
	/*		RmeUser u1=new RmeUser();
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
			
			
			u1.getCommunities().add(c1);
			u1.getCommunities().add(c2);
			//---------------------saving objects
			session.save(u1);
			session.save(u2);
			session.save(c1);
			session.save(c2);
		*/ transaction.commit();
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
