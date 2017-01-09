package com.collaboration.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.collaboration.model.User;
import com.collaboration.service.FriendService;
import com.collaboration.service.UserService;

@RestController
public class UserController {
	
	Path path;
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
	public ResponseEntity<User> createUser(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "name") String name,
			@RequestParam(value = "email") String email, @RequestParam(value = "address") String address, @RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request){
		
		User user= new User();
		if(userService.get(user.getUserId())== null)
		{
			user.setName(name);
			user.setEmail(email);
			user.setAddress(address);
			user.setMobile(mobile);
			user.setRole("user");
			user.setUsername(username);
			user.setPassword(password);
			user.setIsOnline('N');
			userService.addUser(user);
			
			int Id= user.getUserId();
			//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			String rootDirectory = "F:\\Project\\CollaborationFunnelFrontEnd\\src\\main\\webapp\\resources\\images\\"+Id+".jpg";
			File f=new File(rootDirectory);
			System.out.println("Root Directory "+rootDirectory);
		/*	try {
				file.transferTo(new File(rootDirectory  + file.getOriginalFilename()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			//return null;
			/*MultipartFile image = user.getImage();
			//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			//System.out.println(rootDirectory);
			path = Paths.get("D:\\image\\");
			//System.out.println("Root Directory "+rootDirectory);*/

			if (!file.isEmpty()) {
				try {
					byte[] bytes=file.getBytes();
					FileOutputStream fos=new FileOutputStream(f);
					BufferedOutputStream bs=new BufferedOutputStream(fos);
					bs.write(bytes);
					bs.close();
					//image.transferTo(new File(path.toString()));
					System.out.println("File successfully uploaded" + rootDirectory);
				} catch (Exception ex) {
					System.out.println("Exception Occured" + ex);
				}
			}
			else
			{
				System.out.println("File is empty not uploaded");
			}
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
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
	
	@RequestMapping(value="/userupdate", method=RequestMethod.POST)
	public ResponseEntity<User> update(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, HttpSession session){
		
			//User user= new User();
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			//int Id= user.getUserId();
			//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			String rootDirectory = "F:\\Project\\CollaborationFunnelFrontEnd\\src\\main\\webapp\\resources\\images\\"+loggedInUserID+".jpg";
			File f=new File(rootDirectory);
			System.out.println("Root Directory "+rootDirectory);
		
			if (!file.isEmpty()) {
				try {
					byte[] bytes=file.getBytes();
					FileOutputStream fos=new FileOutputStream(f);
					BufferedOutputStream bs=new BufferedOutputStream(fos);
					bs.write(bytes);
					bs.close();
					//image.transferTo(new File(path.toString()));
					System.out.println("File successfully uploaded" + rootDirectory);
				} catch (Exception ex) {
					System.out.println("Exception Occured" + ex);
				}
			}
			else
			{
				System.out.println("File is empty not uploaded");
			}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
