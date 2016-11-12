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
	</style>
</head>
<body>
<div ng-controller="UserController as ctrl">
<div ng-show="ctrl.user.errorMessage">
	<div class="alert alert-dander fade in">{{ctrl.user.errorMessage}}
	</div>
</div>
	
	<span ng-hide="ctrl.userLoggedIn">
		<form class="form-horizontal" name="form" ng-submit="ctrl.login()" role="form" method="POST">
	<div class="form-group">
        <label class="control-label col-sm-2">Username:</label>
        <div class="col-sm-10">
            <input type="text" name="username" ng-model="ctrl.user.username" required class="form-control" placeholder="Enter username" /><br>
            <span ng-show="form.username.$error.required" class="msg-val">Username is required.</span> 
        </div>    
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Password:</label>
        <div class="col-sm-10">
            <input type="password" name="password" ng-model="ctrl.user.password" required class="form-control" placeholder="Enter password" /><br>
            <span ng-show="form.password.$error.required" class="msg-val">Password is required.</span> 
        </div>    
    </div>
     <input type="submit" class="btn btn-primary" value="Login"/>
     <a href="#/userpage"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
		</form>
	</span>
</div>
</div>

</body>
</html>