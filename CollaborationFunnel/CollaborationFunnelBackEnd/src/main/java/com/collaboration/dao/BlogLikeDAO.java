package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.BlogLike;

public interface BlogLikeDAO {

	public boolean addBlogLike(BlogLike blogLike);
	public void delete(int blogLikeId);
	public BlogLike get(int blogLikeId);
	public List<BlogLike> listByBlogId(int blogId);
	public boolean blogLikeExists(int blogId, int userId);
}
