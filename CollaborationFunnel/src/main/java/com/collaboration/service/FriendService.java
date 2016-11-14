package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.FriendDAOImpl;
import com.collaboration.model.Friend;

@Service
@Transactional
public class FriendService {
	
	@Autowired
	public FriendDAOImpl friendDAOImpl;
	
	public List<Friend> getMyFriends(int userId)
	{
		return friendDAOImpl.getMyFriends(userId);
	}
	public Friend get(int userId,int friendId)
	{
		return friendDAOImpl.get(userId, friendId);
	}
	public boolean save(Friend friend)
	{
		return friendDAOImpl.save(friend);
	}
	public boolean update(Friend friend)
	{
		return friendDAOImpl.update(friend);
	}
	public void delete(int userId,int friendId)
	{
		friendDAOImpl.delete(userId, friendId);
	}
	public List<Friend> getNewFriendRequests(int userId)
	{
		return friendDAOImpl.getNewFriendRequests(userId);
	}
	public void setOnline(int friendId)
	{
		friendDAOImpl.setOnline(friendId);
	}
	public void setOffline(int friendId)
	{
		friendDAOImpl.setOffline(friendId);
	}
	public List<Friend> getMyFriend(int friendId)
	{
		return friendDAOImpl.getMyFriend(friendId);
	}
}
