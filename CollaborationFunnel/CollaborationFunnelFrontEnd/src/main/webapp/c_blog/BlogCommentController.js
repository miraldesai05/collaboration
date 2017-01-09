'use strict';

app.factory('BlogComment', ['$resource', function ($resource) {
    return $resource('http://localhost:8085/CollaborationFunnelBackEnd/blogcomment/:blogCommentId', {blogCommentId: '@blogCommentId'},
	{
		updateBlogComment: {method: 'PUT'}
	}
    );
}]);
app.controller('BlogCommentController', ['$scope', 'BlogComment','$location', function($scope, BlogComment, $location) {
    var ob = this;
    ob.blogcomments=[];
    ob.blogcomment = new BlogComment(); 
    ob.fetchAllBlogComments = function(blogId){
        ob.blogcomments = BlogComment.query({blogId: blogId});
    };
    //ob.fetchAllBlogComments();
    ob.addBlogComment = function(){
	console.log('Inside save');
	if($scope.blogCommentForm.$valid) {
	  ob.blogcomment.$save(function(blogcomment){
	     console.log(blogcomment);
	     ob.flag= 'created';	
	     ob.reset();
	     ob.fetchAllBlogComments();  
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editBlogComment = function(blogCommentId){
	    console.log('Inside edit');
            ob.blogcomment = BlogComment.get({ blogCommentId: blogCommentId}, function() {
	       ob.flag = 'edit'; 
	    });
    };
    ob.updateBlogCommentDetail = function(){
	console.log('Inside update');
	if($scope.blogCommentForm.$valid) {
    	   ob.blogcomment.$updateBlogComment(function(blogcomment){
    		console.log(blogcomment); 
		ob.updatedId = blogcomment.blogCommentId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllBlogComments();
           });
	}
    };	
    ob.viewBlogComment = function(blogCommentId){
    	console.log('Inside view');
    	ob.viewblogcomment = BlogComment.get({ blogCommentId: blogCommentId}, function(){
    		ob.flag = 'view';
    	});
    };
    ob.deleteBlogComment = function(blogCommentId){
	    console.log('Inside delete');
	    ob.blogcomment = BlogComment.delete({ blogCommentId: blogCommentId}, function() {
		/*ob.reset(); */ 
		ob.flag = 'deleted';
    		ob.fetchAllBlogComments(); 
	    });
    };		
    ob.reset = function(){
    	ob.blogcomment = new BlogComment();
        $scope.blogCommentForm.$setPristine();
    };	
    ob.cancelUpdate = function(blogCommentId){
	    ob.blogcomment = new BlogComment();
	    ob.flag= '';	
   	    ob.fetchAllBlogComments();
    };    
}]);     