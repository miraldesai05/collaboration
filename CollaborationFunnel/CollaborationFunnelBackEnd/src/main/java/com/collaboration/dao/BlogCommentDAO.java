package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.BlogComment;

public interface BlogCommentDAO {

	public void addBlogComment(BlogComment blogComment);
	/*public List<BlogComment> listBlogComments();*/
	public List<BlogComment> listByBlogId(int blogId);
	public void delete(int blogCommentId);
	public BlogComment get(int blogCommentId);
	public void updateBlogComment(BlogComment blogComment);
}
