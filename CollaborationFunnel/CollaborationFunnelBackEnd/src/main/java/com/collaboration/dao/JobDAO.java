package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Job;

public interface JobDAO {
	
	/*public boolean postJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> getAllVacantJobs();
	public List<Job> getAllJobs();
	public boolean applyForJob(JobApplication jobApplication);
	public boolean updateJobApplication(JobApplication jobApplication);
	public JobApplication get(int userId,int jobId);
	public JobApplication getMyAppliedJobs(int userId);
	
    public List<JobApplication> listJobApplication();
	public Job getJobDetails(int jobId);
    public JobApplication getJobApplication(int userId);*/
	
	public void addJob(Job job);
	public List<Job> listJob();
	public void delete(int jobId);
	public Job get(int jobId);
	public void updateJob(Job job);
}