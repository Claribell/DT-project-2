package com.niit.SocialNetworkBackend1.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend1.Dao.FriendDao;
import com.niit.SocialNetworkBackend1.model.Friend;


public class FriendDaoTest {

  static FriendDao friendDao;
  
  @BeforeClass
	public static void initialize() {
	AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
	annotationConfigAppContext.scan("com.niit.SocialNetworkBackend1.*");
	annotationConfigAppContext.refresh();
	friendDao=(FriendDao)annotationConfigAppContext.getBean("friendDao");
}

  @Test
  public void addFriendTest()
 {
	  Friend friend=new Friend();
	  friend.setFriendName("Clari");
	  friend.setUserName("Daniel");
	  friend.setStatus("R");
	  assertTrue("Failure",friendDao.createFriend(friend));
	 
 }
  @Ignore
  @Test
  public void getAllFriendRequestTest()
  {
	  List<Friend>listFriends=friendDao.getAllFriendRequest("Sanjay");
	  assertNotNull("problem in list friends",listFriends);
	  
 }
  @Ignore
  @Test
  public void approvefriendrequestTest()
  {
	  Friend friend=friendDao.getFriend(53);
	  assertTrue("problem in approving",friendDao.approveFriendRequest(friend));
  }
  @Ignore
  @Test
  public void rejectfriendrequestTest()
  {
	  Friend friend=friendDao.getFriend(53);
	  assertTrue("problem in rejecting",friendDao.rejectFriendRequest(friend));
  }
  @Ignore
  @Test
  public void getAllApprovedFriendTest()
  {
	  List<Friend>listFriends=friendDao.getApprovedFriends("Sanjay");
	  assertNotNull("problem in List Friends",listFriends);
  }

}
