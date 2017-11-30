package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend1.model.JobInfo;

public interface JobDao {
	public boolean addJob(JobInfo job);
	public boolean updateJob(JobInfo job);
	public boolean deleteJob(JobInfo job);
	public JobInfo getJobById(int jobId);
	public List<JobInfo> getJoblist();
}
