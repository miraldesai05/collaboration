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

import com.collaboration.model.BlogLike;
import com.collaboration.service.BlogLikeService;

@RestController
public class BlogLikeController {
	
	@Autowired(required = true)
	private BlogLikeService blogLikeService;
	
	@RequestMapping(value="/bloglike", method=RequestMethod.POST)
	public ResponseEntity<BlogLike> createBlogLike(@RequestBody BlogLike blogLike, HttpSession session){
		
		if(blogLikeService.get(blogLike.getBlogLikeId())== null)
		{
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			blogLike.setUserId(loggedInUserID);
			int blogId = (Integer)session.getAttribute("bId");
			blogLike.setBlogId(blogId);
			blogLikeService.addBlogLike(blogLike);
			return new ResponseEntity<BlogLike>(blogLike,HttpStatus.OK);
		}
		return new ResponseEntity<BlogLike>(blogLike,HttpStatus.OK);
	}
	
	@RequestMapping(value="/bloglike/{blogLikeId}", method=RequestMethod.DELETE)
	public ResponseEntity<BlogLike> deleteBlogLike(@PathVariable("blogLikeId") int blogLikeId)
	{
		BlogLike blogLike=blogLikeService.get(blogLikeId);
		if(blogLike==null)
		{
			blogLike=new BlogLike();
			return new ResponseEntity<BlogLike>(blogLike,HttpStatus.NOT_FOUND);
		}
		blogLikeService.delete(blogLikeId);
		return new ResponseEntity<BlogLike>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/bloglike/{blogLikeId}", method=RequestMethod.GET)
	public ResponseEntity<BlogLike> getBlogLike(@PathVariable("blogLikeId") int blogLikeId)
	{
		BlogLike blogLike=blogLikeService.get(blogLikeId);
		if(blogLike==null)
		{
			blogLike=new BlogLike();
			return new ResponseEntity<BlogLike>(blogLike,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BlogLike>(blogLike,HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/bloglike/{blogId}", method=RequestMethod.GET)
	public ResponseEntity<BlogLike> getBlogAllLike(@PathVariable("blogId") int blogId)
	{
		BlogLike blogLike=blogLikeService.getAllLike(blogId);
		if(blogLike==null)
		{
			blogLike=new BlogLike();
			return new ResponseEntity<BlogLike>(blogLike,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BlogLike>(blogLike,HttpStatus.OK);
	}*/
	@RequestMapping(value="/bloglike", method=RequestMethod.GET)
	public ResponseEntity<List<BlogLike>> getBlogLikeByBlogId(HttpSession session)
	{
		int blogId = (Integer)session.getAttribute("bId");
		List<BlogLike> blogLike = blogLikeService.listByBlogId(blogId);
		return new ResponseEntity<List<BlogLike>>(blogLike, HttpStatus.OK);
	}
}
