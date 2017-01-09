package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.ForumDAOImpl;
import com.collaboration.model.Forum;

@Service
@Transactional
public class ForumService {
	
	@Autowired
	public ForumDAOImpl forumDAOImpl;
	
	public void addForum(Forum forum)
	{
		forumDAOImpl.addForum(forum);
	}
	public List<Forum> listForum()
	{
		return forumDAOImpl.listForum();
	}
	public void delete(int forumId)
	{
		forumDAOImpl.delete(forumId);
	}
	public Forum get(int forumId)
	{
		return forumDAOImpl.get(forumId);
	}
	public void updateForum(Forum forum)
	{
		forumDAOImpl.updateForum(forum);
	}
}
