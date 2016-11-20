<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" ng-controller="FriendController as ctr"> 
<input type="submit" ng-click="ctr.getMyFriend()" class="btn btn-primary" value="get Friend"/>  
<div ng-repeat="friend in ctr.friend | filter: sear_text">
<div class="container" ng-controller="UserController as ctrl">
<div ng-hide="currentUser.userId !== friend.friendId">
<p>friend Id: {{friend.userId}} &nbsp;&nbsp;&nbsp;Status: {{friend.status}}
<input type="submit" ng-click="ctr.unFriend(friend.userId)" class="btn btn-warning" value="unfriend"/>
<a href="#/chat">Send Message</a>
</p></div>
</fieldset>
</div> 
</div>
</div>
</body>
</html>