package com.niit.SocialNetworkBackend1.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend1.Dao.JobDao;
import com.niit.SocialNetworkBackend1.model.JobInfo;

public class JobDaoTest {

	static JobDao jobDao;
	
	 @BeforeClass
		public static void initialize() {
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.SocialNetworkBackend1.*");
		annotationConfigAppContext.refresh();
		jobDao=(JobDao)annotationConfigAppContext.getBean("jobDao");
	 }
	 @Ignore
	 @Test
	 public void addJobTest()
	 {
		 JobInfo job=new JobInfo();
		 job.setJobId(1);
		 job.setJobProfile("IT");
		 job.setJobDescription("Java");
		 job.setPostDate(new Date());
		 job.setQualification("BE");
		 job.setStatus("A");
		 assertTrue("problem in adding job",jobDao.addJob(job));
	 }
	 @Ignore
	 @Test
	public void getJoblistTest()
	{
		List<JobInfo>joblist=(List<JobInfo>)jobDao.getJoblist();
		assertNotNull("Job not found",joblist.get(0));
	}
	 @Ignore
	 @Test
	 public void getJobByIdTest()
	 {
		 JobInfo job=jobDao.getJobById(41);
		 assertNotNull("Job not found",job);
		 System.out.println("JobProfile:"+job.getJobProfile());
		 System.out.println("JobQualification:"+job.getQualification());
	 }
	 @Ignore
	 @Test
	 public void updateJobTest()
	 {
	  JobInfo job=jobDao.getJobById(41);
	  job.setQualification("B.Tech");
	  assertTrue("problem in updating job",jobDao.updateJob(job));
	  System.out.println("JobProfile:"+job.getJobProfile());
	  System.out.println("JobQualification:"+job.getQualification());
	 }
	 @Test
	 public void deleteJobTest()
	 {
		 JobInfo job=jobDao.getJobById(41);
		 assertTrue("problem in deletion",jobDao.deleteJob(job));
	 }
	 
	 
	
}
