<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myApp" ng-controller="MainCtrl">
  <h3>Login</h3>
  <!-- Form to get username & Password -->
   <form>
      <label>Username:</label><input type="text" ng-model="username" /></br></br>
      <label></label>Password:</label><input type="password" ng-model="password"></br>
      <button  type="submit" ng-click="submit()">login</button>
  </form>

<!-- Displaying the Array using ng-repeat -->
 <h2>user table</h2>
  <ul>
    <li ng-repeat="user in myusers">
      <a>{{user.username}}</a>
    </li>
  </ul>
  	<script src="resources/js/angular.min.js"></script>  
	<script src="resources/js/script.js"></script>
</body>
</html>