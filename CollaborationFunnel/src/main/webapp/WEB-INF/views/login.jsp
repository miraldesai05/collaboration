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
<div ng-app="Authentication" ng-controller="LoginController" class="container">
<div class="alert alert-info">
    Username: test<br />
    Password: test
</div>
<div ng-show="error" class="alert alert-danger">{{error}}</div>
<form name="form" ng-submit="login()" role="form">
    <div class="form-group">
        <label for="username">Username</label>
        <i class="fa fa-key"></i>
        <input type="text" name="username" id="username" class="form-control" ng-model="username" required />
        <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <i class="fa fa-lock"></i>
        <input type="password" name="password" id="password" class="form-control" ng-model="password" required />
        <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
    </div>
    <div class="form-actions">
        <button type="submit" ng-disabled="form.$invalid || dataLoading" class="btn btn-danger">Login</button>
        <img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
    </div>
</form>
</div>
</body>
</html>