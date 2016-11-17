<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div ng-controller="HomeController as ctrl">
<div ng-hide="currentUser==''">
Welcome: {{currentUser.username}}
role:{{currentUser.role}}
</div>
</div>
<div class="container" ng-controller="FriendController as ctrl">
<div class="form-group has-feedback"></div>
Search 
<p><input type="text" ng-model="sear_text"></p>
<div ng-repeat="user in ctrl.users | filter: sear_text">
<fieldset>
<legend></legend>
<p>Online ?: {{user.isOnline}}
<p>ID: {{user.userId}} &nbsp;&nbsp;&nbsp;Name: {{user.name}}
&nbsp;&nbsp;&nbsp; <button type="button" ng-click="ctrl.sendFriendRequest(user.userId)"
class="btn btn-warning">Send Friend Request</button>
</p>
<p>Email:{{user.email}} &nbsp;&nbsp;&nbsp;Mobile:{{user.mobile}}</p>
<p>Address:{{user.address}} &nbsp;&nbsp;&nbsp; Role:{{user.role}}
</fieldset>
</div>
</div>

</body>
</html>