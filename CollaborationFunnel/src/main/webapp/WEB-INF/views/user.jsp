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
<div ng-app="myApp" ng-controller="UserController as userCtrl" class="container">
<div ng-if="userCtrl.flag != 'edit'">
<h2>Add New User</h2>
</div>
<div ng-if="userCtrl.flag == 'edit'">
<h2> Update User for USERID: {{ userCtrl.user.userId }} </h2> 
</div>
 <form class="form-horizontal" name="userForm" method="POST">
    <div class="form-group">
        <label class="control-label col-sm-2">Name:</label>
        <div class="col-sm-10">
            <input type="text" name="name" ng-model="userCtrl.user.name" required class="form-control" placeholder="Enter your name" /><br>
            <span ng-show="userForm.name.$error.required" class="msg-val">Name is required.</span> 
        </div>    
    </div>
   <div class="form-group">
        <label class="control-label col-sm-2">Email:</label>
        <div class="col-sm-10">
            <input type="text" name="email" ng-model="userCtrl.user.email" required class="form-control" placeholder="Enter your email" /><br>
            <span ng-show="userForm.email.$error.required" class="msg-val">Email is required.</span> 
        </div>    
    </div>
   <div class="form-group">
        <label class="control-label col-sm-2">Address:</label>
        <div class="col-sm-10">
            <input type="text" name="address" ng-model="userCtrl.user.address" required class="form-control" placeholder="Enter your address" /><br>
            <span ng-show="userForm.address.$error.required" class="msg-val">Address is required.</span> 
        </div>    
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Mobile Number:</label>
        <div class="col-sm-10">
            <input type="text" name="mobile" ng-model="userCtrl.user.mobile" required class="form-control" placeholder="Enter your mobile number" /><br>
            <span ng-show="userForm.mobile.$error.required" class="msg-val">Mobile Number is required.</span> 
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-10">  
            <input type="hidden" ng-model="userCtrl.user.role" /><br>
        </div>    
    </div>
     <div class="form-group">
        <label class="control-label col-sm-2">Username:</label>
        <div class="col-sm-10">
            <input type="text" name="username" ng-model="userCtrl.user.username" required class="form-control" placeholder="Enter username" /><br>
            <span ng-show="userForm.username.$error.required" class="msg-val">Username is required.</span> 
        </div>    
    </div>
     <div class="form-group">
        <label class="control-label col-sm-2">Password:</label>
        <div class="col-sm-10">
            <input type="password" name="password" ng-model="userCtrl.user.password" required class="form-control" placeholder="Enter password" /><br>
            <span ng-show="userForm.password.$error.required" class="msg-val">Password is required.</span> 
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-10">  
             <span ng-if="blogCtrl.flag=='created'" class="msg-success">User successfully added.</span>
		     <span ng-if="blogCtrl.flag=='failed'" class="msg-val">User already exists.</span> 
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-offset-2 col-sm-10">  
        <div ng-if="userCtrl.flag != 'edit'">
		       <input type="submit" ng-click="userCtrl.addUser()" class="btn btn-primary" value="Add User"/>
		       <input type="button" ng-click="userCtrl.reset()" class="btn btn-primary" value="Reset"/>
		</div>
		    <div ng-if="userCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="userCtrl.updateUserDetail()" class="btn btn-primary" value="Update User"/> 	
			   <input type="button" ng-click="userCtrl.cancelUpdate()" class="btn btn-primary" value="Cancel"/>				   
		    </div>  
		    <span ng-if="userCtrl.flag=='deleted'" class="msg-success">User successfully deleted.</span> 
		 </div> 
    </div>
 </form>
  <table class="table table-striped table-bordered">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Mobile Number</th>
                <th>Username</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="row in userCtrl.users">
            	<td><span ng-bind="row.userId"></span></td>
	        	<td><span ng-bind="row.name"></span></td>
	         	<td><span ng-bind="row.email"></span></td>
	         	<td><span ng-bind="row.address"></span></td>
	         	<td><span ng-bind="row.mobile"></span></td>
	         	<td><span ng-bind="row.username"></span></td>
	         	<td><span ng-bind="row.password"></span></td>
                <td> <a href="" ng-click="userCtrl.editUser(row.userId)">edit</a> | <a href="" ng-click="userCtrl.deleteUser(row.userId)">delete</a>
                </td>
               <span ng-if="userCtrl.flag=='updated' && row.userId==userCtrl.updatedId" class="msg-success">User successfully updated.</span> 
            </tr>
        </tbody>
    </table>
</div>
	<script src="resources/js/angular.min.js"></script> 
    <script src="resources/js/angular-resource.min.js"></script>  
	<script src="resources/js/UserController.js"></script>
    <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>