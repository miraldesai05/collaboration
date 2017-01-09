package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.JobApplication;

public interface JobApplicationDAO {

	public void addJobApplication(JobApplication jobApplication);
	/*public List<JobApplication> listJobApplication();*/
	public List<JobApplication> listByUserId(int userId);
	public void delete(int jobApplicationId);
	public JobApplication get(int jobApplicationId);
	public void updateJobApplication(JobApplication jobApplication);
}
