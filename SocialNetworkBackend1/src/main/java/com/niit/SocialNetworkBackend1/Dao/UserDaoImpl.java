package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.Query;
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
	public UserInfo getByEmail(String emailId) {
		return(UserInfo) sessionfactory.getCurrentSession().get(UserInfo.class,emailId);
	}

	@Transactional
	public boolean delete(String emailId) {
		try
		{
			sessionfactory.getCurrentSession().delete(getByEmail (emailId));
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

	@Transactional
	public boolean checkLogin(UserInfo user) {
		{
			try
			{
				Session session=sessionfactory.openSession();
				Query query=session.createQuery("from UserInfo where userName:=uname and password:=passwd");
				query.setParameter("uname",user.getUserName());
				query.setParameter("passwd",user.getPassword());
				UserInfo user1=(UserInfo)query.list().get(0);
				if(user1==null)
					return false;
				else
					return true;
			}
			catch(Exception e) {
				return false;
			}
		}
		
	}
	
	

}
