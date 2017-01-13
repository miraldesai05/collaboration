package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.ForumLike;

public interface ForumLikeDAO {

	public void addForumLike(ForumLike forumLike);
	public void delete(int forumLikeId);
	public ForumLike get(int forumLikeId);
	public List<ForumLike> listByForumId(int forumId);
}
