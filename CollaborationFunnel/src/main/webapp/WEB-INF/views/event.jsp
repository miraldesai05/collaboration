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
<div ng-app="myApp" ng-controller="EventController as eventCtrl" class="container">
<div ng-if="eventCtrl.flag != 'edit'">
<h2>Add New Event</h2>
</div>
<div ng-if="eventCtrl.flag == 'edit'">
<h2> Update Event for EVENTID: {{ eventCtrl.event.eventId }} </h2> 
</div>
 <form class="form-horizontal" name="eventForm" method="POST">
    <div class="form-group">
        <label class="control-label col-sm-2">Name:</label>
        <div class="col-sm-10">
            <input type="text" name="name" ng-model="eventCtrl.event.name" required class="form-control" placeholder="Enter name" /><br>
            <span ng-show="eventForm.name.$error.required" class="msg-val">Name is required.</span> 
        </div>    
    </div>
     <div class="form-group">    
        <label class="control-label col-sm-2">Venue:</label>
        <div class="col-sm-10">
            <input type="text" name="venue" ng-model="eventCtrl.event.venue" required class="form-control" placeholder="Enter venue" /><br>
            <span ng-show="eventForm.venue.$error.required" class="msg-val">Venue is required.</span> 
        </div>    
    </div>
    <div class="form-group">    
        <label class="control-label col-sm-2">Description:</label>
        <div class="col-sm-10">
            <input type="text" name="description" ng-model="eventCtrl.event.description" required class="form-control" placeholder="Enter description" /><br>
            <span ng-show="eventForm.description.$error.required" class="msg-val">Description is required.</span> 
        </div>    
    </div>
    <div class="form-group">    
        <label class="control-label col-sm-2">Date & Time:</label>
        <div class="col-sm-10">
            <input type="text" name="dateTime" ng-model="eventCtrl.event.dateTime" required class="form-control" placeholder="Enter date" /><br>
            <span ng-show="eventForm.dateTime.$error.required" class="msg-val">Date & Time is required.</span> 
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-10">  
             <span ng-if="eventCtrl.flag=='created'" class="msg-success">Event successfully added.</span>
		     <span ng-if="eventCtrl.flag=='failed'" class="msg-val">Event already exists.</span> 
        </div>    
    </div>
    <div class="form-group">  
        <div class="col-sm-offset-2 col-sm-10">  
        <div ng-if="eventCtrl.flag != 'edit'">
		       <input type="submit" ng-click="eventCtrl.addEvent()" class="btn btn-primary" value="Add Event"/>
		       <input type="button" ng-click="eventCtrl.reset()" class="btn btn-primary" value="Reset"/>
		</div>
		    <div ng-if="eventCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="eventCtrl.updateEventDetail()" class="btn btn-primary" value="Update Event"/> 	
			   <input type="button" ng-click="eventCtrl.cancelUpdate()" class="btn btn-primary" value="Cancel"/>				   
		    </div>  
		    <span ng-if="eventCtrl.flag=='deleted'" class="msg-success">Event successfully deleted.</span> 
		 </div> 
    </div>
 </form>
  <table class="table table-striped table-bordered">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Venue</th>
                <th>Description</th>
                <th>Date_Time</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="row in eventCtrl.events">
            	<td><span ng-bind="row.eventId"></span></td>
	        	<td><span ng-bind="row.name"></span></td>
	        	<td><span ng-bind="row.venue"></span></td>
	         	<td><span ng-bind="row.description"></span></td>
	         	<td><span ng-bind="row.dateTime"></span></td>
                <td> <a href="" ng-click="eventCtrl.editEvent(row.eventId)">edit</a> | <a href="" ng-click="eventCtrl.deleteEvent(row.eventId)">delete</a></td>
                <td><span ng-if="eventCtrl.flag=='updated' && row.eventId==eventCtrl.updatedId" class="msg-success">Event successfully updated.</span> </td>
            </tr>
        </tbody>
    </table>
</div>
	<script src="resources/js/angular.min.js"></script> 
    <script src="resources/js/angular-resource.min.js"></script>  
	<script src="resources/js/EventController.js"></script>
    <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>