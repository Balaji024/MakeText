package com.maketext.service;

import java.util.List;

import com.maketext.model.Blog;
import com.maketext.model.BlogComment;

public interface BlogService {
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(int blogId);
	
	public List<Blog> listBlogs(String username);
	public boolean approvedBlog(Blog blog);
	public boolean rejectedBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listAllBlogs();
	public boolean incrementLike(Blog blog);
	
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(BlogComment blogComment);
	public BlogComment getBlogComment(int commentId);
	public List<BlogComment> listBlogComments(int blogId);


}
