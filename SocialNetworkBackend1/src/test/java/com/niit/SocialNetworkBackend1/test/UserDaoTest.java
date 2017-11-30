package com.niit.SocialNetworkBackend1.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.SocialNetworkBackend1.Dao.UserDao;

import com.niit.SocialNetworkBackend1.model.UserInfo;

public class UserDaoTest {


	static UserDao userDao;
	
	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.SocialNetworkBackend1.*");
		annotationConfigAppContext.refresh();
		userDao=(UserDao)annotationConfigAppContext.getBean("userDao");
	 }
	@Ignore
	@Test
	public void addUserTest()
	{
		UserInfo user=new UserInfo();
		user.setUserName("Daniel");
		user.setFirstName("Gifton");
		user.setLastName("Daniel");
		user.setEmailId("dani@gmail.com");
		user.setPassword("5gfoi9@7");
		user.setIsOnline("N");
		user.setRole("Admin");
		assertTrue("problem in creating user",userDao.addUser(user));
     }
	@Ignore
	@Test
	public void isOnlineTest()
	{
		UserInfo user=userDao.getUser("Daniel");
		assertTrue("problem in updation",userDao.updateOnlineStatus("N", user));
				
	}
	@Ignore
	@Test
	 public void getUserTest()
	    {
	    	UserInfo user=userDao.getUser("Daniel");
	    	assertNotNull("User not found",user);
	    }
	@Test
	public void getAllUsersTest()
	{
		List<UserInfo>userlist=(List<UserInfo>)userDao.getAllUser();
		assertNotNull("user list not found",userlist.get(0));
	}

}
