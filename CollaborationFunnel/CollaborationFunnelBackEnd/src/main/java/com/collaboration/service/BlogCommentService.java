package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.BlogCommentDAOImpl;
import com.collaboration.model.BlogComment;

@Service
@Transactional
public class BlogCommentService {

	@Autowired
	public BlogCommentDAOImpl blogCommentDAOImpl;
	
	public void addBlogComment(BlogComment blogComment)
	{
		blogCommentDAOImpl.addBlogComment(blogComment);
	}
	/*public List<BlogComment> listBlogComments()
	{
		return blogCommentDAOImpl.listBlogComments();
	}*/
	public void delete(int blogCommentId)
	{
		blogCommentDAOImpl.delete(blogCommentId);
	}
	public BlogComment get(int blogCommentId)
	{
		return blogCommentDAOImpl.get(blogCommentId);
	}
	public void updateBlogComment(BlogComment blogComment)
	{
		blogCommentDAOImpl.updateBlogComment(blogComment);
	}
	public List<BlogComment> listByBlogId(int blogId)
	{
		return blogCommentDAOImpl.listByBlogId(blogId);
	}
}
