package com.niit.rest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend1.Dao.FriendDao;
import com.niit.SocialNetworkBackend1.model.Friend;

@RestController
public class FriendController {
	
	@Autowired
	FriendDao friendDao;
	
	@PostMapping(value="/createFriendRequest")
	public ResponseEntity<String>createFriendRequest(@RequestBody Friend friend)
	{
		friend.setStatus("R");
		if(friendDao.createFriend(friend))
		{
			return new ResponseEntity<String>("Friend added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Friend added",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/approvalFriendRequest/{friendId}")
	public ResponseEntity<String>approveFriendRequest(@PathVariable("friendId") int friendId)
	{
	Friend friend=friendDao.getFriend(friendId);
	{
		if(friendDao.approveFriendRequest(friend))
		{
			return new ResponseEntity<String>("Friend Accepted",HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
			
	}
	
	@GetMapping(value="/RejectFriendRequest/{friendId}")
	public ResponseEntity<String>RejectFriendRequest(@PathVariable("friendId") int friendId)
	{
	Friend friend=friendDao.getFriend(friendId);
	{
		if(friendDao.rejectFriendRequest(friend))
		{
			return new ResponseEntity<String>("Friend Rejected",HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
			
	}
	
	@GetMapping(value="/getAllFriendRequest")
	public ResponseEntity<List<Friend>>getAllFriendRequest(HttpSession session)
	{
		String currentUser=(String)session.getAttribute("currentUser");
		List<Friend>listFriendRequest=friendDao.getAllFriendRequest(currentUser);
		return new ResponseEntity<List<Friend>>(listFriendRequest,HttpStatus.OK);	
	}
		
	
	
	

}
