package com.niit.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend1.Dao.UserDao;
import com.niit.SocialNetworkBackend1.model.User;

@RestController
@CrossOrigin(origins="http://localhost:9686")
@RequestMapping("/user")
public class UserController {
@Autowired	
private UserDao userDao;


@RequestMapping(value="/getAllUsers",method=RequestMethod.GET,headers="Accept=application/json")
public ResponseEntity getAllUser(){
	
	if(userDao.getAllUser().isEmpty()){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No User registerd..");
	}
	return new ResponseEntity(userDao.getAllUser(),HttpStatus.OK);
			
}
@RequestMapping(value="/register",method=RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user){
	
	boolean isSaved=userDao.save(user);
	if(isSaved)
	return new ResponseEntity<User>(user,HttpStatus.OK);
	else
		return new ResponseEntity<User>(user,HttpStatus.METHOD_FAILURE);
	
}

}
