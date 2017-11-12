package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.User;

@Repository("userDao")
public class UserDaoImpl  implements UserDao{

	public static final Logger log = Logger.getLogger(UserDaoImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

   @Transactional
	public List<User>getAllUser() {
		log.info("getAllUser---");
		String hql = "from User";
		Query query =sessionfactory.getCurrentSession().createQuery(hql);		
		return query.list();
		
	}


	
@Transactional
public boolean save(User user) {
	log.info("****Starting save method in UserDaoImpl***");
	try {
		sessionfactory.getCurrentSession().save(user);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}




}
