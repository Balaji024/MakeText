package com.maketext.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maketext.model.Blog;
import com.maketext.model.BlogComment;
@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{
@Autowired
private SessionFactory sessionFactory;
	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		System.out.println("Exception Arised..........:"+e);
		return false;
		}
		
	}

	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		System.out.println("BEFORE INSERT/UPDATE " + blog.getBlogId());
		//if id==0, insert query
		//if id exits in the table, update query
	//INsert into product values (?,.....)
		System.out.println("AFTER INSERT/UPDATE " + blog.getBlogId());
		return true;
		}
		catch(Exception e) {
			System.out.println("Exception Arised:"+e);
			
		}

		return false;
	}

	public boolean deleteBlog(int blogId) {
		try
		{
			Blog blog=(Blog) sessionFactory.getCurrentSession().get(Blog.class,blogId);
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
		// TODO Auto-generated method stub
		
	

	public List<Blog> listBlogs(String username) {
		// TODO Auto-generated method stub
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Blog where loginname=:username");
			query.setParameter("username",username);
			List<Blog> listBlogs=query.list();
			return listBlogs;
		}
		catch(Exception e)
		{
			return null;
		}
					
		
	}

	public boolean approvedBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		}

	public boolean rejectedBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		

	}

	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class,blogId);
		return blog;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	public List<Blog> listAllBlogs() {
		// TODO Auto-generated method stub
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Blog ");
			
			List<Blog> listBlogs=query.list();
			return listBlogs;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	public boolean incrementLike(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
			int likes=blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
	catch(Exception e)
		{
		return false;
		}
	}

	public boolean addBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(blogComment);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		System.out.println("Exception Arised..........:"+e);
		return false;
		}
		
		
	}

	public boolean deleteBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			//Product product1=(Product)session.get(Product.class,product.getProductId());
			
			return true;
			}
			catch(Exception e) {
				System.out.println("Exception Arised:"+e);
			return false;
			}
	}

	public BlogComment getBlogComment(int commentId) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionFactory.openSession();
		BlogComment blogComment=(BlogComment)session.get(BlogComment.class,commentId);
		return blogComment;
		}
		catch(Exception e)
		{
			return null;
		}
		
	
	}

	public List<BlogComment> listBlogComments(int blogId) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from BlogComment");
			
			List<BlogComment> listBlogComments=query.list();
			return listBlogComments(0);
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	

}
