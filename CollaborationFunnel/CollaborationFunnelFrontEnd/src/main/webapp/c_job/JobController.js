'use strict';

app.factory('Job', ['$resource', function ($resource) {
    return $resource('http://localhost:8085/CollaborationFunnelBackEnd/job/:jobId', {jobId: '@jobId'},
	{
		updateJob: {method: 'PUT'}
	}
    );
}]);
app.controller('JobController', ['$scope', 'Job','$location', function($scope, Job, $location) {
    var ob = this;
    ob.jobs=[];
    ob.job = new Job(); 
    ob.fetchAllJobs = function(){
        ob.jobs = Job.query();
    };
    ob.fetchAllJobs();
    ob.addJob = function(){
	console.log('Inside save');
	if($scope.jobForm.$valid) {
	  ob.job.$save(function(job){
	     console.log(job); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllJobs();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editJob = function(jobId){
	    console.log('Inside edit');
            ob.job = Job.get({ jobId: jobId}, function() {
	       ob.flag = 'edit'; 
	    });
    };
    ob.updateJobDetail = function(){
	console.log('Inside update');
	if($scope.jobForm.$valid) {
    	   ob.job.$updateJob(function(job){
    		console.log(job); 
		ob.updatedId = job.jobId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllJobs();
           });
	}
    };	
    ob.viewJob = function(jobId){
    	console.log('Inside view');
    	ob.viewjob = Job.get({ jobId: jobId}, function(){
    		ob.flag = 'view';
    	});
    };
    ob.deleteJob = function(jobId){
	    console.log('Inside delete');
	    ob.job = Job.delete({ jobId: jobId}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllJobs(); 
	    });
    };		
    ob.reset = function(){
    	ob.job = new Job();
        $scope.jobForm.$setPristine();
    };	
    ob.cancelUpdate = function(jobId){
	    ob.job = new Job();
	    ob.flag= '';	
   	    ob.fetchAllJobs();
    }; 
    ob.close = function(){
    	location.reload();
    };
}]);     