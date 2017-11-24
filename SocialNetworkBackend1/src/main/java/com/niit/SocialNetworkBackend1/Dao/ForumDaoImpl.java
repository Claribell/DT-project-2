package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.Forum;
@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	
   public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public boolean addForum(Forum forum) {
	try {
		sessionfactory.getCurrentSession().save(forum);
		return true;
	}
	catch(Exception e) {
		System.out.println("Exception occured:"+e);
		return false;
	}
	}

	@Transactional
	public boolean updateForum(Forum forum) {
		try
		{
			sessionfactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}
		
	}

	@Transactional
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}
	}

	@Override
	public List<Forum> getAllForums() {
		Session session=sessionfactory.openSession();
		List<Forum>forumlist=(List<Forum>)session.createQuery("from Forum").list();
		session.close();
		return forumlist;
	}

	@Override
	public Forum getForum(int forumId) {
		Session session=sessionfactory.openSession();
		Forum forum=(Forum)session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	@Transactional
	public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}
	}

	@Transactional
	public boolean rejectForum(Forum forum) {
		try
		{
			forum.setStatus("R");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}
	}

}
