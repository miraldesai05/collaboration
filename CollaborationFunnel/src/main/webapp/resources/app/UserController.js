var app = angular.module('myApp', ['ngResource']);
app.factory('User', ['$resource', function ($resource) {
    return $resource('http://localhost:8085/CollaborationFunnel/user/:userId', {userId: '@userId'},
	{
		updateUser: {method: 'PUT'}
	}
    );
}]);
app.controller('UserController', ['$scope', 'User', function($scope, User) {
    var ob = this;
    ob.users=[];
    ob.user = new User(); 
    ob.fetchAllUsers = function(){
        ob.users = User.query();
    };
    ob.fetchAllUsers();
    ob.addUser = function(){
	console.log('Inside save');
	if($scope.userForm.$valid) {
	  ob.user.$save(function(user){
	     console.log(user); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllUsers();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editUser = function(userId){
	    console.log('Inside edit');
            ob.user = User.get({ userId: userId}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateUserDetail = function(){
	console.log('Inside update');
	if($scope.userForm.$valid) {
    	   ob.user.$updateUser(function(user){
    		console.log(user); 
		ob.updatedId = user.userId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllUsers();
           });
	}
    };	
    ob.deleteUser = function(userId){
	    console.log('Inside delete');
	    ob.user = User.delete({ userId: userId}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllUsers(); 
	    });
    };		
    ob.reset = function(){
    	ob.user = new User();
        $scope.userForm.$setPristine();
    };	
    ob.cancelUpdate = function(userId){
	    ob.user = new User();
	    ob.flag= '';	
   	    ob.fetchAllUsers();
    };    
    $scope.doLogin = function (customer) {
        Data.post('login', {
            customer: customer
        }).then(function (results) {
            Data.toast(results);
            if (results.status == "success") {
                $location.path('dashboard');
            }
        });
    };
    $scope.logout = function () {
        Data.get('logout').then(function (results) {
            Data.toast(results);
            $location.path('login');
        });
    };
}]);     