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
<div ng-repeat="friend in ctrl.friends | filter: sear_text">
<fieldset>
<legend></legend>
<p>Name: {{friend.name}} &nbsp;&nbsp;&nbsp;Status: {{friend.status}}
<a href="#/chat">Send Message</a>
</fieldset>
</div>
</div>
</body>
</html>