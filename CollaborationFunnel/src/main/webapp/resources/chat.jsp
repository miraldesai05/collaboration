<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div ng-controller="ChatController" class="container">
<form ng-submit="addMessage()" name="messageForm">
<input type="text" placeholder="Compose a new message..." ng-model="message" />
<div class="info">
<span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
<button ng-disabled="message.length > max || message.length === 0">Send</button>
</div>
</form>
</hr>
<p ng-repeat="message in messages | orderBy:'time':true" class="message">
<time>{{message.time | date:'HH:mm'}}</time>
<span ng-class="{ob: message.ob}">{{message.message}}</span>
</div>
</body>
</html>