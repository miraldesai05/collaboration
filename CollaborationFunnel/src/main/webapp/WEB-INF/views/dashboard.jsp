<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="breadcrumbs" id="breadcrumbs">
    <ul class="breadcrumb">
        <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="#">Home</a>
        </li>
        <li class="active">Dashboard</li>
    </ul>
</div>
<div class="page-content">
    <div class="row">
        <div class="space-6"></div>
        <div class="col-sm-10 col-sm-offset-1">
            <div id="login-box" class="login-box visible widget-box no-border">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                    <i class="icon-coffee green"></i>
                    User Authenticated
                </h4>
                        <div class="space-16"></div>
                        UID: {{uid}}
                        <br/>NAME: {{name}}
                        <br/>E-MAIL: {{email}}
                        <br/>
                        <a ng-click="logout();">Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.page-content -->
</body>
</html>