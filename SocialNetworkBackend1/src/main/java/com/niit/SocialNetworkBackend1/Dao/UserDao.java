package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend1.model.UserInfo;

public interface UserDao {
    public boolean addUser(UserInfo user);
	public boolean updateOnlineStatus(String status,UserInfo user);
	public UserInfo getUser(String userName);
	public UserInfo getByEmail(String email);
	public boolean delete(String email);
	public List<UserInfo> getAllUser();

}
