package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend1.model.Forum;

public interface ForumDao {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public List<Forum>getAllForums();
	public Forum getForum(int forumId);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
}
