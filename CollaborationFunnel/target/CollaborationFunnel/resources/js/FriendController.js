'use strict';

app.controller('FriendController', ['UserController','$scope','FriendService','$location','$rootScope',function(UserController,$scope,FriendService,$location, $rootScope){
	console.log("FriendController...")
	var ob = this;
	ob.friend={id:'',userId:'',friendId:'',status:''};
	ob.friends=[];
	
	ob.user = {
			userId : '',
			name : '',
			email :'',
			address : '',
			mobile : '',
			role : '',
			username :'',
			password :'',
			errorMessage :''
			};
	ob.users = [];
	 
	ob.sendFriendRequest=sendFriendRequest
	
	function sendFriendRequest(friendId)
	{
		console.log("->sendFriendRequest :"+friendId)
		   FriendService.sendFriendRequest(friendId)
		   	.then(
		   			function(d){
		   				ob.friend = d;
		   				alert("Friend request sent")
		   			},
		   			function(errResponse){
		   				console.error('Error while sending friend request');
		   			}
		   			);
	}
	
	ob.getMyFriends = function(){
		console.log("Getting my friends")
		FriendService.getMyFriends()
			.then(
					function(d){
		   				ob.friend = d;
		   				alert("get my friends")
		   			},
		   			function(errResponse){
		   				console.error('Error while getting my friends');
		   			}	
				);
	}
	ob.updateFriendRequest = function(friend, id){
		FriendService.updateFriendRequest(friend, id)
			.then(
					ob.fetAllFriends,
					function(errResponse){
						console.error('Error while updating Friend.');
					}
				);
	};
	ob.deleteFriend = function(id){
		FriendService.deleteFriend(id)
			.then(
					ob.fetAllFriends,
					function(errResponse){
						console.error('Error while deleting Friend.');
					}
				);
	};
	ob.fetchAllUsers = function(){
		UserContoller.fetchAllUsers().then(function(d){
			ob.users = d;
		}, function(errResponse){
			console.error('Error while fetching users');
		});
	};
	
	ob.fetAllUsers();
	ob.getMyFriends();
	
	
}]); 