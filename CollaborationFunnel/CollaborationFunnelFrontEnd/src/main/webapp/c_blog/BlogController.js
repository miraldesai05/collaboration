'use strict';

app.factory('Blog', ['$resource', function ($resource) {
    return $resource('http://localhost:8085/CollaborationFunnelBackEnd/blog/:blogId', {blogId: '@blogId'},
	{
		updateBlog: {method: 'PUT'}
	}
    );
}]);
app.controller('BlogController', ['$scope', 'Blog','$location', function($scope, Blog, $location) {
    var ob = this;
    ob.blogs=[];
    ob.blog = new Blog(); 
    ob.fetchAllBlogs = function(){
        ob.blogs = Blog.query();
    };
    ob.fetchAllBlogs();
    ob.addBlog = function(){
	console.log('Inside save');
	if($scope.blogForm.$valid) {
	  ob.blog.$save(function(blog){
	     console.log(blog); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllBlogs();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editBlog = function(blogId){
	    console.log('Inside edit');
            ob.blog = Blog.get({ blogId: blogId}, function() {
	       ob.flag = 'edit'; 
	    });
    };
    ob.updateBlogDetail = function(){
	console.log('Inside update');
	if($scope.blogForm.$valid) {
    	   ob.blog.$updateBlog(function(blog){
    		console.log(blog); 
		ob.updatedId = blog.blogId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllBlogs();
           });
	}
    };	
    ob.viewBlog = function(blogId){
    	console.log('Inside view');
    	ob.viewblog = Blog.get({ blogId: blogId}, function(){
    		ob.flag = 'view';
    	});
    };
    ob.deleteBlog = function(blogId){
	    console.log('Inside delete');
	    ob.blog = Blog.delete({ blogId: blogId}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllBlogs(); 
	    });
    };		
    ob.reset = function(){
    	ob.blog = new Blog();
        $scope.blogForm.$setPristine();
    };	
    ob.cancelUpdate = function(blogId){
	    ob.blog = new Blog();
	    ob.flag= '';	
   	    ob.fetchAllBlogs();
    }; 
    ob.close = function(){
    	location.reload();
    };
}]);     