<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
<div ng-controller="ChatController" class="container">
<form ng-submit="addMessage()" name="messageForm">
<div class="chat_window">
	<div class="top_menu">
		<div class="buttons">
			<div class="button close"></div>
			<div class="button minimize"></div>
			<div class="button maximize"></div>
		</div>
		<div class="title">Chat</div>
	</div>
        <h3>
		<p ng-repeat="message in messages | orderBy:'time':false" class="message">	
		<time>{{message.time | date:'HH:mm'}}</time>
		<span ng-class="{self: message.self}">{{message.message}}</span>
		</p>
		</h3>

		<div class="bottom_wrapper clearfix">
			<div class="message_input_wrapper">
				<input type="text" class="message_input" placeholder="Type your message here..." ng-model="message" />
			</div>
			
			<button class="send_message" ng-disabled="message.length > max || message.length === 0">Send</button>
			&nbsp;&nbsp;&nbsp;<span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
			
		</div>
</div>
<div class="message_template">
		<li class="message">
			<div class="avatar"></div>
			<div class="text_wrapper">
				<div class="text"></div>
			</div>
		</li>
</div>
</form>
</div>
</body>
</html>
