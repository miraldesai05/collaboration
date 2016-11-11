<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<title>Insert title here</title>
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
      <a class="navbar-brand" href="#">CollaborationFunnel</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Blog<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#/blogpage">Add Blog</a></li>
            <li><a href="#/bloglist">Blog List</a></li>
          <!--   <li><a href="#">Page 1-3</a></li> -->
          </ul>
        </li>
        <li><a href="#/eventpage">Event</a></li>
        <li><a href="#/friend">view friend</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <div ng-controller="UserController as ctrl">
      <div ng-show="currentUser==''">
        <li><a href="#/userpage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </div>
      <div ng-hide="currentUser==''">
         <!-- <li><a href="#/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> -->
         <input type="submit" ng-click="ctrl.logout()" class="btn btn-primary" value="logout"/>
      </div>   
      </div>  
      </ul>
    </div>
  </div>
</nav>
<div ng-view>
</div>
    <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	
	<script src="resources/js/angular.js"></script> 
    <script src="resources/js/angular-resource.min.js"></script>  
    <script src="resources/js/angular-route.js"></script> 
    <script src="resources/js/angular-cookies.js"></script> 
    
    <script src="resources/js/sockjs.js"></script> 
    <script src="resources/js/stomp.js"></script> 
    
    <script src="resources/js/app.js"></script>
    <script src="resources/js/UserController.js"></script> 
    <script src="resources/js/UserService.js"></script> 
    <script src="resources/js/BlogController.js"></script> 
    <script src="resources/js/EventController.js"></script> 
    <script src="resources/js/HomeController.js"></script> 
    <script src="resources/js/FriendController.js"></script> 
    <script src="resources/js/FriendService.js"></script> 
    <script src="resources/js/ChatController.js"></script> 
    <script src="resources/js/ChatService.js"></script> 
   
</body>
</html>