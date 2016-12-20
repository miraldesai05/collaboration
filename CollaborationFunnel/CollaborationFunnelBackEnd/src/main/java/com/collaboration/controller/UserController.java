package com.collaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.model.User;
import com.collaboration.service.FriendService;
import com.collaboration.service.UserService;

@RestController
public class UserController {
	
	@Autowired(required = true)
	private UserService userService;
	
	@Autowired(required = true)
	private FriendService friendService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listUsers(){
		
		List<User> user = userService.listUser();
		if(user.isEmpty()){		
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);		
		}	
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		if(userService.get(user.getUserId())== null)
		{
			user.setIsOnline('N');
			userService.addUser(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId)
	{
		User user=userService.get(userId);
		if(user==null)
		{
			user=new User();
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		userService.delete(userId);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userId}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("userId") int userId)
	{
		User user=userService.get(userId);
		if(user==null)
		{
			user=new User();
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/myProfile", method=RequestMethod.GET)
	public ResponseEntity<User> myProfile(HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		User user=userService.get(loggedInUserID);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userId}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user){
		
		if(userService.get(user.getUserId())== null)
		{
			user=new User();
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);	
		}
		userService.updateUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/authenticate/", method=RequestMethod.POST)
	public ResponseEntity<User> authenticate(@RequestBody User user,HttpSession session)
	{
		user=userService.authenticate(user.getUsername(), user.getPassword());
		if(user==null)
		{
			user=new User();
			user.setErrorCode("404");
			user.setErrorMessage("Invalid Credentials. Please enter valid credentials");
		}
		else
		{
			user.setErrorCode("200");
			session.setAttribute("loggedInUser", user);
			session.setAttribute("loggedInUserId", user.getUserId());
			friendService.setOnline(user.getUserId());
			userService.setOnline(user.getUserId());
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	public String logout(HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		friendService.setOffline(loggedInUserID);
		userService.setOffline(loggedInUserID);
		session.invalidate();
		return ("you successfully logged out");
	}
}
