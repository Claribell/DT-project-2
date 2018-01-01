package com.niit.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend1.Dao.ForumDao;
import com.niit.SocialNetworkBackend1.model.Forum;

@RestController
public class ForumController {
	
	@Autowired
	ForumDao forumDao;
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<String> insertForum(@RequestBody Forum forum)
	{
		forum.setCreationDate(new java.util.Date());
		forum.setStatus("R");
		if(forumDao.addForum(forum))
	{
		return new ResponseEntity<String>("Forum added",HttpStatus.OK);
	
	}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>>getAllForums()
	{
		ArrayList listforums=(ArrayList)forumDao.getAllForums();
		return new ResponseEntity <ArrayList<Forum>>(listforums,HttpStatus.OK);
	}
	
	@GetMapping(value="/deleteForum/{forumId}")
	public ResponseEntity<String>deleteforum(@PathVariable("forumId")int forumId)
	{
		Forum tempforum=forumDao.getForum(forumId);
		
		 if(forumDao.deleteForum(tempforum))
		 {
			 return new ResponseEntity<String>("Forum Deleted",HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<String>("Error in Forum deletion",HttpStatus.SERVICE_UNAVAILABLE);
		 }
	}
	
	@GetMapping(value="/approveForum/{forumId}")
	public ResponseEntity<String>approveForum(@PathVariable("forumId")int forumId)
	{
		Forum tempforum=forumDao.getForum(forumId);
		if(forumDao.approveForum(tempforum))
		{
			return new ResponseEntity<String>("Forum Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Forum approval",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/rejectForum/{forumId}")
	public ResponseEntity<String>rejectForum(@PathVariable("forumId")int forumId)
	{
		Forum tempforum=forumDao.getForum(forumId);
		if(forumDao.rejectForum(tempforum))
		{
			return new ResponseEntity<String>("Forum Rejected",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Forum Rejection",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}
