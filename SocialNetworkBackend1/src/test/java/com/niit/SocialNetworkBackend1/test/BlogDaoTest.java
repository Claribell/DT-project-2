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
	@Test
	public void addBlogTest() {
		Blog blog=new Blog();
		blog.setUserName("Bindhu");
		blog.setBlogName("HTML");
		blog.setBlogContent("Based on HTML5");
		blog.setStatus("R");
		blog.setLikes(1);
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
    @Ignore
    @Test
    public void updateBlogTest() {
    	Blog blog=blogDao.getBlog(1);
    	blog.setBlogContent("Clientside MVC Framework");
    	assertTrue("problem in updating blog",blogDao.updateBlog(blog));
    	System.out.println("Blog Name:" +blog.getBlogName());
    	System.out.println("Blog Content:" +blog.getBlogContent());
     }
    @Ignore
    @Test
    public void getAllBlogTest()
    {
    	List<Blog>bloglist=(List<Blog>)blogDao.getAllBlogs();
    	assertNotNull("Blog list not found",bloglist.get(0));
    	for (Blog blog:bloglist)
    	{
    		System.out.println("BlogId:" + blog.getBlogId()+"::"+"BlogName:"+blog.getBlogName());
    	}
    }
    @Ignore
    @Test
    public void rejectBlogTest()
    {
    	Blog blog=(Blog)blogDao.getBlog(1);
    	assertTrue("problem in rejecting blog",blogDao.rejectBlog(blog));
    }
    @Ignore
    @Test
    public void approveBlogTest()
    {
    	Blog blog=(Blog)blogDao.getBlog(1);
    	assertTrue("problem in aproving blog",blogDao.approveBlog(blog));
    }
    @Ignore
    @Test
    public void deleteBlogTest()
    {
    	Blog blog=(Blog)blogDao.getBlog(22);
    	assertTrue("problem in deleting blog",blogDao.deleteBlog(blog));
    }
    @Ignore
    @Test
	public void incLikesBlogTest()
	{
		Blog blog=blogDao.getBlog(1);
		assertTrue("problem in incrementing likes",blogDao.incLikes(blog));
	}
   

}
