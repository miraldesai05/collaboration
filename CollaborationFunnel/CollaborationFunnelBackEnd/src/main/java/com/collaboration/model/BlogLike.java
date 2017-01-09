package com.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="C_BlogLike")
public class BlogLike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogLikeId;
	private int userId;
	private int blogId;
	
	public int getBlogLikeId() {
		return blogLikeId;
	}
	public void setBlogLikeId(int blogLikeId) {
		this.blogLikeId = blogLikeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
}
