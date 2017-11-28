package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend1.model.Job;

public interface JobDao {
	public boolean addJob(Job job);
	public boolean updateJob(Job job);
	public boolean deleteJob(Job job);
	public Job getJobById(int jobId);
	public List<Job> list();
}
