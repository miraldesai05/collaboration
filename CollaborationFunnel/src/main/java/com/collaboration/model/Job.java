package com.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="C_Job")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobId;
	private String title;
	private String description;
	private String qualification;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
	private Date dateTime;
	private char status;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		if(status==null)
		{
			status=new Character('v');
		}
		this.status = status;
	}
	public Job()
	{
		Date d= new Date();
		dateTime=d;
	}
}
