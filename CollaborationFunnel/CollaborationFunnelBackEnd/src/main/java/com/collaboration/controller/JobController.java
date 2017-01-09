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

import com.collaboration.model.Job;
import com.collaboration.service.JobService;

@RestController
public class JobController {
	

	/*@Autowired(required=true)
	private JobApplication jobApplication;*/
	
	@Autowired(required = true)
	private JobService jobService;
	
	/*@Autowired(required=true)
	private Job job;*/
	
	/*@RequestMapping(value = "/applyForJob/{jobId}", method = RequestMethod.POST)
	public ResponseEntity<Job> applyforJob(@PathVariable("jobId") int jobId, HttpSession session)
	{
		int loggedInUserId =(Integer)session.getAttribute("loggedInUserId");
		jobApplication.setUserId(loggedInUserId);
	    jobApplication.setJobId(jobId);
		jobApplication.setStatus('N');
		
		if (jobService.applyForJob(jobApplication))
		{
			job.setErrorCode("404");
			job.setErrorMessage("Not able to apply for the job");
			
		}
		 return new ResponseEntity<Job> (job , HttpStatus.OK);
	}
	
	 @RequestMapping(value="/jobaccept/{useId}" , method = RequestMethod.PUT)
	   public  ResponseEntity<JobApplication> jobaccept(@PathVariable("userId") int userId, @RequestBody JobApplication jobApplication ) 
	   {
		 jobApplication = jobService.getJobApplication(jobApplication.getUserId());  
		 
		  if(jobApplication==null)
		  {
			 
			  jobApplication = new JobApplication();
			  return new ResponseEntity<JobApplication>(jobApplication, HttpStatus.NOT_FOUND);
		  }
		  
		  jobApplication.setStatus('A');
		  jobService.updateJobApplication(jobApplication); 
		  
		   return new ResponseEntity<JobApplication>(jobApplication, HttpStatus.OK);
	   }
	
	 @RequestMapping(value="/rejectJobApplcation/{userId}/{jobId}",method= RequestMethod.PUT)
		public ResponseEntity<Job> rejectJobApplication(@PathVariable("userId") int userId , @PathVariable("jobId")int jobId){
			
			//jobApplication = jobDAO.getJobApplication(userID, jobID);
			
			jobApplication.setStatus('R');
			if(jobService.applyForJob(jobApplication) ==false) {
				job.setErrorCode("404");
				job.setErrorMessage("Not able to reject the application");
			}
			else
			{
				job.setErrorCode("200");
				job.setErrorMessage("Successfully updated the status as Rejected");
			}
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
	 
	 @RequestMapping(value="/getJobDetails/{JobId}", method = RequestMethod.GET)
		public ResponseEntity<Job> getJobDetails(@PathVariable("jobId") int jobId) {
			
			Job job= jobService.getJobDetails(jobId);
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
	 
	 @RequestMapping(value="/postJob", method=RequestMethod.POST)
		public ResponseEntity<Job> postJob(@RequestBody Job job, HttpSession session){
			
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			job.setUserId(loggedInUserID);
			job.setStatus('V');
			jobService.postJob(job);
			
			if(jobService.postJob(job) == false){
				
				job.setErrorCode("404");
				job.setErrorMessage("Not able to post a job");
			}
			else
			{
				job.setErrorCode("200");
				job.setErrorMessage("Successfully posted the job");
			}
			
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
	 
		
		@RequestMapping(value="/getMyAppliedJobs/" , method = RequestMethod.GET)
		public ResponseEntity<List<Job>> getMyAppliedJobs(HttpSession session) {
		
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			@SuppressWarnings("unchecked")
			List<Job> job = (List<Job>) jobService.getMyAppliedJobs(loggedInUserID);
			return new ResponseEntity<List<Job>>(job , HttpStatus.OK);
		}
		
		@RequestMapping(value="/canCallForInterview/{userId}/{jobId}",method = RequestMethod.PUT)
		public ResponseEntity<Job> callForInterview(@PathVariable("userId")int userId, @PathVariable("jobId")int jobId){
			
			jobApplication.setStatus('C');
			if(jobService.applyForJob(jobApplication)){
				job.setErrorCode("404");
				job.setErrorMessage("Not able to change the job application status 'Call for Interview'");
			}
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
		
		@RequestMapping(value="/selectUser/{userId}/{jobId}", method = RequestMethod.PUT)
		public ResponseEntity<Job> selectUser(@RequestParam("userId")int userId,@RequestParam("jobId")int jobId){
			
			jobApplication.setStatus('S');
			if(jobService.applyForJob(jobApplication)) {
				job.setErrorCode("404");
				job.setErrorMessage("Not able to change the application status as 'selected'");
			}
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
		
	 
	@RequestMapping(value="/getAllJobs", method=RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllJobs()
	{
		List<Job> jobs=jobService.getAllJobs();
		if(jobs == null)
		{
			job = new Job();
			job.setErrorCode("404");
       	  	job.setErrorMessage("No jobs are available");
       	  	return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
		 else
         {
			 return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
         }
		
	}
	
	@RequestMapping(value = "/getAllJobsApplication" , method = RequestMethod.GET)
	public ResponseEntity<List<JobApplication>> getjobsapplied()
	{
		List<JobApplication> jobapplied = jobService.listJobApplication();
		if(jobapplied == null)
		{
			job = new Job();
			job.setErrorCode("404");
       	  	job.setErrorMessage("No jobapplied are available");
       	  return new ResponseEntity<List<JobApplication>>(HttpStatus.NO_CONTENT);
		}
		 else
         {
       	  return new ResponseEntity<List<JobApplication>>(jobapplied, HttpStatus.OK);
         }
	}*/
	@RequestMapping(value="/job", method=RequestMethod.GET)
	public ResponseEntity<List<Job>> listJobs(){
		
		List<Job> job = jobService.listJob();
		if(job.isEmpty()){		
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);		
		}	
		return new ResponseEntity<List<Job>>(job,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/job", method=RequestMethod.POST)
	public ResponseEntity<Job> createJob(@RequestBody Job job, HttpSession session){
		
		if(jobService.get(job.getJobId())== null)
		{
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			job.setUserId(loggedInUserID);
			job.setStatus('V');
			jobService.addJob(job);
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/job/{jobId}", method=RequestMethod.DELETE)
	public ResponseEntity<Job> deleteJob(@PathVariable("jobId") int jobId)
	{
		Job job=jobService.get(jobId);
		if(job==null)
		{
			job=new Job();
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);
		}
		jobService.delete(jobId);
		return new ResponseEntity<Job>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/job/{jobId}", method=RequestMethod.GET)
	public ResponseEntity<Job> getJob(@PathVariable("jobId") int jobId, HttpSession session)
	{
		Job job=jobService.get(jobId);
		session.setAttribute("jId", job.getJobId());
		/*if(job==null)
		{
			job=new Job();
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/job/{jobId}", method=RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(@RequestBody Job job){
		
		if(jobService.get(job.getJobId())== null)
		{
			job=new Job();
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);	
		}
		jobService.updateJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
}
