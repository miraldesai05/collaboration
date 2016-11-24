<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="resources/images/Capture.PNG">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<style>
body {
  padding-top: 50px;
  background:#F7F7F7;
  color:#666666;
  font-family: 'Roboto', sans-serif;
  font-weight:100;
}

body{
  width: 100%;
  background: -webkit-linear-gradient(left, #22d686, #24d3d3, #22d686, #24d3d3);
  background: linear-gradient(to right, #22d686, #24d3d3, #22d686, #24d3d3);
  background-size: 600% 100%;
  -webkit-animation: HeroBG 20s ease infinite;
          animation: HeroBG 20s ease infinite;
}
	@-webkit-keyframes HeroBG {
  0% {
    background-position: 0 0;
  }
  50% {
    background-position: 100% 0;
  }
  100% {
    background-position: 0 0;
  }
}

@keyframes HeroBG {
  0% {
    background-position: 0 0;
  }
  50% {
    background-position: 100% 0;
  }
  100% {
    background-position: 0 0;
  }
}
</style>
<title>Collaboration Website</title>
</head>
<body ng-app="myApp" ng-controller="getData" class="container">
<h1>Blog Details</h1>
<hr>
  <br>
      <h3>Title: {{blogdata.title}}</h3>
      <h3>Description: {{blogdata.description}}</h3>
      
    <script src="resources/js/angular.min.js"></script> 
    <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	 <script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope)
		 { 	
			$scope.blogdata = ${blogdetails};
		 });	
</script>
</body>
</html>