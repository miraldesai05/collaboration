package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.BlogDAOImpl;
import com.collaboration.model.Blog;

@Service
@Transactional
public class BlogService {

	@Autowired
	public BlogDAOImpl blogDAOImpl;
	
	public void addBlog(Blog blog)
	{
		blogDAOImpl.addBlog(blog);
	}
	public List<Blog> listBlog()
	{
		return blogDAOImpl.listBlog();
	}
	public void delete(int blogId)
	{
		blogDAOImpl.delete(blogId);
	}
	public Blog get(int blogId)
	{
		return blogDAOImpl.get(blogId);
	}
	public void updateBlog(Blog blog)
	{
		blogDAOImpl.updateBlog(blog);
	}
}
