package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.ForumLikeDAOImpl;
import com.collaboration.model.ForumLike;

@Service
@Transactional
public class ForumLikeService {

	@Autowired
	public ForumLikeDAOImpl forumLikeDAOImpl;
	
	public void addForumLike(ForumLike forumLike)
	{
		forumLikeDAOImpl.addForumLike(forumLike);
	}
	public void delete(int forumLikeId)
	{
		forumLikeDAOImpl.delete(forumLikeId);
	}
	public ForumLike get(int forumLikeId)
	{
		return forumLikeDAOImpl.get(forumLikeId);
	}
	public List<ForumLike> listByForumId(int forumId)
	{
		return forumLikeDAOImpl.listByForumId(forumId);
	}
}
