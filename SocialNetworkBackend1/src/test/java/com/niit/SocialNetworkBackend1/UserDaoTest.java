package com.niit.SocialNetworkBackend1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend1.Dao.UserDao;
import com.niit.SocialNetworkBackend1.model.User;

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
		 
		 public void  saveTest()
		 {
			User user=new User();
			user.setUserName("Kushal");
			user.setEmailId("kushal@gmail.com");
			user.setPassword("kufod");
			assertTrue("problem in creating user details",userDao.save(user));
			
		 }
			

		}


