package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Forum;

public interface ForumDAO {

	public void addForum(Forum forum);
	public List<Forum> listForum();
	public void delete(int forumId);
	public Forum get(int forumId);
	public void updateForum(Forum forum);
}
