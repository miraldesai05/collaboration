'use strict';

app.controller('HomeController', ['$scope','UserService','$location','$rootScope',function($scope,UserService,$location,$rootScope) {
	
	console.log("HomeController....");
	
	var ob = this;
	
	ob.getCurrentUser = function()
	{
		console.log("Loading current user")
		console.log("Current user:" + $rootScope.currentUser)
		if(!$rootScope.currentUser)
			{
				console.log("User not logged in")
				$rootScope.currentUser="";
			}
		console.log("User is logged in")
		return $rootScope.currentUser;
		$location.path('/logout');
	}
	
	ob.getCurrentUser();
	
}]);