package com.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="C_BlogComment")
public class BlogComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogCommentId;
	private int userId;
	private String blogCommentContent;
	private int blogId;
	
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBlogCommentContent() {
		return blogCommentContent;
	}
	public void setBlogCommentContent(String blogCommentContent) {
		this.blogCommentContent = blogCommentContent;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
}
