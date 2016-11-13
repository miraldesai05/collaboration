<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container" ng-controller="FriendController as ctrl">
<div class="form-group has-feedback"></div>
Search for friend
<p><input type="text" ng-model="sear_text"></p>
<input type="submit" ng-click="ctrl.getMyFriendRequests()" class="btn btn-primary" value="Friend request"/>
<div ng-repeat="friend in ctrl.friend | filter: sear_text">
<fieldset>
<legend></legend>
<p>UserId: {{friend.userId}}&nbsp;&nbsp;&nbsp;Status: {{friend.status}}
<input type="submit" ng-click="ctrl.acceptFriendRequest(friend.friendId)" class="btn btn-warning" value="Accept Friend request"/>
<input type="submit" ng-click="ctrl.rejectFriendRequest(friend.friendId)" class="btn btn-danger" value="Reject Friend request"/>
</fieldset>
</div>
</div> 
</body>
</html>