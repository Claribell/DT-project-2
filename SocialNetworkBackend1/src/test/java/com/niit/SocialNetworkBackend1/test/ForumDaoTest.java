package com.niit.SocialNetworkBackend1.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend1.Dao.ForumDao;
import com.niit.SocialNetworkBackend1.model.Forum;

public class ForumDaoTest {
	
	static ForumDao forumDao;
	
	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.SocialNetworkBackend1.*");
		annotationConfigAppContext.refresh();
		forumDao=(ForumDao)annotationConfigAppContext.getBean("forumDao");
	 }
	@Ignore
	@Test
	public void addForumTest() {
		Forum forum=new Forum();
		forum.setForumName("Stackflow");
		forum.setForumContent("JAVA");
		forum.setUserName("Sanjay");
		forum.setStatus("A");
		forum.setCreationDate(new Date());
		assertTrue("Problem in inserting forum",forumDao.addForum(forum));
}
	@Ignore
	@Test
	public void getForumTest()
    {
    Forum forum=forumDao.getForum(21);
    assertNotNull("Forum not found",forum);
    System.out.println("Forum Name:" +forum.getForumName());
    System.out.println("Forum Content:" +forum.getForumContent());
    }
	@Ignore
	@Test
	public void updateForumTest()
	{
		 Forum forum=forumDao.getForum(21);
		 forum.setForumContent(".NET");
		 assertTrue("problem in updating forum",forumDao.updateForum(forum));
		 System.out.println("Forum Name:" +forum.getForumName());
		 System.out.println("Forum Content:" +forum.getForumContent());
	}
	@Ignore
	@Test
	public void getAllForumTest()
    {
    	List<Forum>forumlist=(List<Forum>)forumDao.getAllForums();
    	assertNotNull("forumlist not found",forumlist.get(0));
    	for (Forum forum:forumlist)
    	{
    		System.out.println("ForumId:" + forum.getForumId()+"::"+"ForumName:"+forum.getForumName());
    	}
    }
	@Ignore
	@Test
	 public void rejectForumTest()
	    {
	    	 Forum forum=forumDao.getForum(21);
	    	assertTrue("problem in rejecting forum",forumDao.rejectForum(forum));	   
	    }
	@Ignore
	@Test
     public void approveForumTest()
    {
    	 Forum forum=forumDao.getForum(21);
    	assertTrue("problem in approving forum",forumDao.approveForum(forum));
    }
    @Test
	 public void deleteForumTest()
   {
   	 Forum forum=(Forum)forumDao.getForum(21);
   	assertTrue("problem in deleting forum",forumDao.deleteForum(forum));
   }

}
