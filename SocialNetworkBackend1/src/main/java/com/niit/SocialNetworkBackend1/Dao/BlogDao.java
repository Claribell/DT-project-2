package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend1.model.Blog;

public interface BlogDao {
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);

}
