package com.niit.SocialNetworkBackend1.Dao;

import com.niit.SocialNetworkBackend1.model.Profilepic;

public interface ProfilepicDao {
	
	public boolean save(Profilepic profilepic);
	public Profilepic getProfilepic(String userName);

}
