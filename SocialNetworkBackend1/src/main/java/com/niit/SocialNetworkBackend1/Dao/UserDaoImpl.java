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

	@Override
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

	@Override
	public UserInfo getUser(String userName) {
	Session session=sessionfactory.openSession();
	UserInfo user=(UserInfo)session.get(UserInfo.class, userName);
	session.close();
	return user;
	}

	@Override
	public UserInfo getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserInfo> getAllUser() {
		
		
		return null;
	}
	
	

}
