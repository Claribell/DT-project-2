package com.niit.SocialNetworkBackend1.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend1.Dao.BlogDao;
import com.niit.SocialNetworkBackend1.model.Blog;

public class BlogDaoTest {

	static BlogDao blogDao;
	
	 @BeforeClass
		public static void initialize() {
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.SocialNetworkBackend1.*");
		annotationConfigAppContext.refresh();
		blogDao=(BlogDao)annotationConfigAppContext.getBean("blogDao");
	 }
    @Ignore
	@Test
	public void addBlogTest() {
		Blog blog=new Blog();
		blog.setUserName("Sharma");
		blog.setBlogName("AngularJs");
		blog.setBlogContent("Clientside framework");
		blog.setStatus("A");
		blog.setLikes(3);
		blog.setCreationDate(new Date());
		assertTrue("Problem in Inserting Blog",blogDao.addBlog(blog));
    }
    @Ignore
	@Test
    public void getBlogTest()
    {
    	Blog blog=blogDao.getBlog(1);
    	assertNotNull("Blog not found",blog);
    	System.out.println("Blog Name:" +blog.getBlogName());
    	System.out.println("Blog Content:" +blog.getBlogContent());
    }
	
   

}
