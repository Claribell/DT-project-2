package com.niit.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend1.Dao.BlogDao;
import com.niit.SocialNetworkBackend1.model.Blog;

@RestController
public class BlogController {
	
	@Autowired
	BlogDao blogDao;
	
	@PostMapping(value="/insertBlog")
	public ResponseEntity<String> insertBlog(@RequestBody Blog blog)
	{
		blog.setCreationDate(new java.util.Date());
		blog.setStatus("R");
		if(blogDao.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in blog added",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
	{
		ArrayList listBlogs=(ArrayList)blogDao.getAllBlogs();
		return new ResponseEntity <ArrayList<Blog>>(listBlogs,HttpStatus.OK);
	}
	
	@PutMapping(value="/updateBlog/{blogId}")
	public ResponseEntity<Blog>updateBlog(@PathVariable("blogId")int blogId, @RequestBody Blog blog)
	{
	Blog tempBlog=blogDao.getBlog(blogId);
	
	
	if (tempBlog != null)
	{
		tempBlog.setBlogName(blog.getBlogName());
		tempBlog.setBlogContent(blog.getBlogContent());
		return new ResponseEntity<Blog>(tempBlog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Blog>(HttpStatus.SERVICE_UNAVAILABLE);
	}
	}
	
	
	@GetMapping(value="/deleteBlog/{blogId}")
	public ResponseEntity<String>deleteBlog(@PathVariable("blogId")int blogId)
	{
		Blog tempBlog=blogDao.getBlog(blogId);
		
		 if(blogDao.deleteBlog(tempBlog))
		 {
			 return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<String>("Error in blog deletion",HttpStatus.SERVICE_UNAVAILABLE);
		 }
	}
	
	@GetMapping(value="/approveBlog/{blogId}")
	public ResponseEntity<String>approveBlog(@PathVariable("blogId")int blogId)
	{
		Blog tempblog=blogDao.getBlog(blogId);
		if(blogDao.approveBlog(tempblog))
		{
			return new ResponseEntity<String>("Blog Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Blog approval",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/rejectBlog/{blogId}")
	public ResponseEntity<String>rejectBlog(@PathVariable("blogId")int blogId)
	{
		Blog tempblog=blogDao.getBlog(blogId);
		if(blogDao.rejectBlog(tempblog))
		{
			return new ResponseEntity<String>("Blog Rejected",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Blog Rejection",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping(value="/inclike/{blogId}")
	public ResponseEntity<String>incLikes(@PathVariable("blogId")int blogId)
	{
		Blog tempblog=blogDao.getBlog(blogId);
		if(blogDao.incLikes(tempblog))
		{
			return new ResponseEntity<String>("Blog Incremented",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Blog Incrementation",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	


}
