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

import com.collaboration.model.BlogComment;
import com.collaboration.service.BlogCommentService;

@RestController
public class BlogCommentController {

	@Autowired(required = true)
	private BlogCommentService blogCommentService;
	
	/*@Autowired
	private BlogComment blogComment;*/
	
	@RequestMapping(value="/blogcomment", method=RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> getBlogCommentByBlogId(HttpSession session)
	{
		int blogId = (Integer)session.getAttribute("bId");
		List<BlogComment> blogComment = blogCommentService.listByBlogId(blogId);
		return new ResponseEntity<List<BlogComment>>(blogComment, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/blogcomment", method=RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> listBlogComments(){
		
		List<BlogComment> blogComment = blogCommentService.listBlogComments();
		if(blogComment.isEmpty()){		
			return new ResponseEntity<List<BlogComment>>(HttpStatus.NO_CONTENT);		
		}	
		return new ResponseEntity<List<BlogComment>>(blogComment,HttpStatus.OK);	
	}*/
	
	@RequestMapping(value="/blogcomment", method=RequestMethod.POST)
	public ResponseEntity<BlogComment> createBlogComment(@RequestBody BlogComment blogComment, HttpSession session){
		
		if(blogCommentService.get(blogComment.getBlogCommentId())== null)
		{
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			blogComment.setUserId(loggedInUserID);
			int blogId = (Integer)session.getAttribute("bId");
			blogComment.setBlogId(blogId);
			blogCommentService.addBlogComment(blogComment);
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		}
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/blogcomment/{blogCommentId}", method=RequestMethod.DELETE)
	public ResponseEntity<BlogComment> deleteBlogComment(@PathVariable("blogCommentId") int blogCommentId)
	{
		BlogComment blogComment=blogCommentService.get(blogCommentId);
		if(blogComment==null)
		{
			blogComment=new BlogComment();
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.NOT_FOUND);
		}
		blogCommentService.delete(blogCommentId);
		return new ResponseEntity<BlogComment>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/blogcomment/{blogCommentId}", method=RequestMethod.GET)
	public ResponseEntity<BlogComment> getBlogComment(@PathVariable("blogCommentId") int blogCommentId)
	{
		BlogComment blogComment=blogCommentService.get(blogCommentId);
		if(blogComment==null)
		{
			blogComment=new BlogComment();
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/blogcomment/{blogCommentId}", method=RequestMethod.PUT)
	public ResponseEntity<BlogComment> updateBlogComment(@RequestBody BlogComment blogComment){
		
		if(blogCommentService.get(blogComment.getBlogCommentId())== null)
		{
			blogComment=new BlogComment();
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.NOT_FOUND);	
		}
		blogCommentService.updateBlogComment(blogComment);
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	
}
