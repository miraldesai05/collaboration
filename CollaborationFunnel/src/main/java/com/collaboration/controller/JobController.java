package com.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.model.Job;
import com.collaboration.service.JobService;

@RestController
public class JobController {
	
	@Autowired(required = true)
	private JobService jobService;
	
	@RequestMapping(value="/getAllJobs", method=RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllJobs()
	{
		List<Job> jobs=jobService.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	

}
