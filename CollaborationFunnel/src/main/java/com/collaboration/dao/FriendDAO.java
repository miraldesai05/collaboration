package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Friend;

public interface FriendDAO {

	public List<Friend> getMyFriends(int userId);
	public Friend get(int userId,int friendId);
	public boolean save(Friend friend);
	public boolean update(Friend friend);
	public void delete(int userId,int friendId);
	public List<Friend> getNewFriendRequests(int userId);
	public void setOnline(int userId);
	public void setOffline(int userId);
}
