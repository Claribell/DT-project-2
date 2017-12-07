package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.Blog;

@Repository("blogDao")
public class BlogDaoImpl implements BlogDao{
	
	@Autowired
	public SessionFactory sessionfactory;
	
 public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
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

	@Transactional
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
		Session session=sessionfactory.openSession();
		Blog blog=(Blog) session.get(Blog.class,blogId);
		session.close();
		return blog;
	}

	@Override
	public List<Blog> getAllBlogs() {
		Session session=sessionfactory.openSession();
		List<Blog>bloglist=(List<Blog>)session.createQuery("from Blog").list();
		session.close();
		return bloglist;
    }
    @Transactional
	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception occured:"+e);
		return false;
		}
	}
		
	@Transactional
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("R");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception occured:"+e);
		return false;
		}
	}
	@Transactional
	public boolean incLikes(Blog blog) {
		try
		{
			blog.setLikes(blog.getLikes()+1);
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
			return false;	
		}
		
	}

}
