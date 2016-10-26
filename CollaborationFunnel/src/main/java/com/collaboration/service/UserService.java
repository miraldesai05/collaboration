package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.UserDAOImpl;
import com.collaboration.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	public UserDAOImpl userDAOImpl;
	
	public void addUser(User user)
	{
		userDAOImpl.addUser(user);
	}
	public List<User> listUser()
	{
		return userDAOImpl.listUser();
	}
	public void delete(int userId)
	{
		userDAOImpl.delete(userId);
	}
	public User get(int userId)
	{
		return userDAOImpl.get(userId);
	}
	public void updateUser(User user)
	{
		userDAOImpl.updateUser(user);
	}
	public User view(int userId)
	{
		return userDAOImpl.view(userId);
	}
	/*public User authenticate(String username, String password)
	{
		return userDAOImpl.authenticate(username, password);
	}*/
}
