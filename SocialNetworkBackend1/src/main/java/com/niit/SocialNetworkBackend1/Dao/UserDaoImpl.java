package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.UserInfo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	public SessionFactory sessionfactory;

	

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public boolean addUser(UserInfo user) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Transactional
	public boolean updateOnlineStatus(String status, UserInfo user) {
		try
		{
	      user.setIsOnline(status);
	      sessionfactory.getCurrentSession().update(user);
	      return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :" +e);
			return false;
		}
		
	}

	@Transactional
	public UserInfo getUser(String userName) {
	Session session=sessionfactory.openSession();
	UserInfo user=(UserInfo)session.get(UserInfo.class, userName);
	session.close();
	return user;
	}

	@Override
	public UserInfo getByEmail(String email) {
		return(UserInfo) sessionfactory.getCurrentSession().get(UserInfo.class,email);
	}

	@Transactional
	public boolean delete(String email) {
		try
		{
			sessionfactory.getCurrentSession().delete(getByEmail (email));
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:" +e);
			return false;
		}
		
	}

	@Override
	public List<UserInfo> getAllUser() {
		Session session=sessionfactory.openSession();
		List<UserInfo>userlist=(List<UserInfo>)session.createQuery("from UserInfo").list();
		session.close();
		return userlist;
	}
	
	

}
