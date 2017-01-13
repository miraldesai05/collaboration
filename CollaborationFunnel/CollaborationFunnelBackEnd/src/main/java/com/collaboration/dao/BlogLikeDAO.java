package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.BlogLike;

public interface BlogLikeDAO {

	public void addBlogLike(BlogLike blogLike);
	public void delete(int blogLikeId);
	public BlogLike get(int blogLikeId);
	public List<BlogLike> listByBlogId(int blogId);
}
