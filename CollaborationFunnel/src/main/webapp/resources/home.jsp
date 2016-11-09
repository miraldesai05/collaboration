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
<div ng-controller="UserController as ctrl">
<div class="container">
		<h2>Search friend</h2>
		<div class="row"> <!-- search box row -->
		<div class="container">
			<form role="form" method="post" >
			 	<div class="row">
					<div class="col-xs-10 col-sm-6 col-md-6 col-lg-3 pull-right"> 
						<div class="form-group ">
							    <input type="text" ng-model="name" class="form-control cols-sm-5" name="searchKeyword" id="searchKeyword" placeholder="Search.."/>
 						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</body>
</html>