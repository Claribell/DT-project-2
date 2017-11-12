package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend1.model.User;

public interface UserDao {

	 List<User> getAllUser();
	 
	 boolean save(User user);

}
