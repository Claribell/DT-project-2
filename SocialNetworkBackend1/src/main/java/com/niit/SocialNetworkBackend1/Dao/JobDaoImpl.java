package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.JobInfo;

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
	public boolean addJob(JobInfo job) {
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
	public JobInfo getJobById(int jobId) {
	   Session session=sessionfactory.openSession();
	   JobInfo job=(JobInfo)session.get(JobInfo.class,jobId);
	   session.close();
	   return job;
	}

	@Override
	public List<JobInfo>getJoblist() {
		 Session session=sessionfactory.openSession();
		 List<JobInfo>joblist=(List<JobInfo>)session.createQuery("from JobInfo").list();
		 session.close();
		 return joblist;
	}

	@Transactional
	public boolean updateJob(JobInfo job) {
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
	public boolean deleteJob(JobInfo job) {
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
