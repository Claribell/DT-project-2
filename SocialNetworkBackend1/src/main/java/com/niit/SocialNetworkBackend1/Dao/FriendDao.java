package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend1.model.Friend;

public interface FriendDao {
	
	public boolean createFriend(Friend friend);
	public List<Friend>getAllFriendRequest(String userName);
	public List<Friend>getApprovedFriends(String userName);
	public Friend getFriend(int friendId);
	public boolean rejectFriendRequest(Friend friend);
	public boolean approveFriendRequest(Friend friend);
	

}
