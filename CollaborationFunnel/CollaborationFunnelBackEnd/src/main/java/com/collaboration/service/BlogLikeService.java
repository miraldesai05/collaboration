package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.BlogLikeDAOImpl;
import com.collaboration.model.BlogLike;

@Service
@Transactional
public class BlogLikeService {

	@Autowired
	public BlogLikeDAOImpl blogLikeDAOImpl;
	
	public void addBlogLike(BlogLike blogLike)
	{
		blogLikeDAOImpl.addBlogLike(blogLike);
	}
	public void delete(int blogLikeId)
	{
		blogLikeDAOImpl.delete(blogLikeId);
	}
	public BlogLike get(int blogLikeId)
	{
		return blogLikeDAOImpl.get(blogLikeId);
	}
	public List<BlogLike> listByBlogId(int blogId)
	{
		return blogLikeDAOImpl.listByBlogId(blogId);
	}
}
