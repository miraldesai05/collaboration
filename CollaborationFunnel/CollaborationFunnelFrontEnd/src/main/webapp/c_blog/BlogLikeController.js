'use strict';

app.factory('BlogLike', ['$resource', function ($resource) {
    return $resource('http://localhost:8085/CollaborationFunnelBackEnd/bloglike/:blogLikeId', {blogLikeId: '@blogLikeId'},
	{
		updateBlogLike: {method: 'PUT'}
	}
    );
}]);
app.controller('BlogLikeController', ['$scope', 'BlogLike','$location', function($scope, BlogLike, $location) {
    var ob = this;
    ob.bloglikes=[];
    ob.bloglike = new BlogLike(); 
    ob.fetchAllBlogLikes = function(blogId){
        ob.bloglikes = BlogLike.query({blogId: blogId});
    };
    ob.fetchAllBlogLikes();
    ob.addBlogLike = function(){
	console.log('Inside save');
	if($scope.blogLikeForm.$valid) {
	  ob.bloglike.$save(function(bloglike){
	     console.log(bloglike); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllBlogLikes();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editBlogLike = function(blogLikeId){
	    console.log('Inside edit');
            ob.bloglike = BlogLike.get({ blogLikeId: blogLikeId}, function() {
	       ob.flag = 'edit'; 
	    });
    };
    ob.updateBlogLikeDetail = function(){
	console.log('Inside update');
	if($scope.blogLikeForm.$valid) {
    	   ob.bloglike.$updateBlogLike(function(bloglike){
    		console.log(bloglike); 
		ob.updatedId = bloglike.blogLikeId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllBlogLikes();
           });
	}
    };	
    ob.viewBlogLike = function(blogLikeId){
    	console.log('Inside view');
    	ob.viewbloglike = BlogLike.get({ blogLikeId: blogLikeId}, function(){
    		ob.flag = 'view';
    	});
    };
 
    ob.deleteBlogLike = function(blogLikeId){
	    console.log('Inside delete');
	    ob.bloglike = BlogLike.delete({ blogLikeId: blogLikeId}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllBlogLikes(); 
	    });
    };	
    ob.reset = function(){
    	ob.bloglike = new BlogLike();
        $scope.blogLikeForm.$setPristine();
    };	
    ob.cancelUpdate = function(blogLikeId){
	    ob.bloglike = new BlogLike();
	    ob.flag= '';	
   	    ob.fetchAllBlogLikes();
    };   
}]);     