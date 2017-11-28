package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.Job;

@Repository("jobDao")
public class JobDaoImpl implements JobDao {
	
	@Autowired
	public SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public boolean addJob(Job job) {
		try {
			sessionfactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

   @Override
	public Job getJobById(int jobId) {
	   Session session=sessionfactory.openSession();
	   Job job=(Job)session.get(Job.class,jobId);
	   session.close();
	   return job;
	}

	@Override
	public List<Job> list() {
		 Session session=sessionfactory.openSession();
		 List<Job>joblist=(List<Job>)session.createQuery("from Job").list();
		 session.close();
		 return joblist;
	}

	@Transactional
	public boolean updateJob(Job job) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(job);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Transactional
	public boolean deleteJob(Job job) {
		try {
			sessionfactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}
	
	

}
