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
		user.setUserId(5);
		user.setUserName("Nithin");
		user.setFirstName("Nithin");
		user.setLastName("Y");
		user.setEmailId("nithin@gmail.com");
		user.setPassword("5gfoi9@7");
		user.setIsOnline("N");
		user.setRole("User");
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
