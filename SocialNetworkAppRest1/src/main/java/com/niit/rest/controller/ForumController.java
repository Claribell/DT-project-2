package com.niit.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	

}
