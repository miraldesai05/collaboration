<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<title>Insert title here</title>

</head>
<body ng-app="myApp" ng-controller="getData">
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