<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style>
	.msg-val {
	color: red;
	}
	.msg-success {
		color: green;
	} 
	</style>
</head>
<body>
<div ng-controller="BlogController as blogCtrl" class="container">
<div ng-if="blogCtrl.flag != 'edit'">
<h2>Add New Post</h2>
</div>
<div ng-if="blogCtrl.flag == 'edit'">
<h2> Update Post for BLOGID: {{ blogCtrl.blog.blogId }} </h2> 
</div>
 <form class="form-horizontal" name="blogForm" method="POST">
    <div class="form-group">
        <label class="control-label col-sm-2">Title:</label>
        <div class="col-sm-10">
            <input type="text" name="title" ng-model="blogCtrl.blog.title" required class="form-control" placeholder="Enter title" /><br>
            <span ng-show="blogForm.title.$error.required" class="msg-val">Title is required.</span> 
        </div>    
    </div>
    <div class="form-group">    
        <label class="control-label col-sm-2">Description:</label>
        <div class="col-sm-10">
            <textarea type="text" name="description" ng-model="blogCtrl.blog.description" required class="form-control" placeholder="Enter description" rows="5"></textarea><br>
            <span ng-show="blogForm.description.$error.required" class="msg-val">Description is required.</span> 
        </div>    
    </div>
    <div class="form-group">  
     	<label class="control-label col-sm-2">User Id:</label>
        <div class="col-sm-10">  
            <input type="text" name="userId" ng-model="blogCtrl.blog.userId" required class="form-control" placeholder="Enter user id" /><br>
            <span ng-show="blogForm.userId.$error.required" class="msg-val">User id is required.</span>
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-10">  
             <span ng-if="blogCtrl.flag=='created'" class="msg-success">Blog successfully added.</span>
		     <span ng-if="blogCtrl.flag=='failed'" class="msg-val">Blog already exists.</span> 
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-offset-2 col-sm-10">  
        <div ng-if="blogCtrl.flag != 'edit'">
		       <input type="submit" ng-click="blogCtrl.addBlog()" class="btn btn-primary" value="Add Blog"/>
		       <input type="button" ng-click="blogCtrl.reset()" class="btn btn-primary" value="Reset"/>
		</div>
		    <div ng-if="blogCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="blogCtrl.updateBlogDetail()" class="btn btn-primary" value="Update Blog"/> 	
			   <input type="button" ng-click="blogCtrl.cancelUpdate()" class="btn btn-primary" value="Cancel"/>				   
		    </div>  
		    <span ng-if="blogCtrl.flag=='deleted'" class="msg-success">Blog successfully deleted.</span> 
		 </div> 
    </div>
 </form>
  <table class="table table-bordered">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="row in blogCtrl.blogs">
            	<td><span ng-bind="row.blogId"></span></td>
	        	<td><span ng-bind="row.title"></span></td>
	         	<td><span ng-bind="row.description"></span></td>
                <td> <a href="" ng-click="blogCtrl.editBlog(row.blogId)">edit</a> | <a href="" ng-click="blogCtrl.deleteBlog(row.blogId)">delete</a></td>
                <span ng-if="blogCtrl.flag=='updated' && row.blogId==blogCtrl.updatedId" class="msg-success">Blog successfully updated.</span> 
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>