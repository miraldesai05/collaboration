package com.collaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.model.Friend;
import com.collaboration.service.FriendService;

@RestController
public class FriendController {
	
	@Autowired(required = true)
	private FriendService friendService;
	
	@Autowired
	private Friend friend;
	
	@RequestMapping(value="/myFriends", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriends(HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		List<Friend> myFriends = friendService.getMyFriends(loggedInUserID);
		return new ResponseEntity<List<Friend>>(myFriends, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addFriend/{friendId}", method=RequestMethod.POST)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendId") int friendId, HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		friend.setUserId(loggedInUserID);
		friend.setFriendId(friendId);
		friend.setIsOnline('N');
		friend.setStatus("N");
		friendService.save(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/unFriend/{friendId}", method=RequestMethod.GET)
	public ResponseEntity<Friend> unFriend(@PathVariable("friendId") int friendId, HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		friend.setUserId(loggedInUserID);
		friend.setFriendId(friendId);
		friend.setStatus("U");
		friendService.update(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/rejectFriend/{friendId}", method=RequestMethod.GET)
	public ResponseEntity<Friend> rejectFriendRequest(@PathVariable("friendId") int friendId, HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		friend.setUserId(loggedInUserID);
		friend.setFriendId(friendId);
		friend.setStatus("R");
		friendService.update(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getMyFriendRequests/", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriendRequests(HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		List<Friend> myFriendRequests = friendService.getNewFriendRequests(loggedInUserID);
		return new ResponseEntity<List<Friend>>(myFriendRequests, HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptFriend/{friendId}", method=RequestMethod.GET)
	public ResponseEntity<Friend> acceptFriendRequest(@PathVariable("friendId") int friendId, HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		friend.setUserId(loggedInUserID);
		friend.setFriendId(friendId);
		friend.setStatus("A");
		friendService.update(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);		
	}
	
	/*@RequestMapping(value="/myFriends/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriendsTemp(@PathVariable("id") int id)
	{
		List<Friend> myFriends = friendService.getMyFriends(id);
		return new ResponseEntity<List<Friend>>(myFriends, HttpStatus.OK);
	}*/
}
