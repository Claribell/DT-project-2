package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.Blog;

@Repository("blogDao")
public class BlogDaoImpl implements BlogDao{
	
	@Autowired
	public SessionFactory sessionfactory;
	
    @Transactional
	public boolean addBlog(Blog blog) {
		try {
			sessionfactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
    @Transactional
	public boolean updateBlog(Blog blog) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(blog);
			return true;
	       }
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionfactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Override
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}
