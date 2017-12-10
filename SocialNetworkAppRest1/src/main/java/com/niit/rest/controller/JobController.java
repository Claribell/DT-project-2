package com.niit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend1.Dao.JobDao;
import com.niit.SocialNetworkBackend1.model.JobInfo;

@RestController
public class JobController {
	
	@Autowired
	JobDao jobDao;
	
	@PostMapping(value="/addJob")
	public ResponseEntity<String> addJob(@RequestBody JobInfo job)
	{
		job.setPostDate(new java.util.Date());
		if(jobDao.addJob(job))
		{
			return new ResponseEntity<String>("Job added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in posting",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/showAlljobs")
	public ResponseEntity<List<JobInfo>> showAlljobs()
	{
		List<JobInfo>listJobs=jobDao.getJoblist();
		return new ResponseEntity <List<JobInfo>>(listJobs,HttpStatus.OK);
	}
	
	@GetMapping(value="/deletejob/{jobId}")
	public ResponseEntity<String>deletejob(@PathVariable("jobId")int jobId)
	{
		JobInfo tempjob=jobDao.getJobById(jobId);
		
		 if(jobDao.deleteJob(tempjob))
		 {
			 return new ResponseEntity<String>("Job Deleted",HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<String>("Error in Job deletion",HttpStatus.SERVICE_UNAVAILABLE);
		 }
	}

}
