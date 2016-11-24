<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="resources/images/Capture.PNG">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<style>
body {
  padding-top: 90px;
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
<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <img src="resources/images/Capture5.png" alt="Image" style="width:250px;height:50px">
      <!-- <a class="navbar-brand" href="#">CollaborationFunnel</a> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
        <li><a href="#/userlist">User List</a></li> 
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown">Blog<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#/blogpage">Add Blog</a></li>
            <li><a href="#/bloglist">Blog List</a></li>
          <!--   <li><a href="#">Page 1-3</a></li> -->
          </ul>
        </li>
        <!-- <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown">Job<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#/jobpage">Search Job</a></li>
            <li><a href="#/viewjob">View Applied Job</a></li>
            <li><a href="#/joblist">Post Job</a></li>
          </ul>
        </li> -->
        <li><a href="#/eventpage">Event</a></li>
        <li><a href="#/chatforum">Chat Forum</a></li>
        <!-- <li><a href="#/friend">view friend</a></li> -->
         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown">Friend<span class="caret"></span></a>
          <ul class="dropdown-menu">
          	<!-- <li><a href="#/searchfriend"> Search Friend</a></li> -->
            <li><a href="#/friend">View friends</a></li>
            <li><a href="#/friendrequest">Friend request</a></li>
          <!--   <li><a href="#">Page 1-3</a></li> -->
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <div ng-controller="UserController as ctrl">
    <div ng-hide="currentUser.username!==ctrl.user.username">  
        <!-- <li><a href="#/userpage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <!-- <li><a href="#/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
       <a href="#/login"><input type="submit" class="btn btn-primary navbar-btn" value="Login"/></a>
      </div>
      <div ng-hide="currentUser.username===ctrl.user.username">
         <!-- <li><a href="#/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> -->
         <input type="submit" ng-click="ctrl.logout()" class="btn btn-primary navbar-btn" value="Logout"/>
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
    
   <!--  <script src="resources/js/sockjs.js"></script>  -->
    <script src="resources/js/sockjs.min.js"></script> 
    <script src="resources/js/stomp.js"></script> 
    <script src="resources/js/stomp.min.js"></script> 
    <script src="resources/lodash/dist/lodash.min.js"></script>
    
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
    <script src="resources/js/ChatForumController.js"></script> 
    <script src="resources/js/ChatForumService.js"></script> 
    <script src="resources/js/JobController.js"></script> 
    <script src="resources/js/JobService.js"></script>
   
</body>
</html>