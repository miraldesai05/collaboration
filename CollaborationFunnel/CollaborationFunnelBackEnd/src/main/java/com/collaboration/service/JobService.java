package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.JobDAOImpl;
import com.collaboration.model.Job;

@Service
@Transactional
public class JobService {
	
	@Autowired
	public JobDAOImpl jobDAOImpl;
	
	/*public boolean postJob(Job job)
	{
		return jobDAOImpl.postJob(job);
	}
	public boolean updateJob(Job job)
	{
		return jobDAOImpl.updateJob(job);
	}
	public List<Job> getAllVacantJobs()
	{
		return jobDAOImpl.getAllVacantJobs();
	}
	public List<Job> getAllJobs()
	{
		return jobDAOImpl.getAllJobs();
	}
	public boolean applyForJob(JobApplication jobApplication)
	{
		return jobDAOImpl.applyForJob(jobApplication);
	}
	public boolean updateJobApplication(JobApplication jobApplication)
	{
		return jobDAOImpl.updateJobApplication(jobApplication);
	}
	public JobApplication get(int userId,int jobId)
	{
		return jobDAOImpl.get(userId, jobId);
	}
	public JobApplication getMyAppliedJobs(int userId)
	{
		return jobDAOImpl.getMyAppliedJobs(userId);
	}
	public List<JobApplication> listJobApplication()
	{
		return jobDAOImpl.listJobApplication();
	}
	public Job getJobDetails(int jobId)
	{
		return jobDAOImpl.getJobDetails(jobId);
	}
    public JobApplication getJobApplication(int userId)
    {
    	return jobDAOImpl.getJobApplication(userId);
    }*/
	public void addJob(Job job)
	{
		jobDAOImpl.addJob(job);
	}
	public List<Job> listJob()
	{
		return jobDAOImpl.listJob();
	}
	public void delete(int jobId)
	{
		jobDAOImpl.delete(jobId);
	}
	public Job get(int jobId)
	{
		return jobDAOImpl.get(jobId);
	}
	public void updateJob(Job job)
	{
		jobDAOImpl.updateJob(job);
	}
}
