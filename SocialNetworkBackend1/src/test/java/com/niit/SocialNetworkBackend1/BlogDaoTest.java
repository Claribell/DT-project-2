package com.niit.SocialNetworkBackend1;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend1.Dao.BlogDao;
import com.niit.SocialNetworkBackend1.model.Blog;

public class BlogDaoTest {
	static BlogDao blogDao;
	
	 @BeforeClass
		public static void initialize() {
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.SocialNetworkBackend1");
		annotationConfigAppContext.refresh();
		blogDao=(BlogDao)annotationConfigAppContext.getBean("blogDao");
	 }

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

}
