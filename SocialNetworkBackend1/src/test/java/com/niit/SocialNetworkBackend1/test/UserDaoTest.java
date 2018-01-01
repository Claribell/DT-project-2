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
	@Test
	public void addUserTest()
	{
		UserInfo user=new UserInfo();
		user.setUserId(2);
		user.setUserName("Avinash");
		user.setFirstName("Avinash");
		user.setLastName("Kesari");
		user.setEmailId("avin@gmail.com");
		user.setPassword("avi38%ksh");
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
	@Ignore
	@Test
	public void getAllUsersTest()
	{
		List<UserInfo>userlist=(List<UserInfo>)userDao.getAllUser();
		assertNotNull("user list not found",userlist.get(0));
	}
	@Ignore
	@Test
	public void checkLoginTest()
	{
		UserInfo  user1=new UserInfo();
		user1.setUserName("Vihaan");
		user1.setPassword("7685h");
		assertNotNull("problem in Login",userDao.checkLogin(user1));
	}
	
	
	}
