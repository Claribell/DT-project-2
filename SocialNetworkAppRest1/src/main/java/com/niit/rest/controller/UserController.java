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

import com.niit.SocialNetworkBackend1.Dao.UserDao;
import com.niit.SocialNetworkBackend1.model.UserInfo;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping(value="/register")
	public ResponseEntity<String> registerUser(@RequestBody UserInfo user){
		user.setIsOnline("N");
		user.setRole("user");
		if(userDao.addUser(user))
		{
		return new ResponseEntity<String>("Registered",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Registration",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/logout/{userName}")
	public ResponseEntity<String>logout(@PathVariable("userName") String userName)
	{
	UserInfo user=userDao.getUser(userName);
	if(userDao.updateOnlineStatus("N", user))
	{
		return new ResponseEntity<String>("Logged out successfully",HttpStatus.OK);	
	}
	else
	{
		return new ResponseEntity<String>("could not logout",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
     @PostMapping(value="/login")
    public ResponseEntity<UserInfo>checkLogin(@RequestBody UserInfo user,HttpSession session)
    {
    	if(userDao.checkLogin(user)) {
    		UserInfo tempUser=userDao.getUser(user.getUserName());
    		userDao.updateOnlineStatus("Y", tempUser);
    		session.setAttribute("userName",user.getUserName());
    		
    		return new ResponseEntity<UserInfo>(tempUser,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<UserInfo>(user,HttpStatus.BAD_REQUEST);	
    	}
    }
     
    @GetMapping(value="/getAllusers")
 	public ResponseEntity<List<UserInfo>>getAllusers()
 	{
 		List <UserInfo> listusers=userDao.getAllUser();
 		if(listusers!=null)
 		{
 		return new ResponseEntity <List<UserInfo>>(listusers,HttpStatus.OK);
 		}
 		else
    	{
    		return new ResponseEntity<List<UserInfo>>(listusers,HttpStatus.BAD_REQUEST);	
    	}
 	}
	

}
