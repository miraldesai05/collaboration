<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<div ng-app="myApp" ng-controller="BlogController as blogCtrl" class="container">
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
		</tr>
        </div>    
    </div>
    <div class="form-group">    
        <label class="control-label col-sm-2">Description:</label>
        <div class="col-sm-10">
            <input type="text" name="description" ng-model="blogCtrl.blog.description" required class="form-control" placeholder="Enter description" /><br>
            <span ng-show="blogForm.description.$error.required" class="msg-val">Description is required.</span> 
		</tr>
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-10">  
            <input type="hidden" ng-model="blogCtrl.blog.userId" /><br>
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
    <table class="table table-striped table-bordered">
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
                <td> <a href="" ng-click="blogCtrl.editBlog(row.blogId)">edit</a> | <a href="" ng-click="blogCtrl.deleteBlog(row.blogId)">delete</a>
                </td>
               <span ng-if="blogCtrl.flag=='updated' && row.blogId==blogCtrl.updatedId" class="msg-success">Blog successfully updated.</span> 
            </tr>
        </tbody>
    </table>
</div>
	<script src="resources/js/angular.min.js"></script> 
    <script src="resources/js/angular-resource.min.js"></script>  
	<script src="resources/js/BlogController.js"></script>
    <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>