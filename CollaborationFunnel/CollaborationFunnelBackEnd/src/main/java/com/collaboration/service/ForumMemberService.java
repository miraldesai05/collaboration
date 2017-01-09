package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.ForumMemberDAOImpl;
import com.collaboration.model.ForumMember;

@Service
@Transactional
public class ForumMemberService {
	
	@Autowired
	public ForumMemberDAOImpl forumMemberDAOImpl;
	
	public void addForumMember(ForumMember forumMember)
	{
		forumMemberDAOImpl.addForumMember(forumMember);
	}
	/*public List<ForumMember> listForumMember()
	{
		return forumMemberDAOImpl.listForumMember();
	}*/
	public void delete(int forumMemberId)
	{
		forumMemberDAOImpl.delete(forumMemberId);
	}
	public ForumMember get(int forumMemberId)
	{
		return forumMemberDAOImpl.get(forumMemberId);
	}
	public void updateForumMember(ForumMember forumMember)
	{
		forumMemberDAOImpl.updateForumMember(forumMember);
	}
	public List<ForumMember> listByForumId(int forumId)
	{
		return forumMemberDAOImpl.listByForumId(forumId);
	}

}
