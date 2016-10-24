package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public List<User> listUser();
	public void delete(int userId);
	public User get(int userId);
	public void updateUser(User user);
	public User view(int userId);

}
