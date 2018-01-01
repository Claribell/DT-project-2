package com.niit.SocialNetworkBackend1.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.Profilepic;


@Repository("profilepicDao")
public class ProfilepicDaoImpl implements ProfilepicDao {
	
	@Autowired
	public SessionFactory sessionfactory;
	
	public ProfilepicDaoImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public boolean save(Profilepic profilepic) {
		
		try {
			sessionfactory.getCurrentSession().save(profilepic);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
	}

	@Override
	public Profilepic getProfilepic(String userName) {
		Session session=sessionfactory.openSession();
		Profilepic profilepic=(Profilepic)session.get(Profilepic.class, userName);
		session.close();
		return profilepic ;
	}

}
