'use strict';

app.factory('FriendService',['$http','$q','$rootScope', function($http, $q, $rootScope){
	
	consolelog("FriendService...")
	
	var BASE_URL='http://localhost:8085/CollaborationFunnel'
		return{
		getMyFriends: function(){
			return $http.get(BASE_URL+'/myFriends')
			.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					console.error('Error while fetching friends');
					return $q.reject(errResponse);
					}			
				);
			},
		sendFriendRequest: function(friendId){
			return $http.get(BASE_URL+'/addFriend/'+friendId)
				.then(
						function(response){
							return response.data;
						},
						function(errResponse){
							console.error('Error while Creating friend');
							return $q.reject(errResponse);
							}			
						);
		},
		updateFriendRequest: function(friend, id){
			return $http.put(BASE_URL+'/friend/'+id, friend)
				.then(
						function(response){
							return response.data;
						},
						function(errResponse){
							console.error('Error while updating friend');
							return $q.reject(errResponse);
							}			
						);
		},
		deleteFriend: function(id){
			return $http.delete(BASE_URL+'/friend/'+id)
				.then(
						function(response){
							return response.data;
						},
						function(errResponse){
							console.error('Error while deleting friend');
							return $q.reject(errResponse);
							}			
						);
		}
}]);