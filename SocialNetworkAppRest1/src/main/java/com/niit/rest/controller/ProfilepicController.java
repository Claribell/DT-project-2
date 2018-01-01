package com.niit.rest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.SocialNetworkBackend1.Dao.ProfilepicDao;
import com.niit.SocialNetworkBackend1.model.Profilepic;

@RestController
public class ProfilepicController {
	
	@Autowired
	ProfilepicDao profilepicDao;
	
	@PostMapping(value="/uploadpic")
	public ResponseEntity<?> uploadProfilepic(@RequestParam(value="file") CommonsMultipartFile fileUpload,HttpSession session)
	{
		/*String userName=(String)session.getAttribute("userName");*/
		Profilepic profilepic=new Profilepic();
		profilepic.setUserName("Daniel");
		System.out.println(fileUpload.getBytes());
		profilepic.setImage(fileUpload.getBytes());
		profilepicDao.save(profilepic);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/getImage/{userName}")
	public @ResponseBody byte[] getProfilepic(@PathVariable("userName") String userName, HttpStatus session)
	{
	Profilepic profilepic=profilepicDao.getProfilepic(userName);
	return profilepic.getImage();
	}
	
	

}
