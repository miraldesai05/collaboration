'use strict';
var app = angular.module('app', ['ngRoute','ngResource','ngCookies']);
 
    app.config(function($routeProvider) {
        $routeProvider
        
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'resources/home.jsp'
            })
 
            .when('/login', {
                controller: 'UserController',
                templateUrl: 'resources/login.jsp'
            })
            
             /*.when('/logout', {
                controller: 'UserController',
                templateUrl: 'resources/index.jsp'	
            })*/
            
            
           /* .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })*/
            
            .when('/blogpage', {
                controller: 'BlogController',
                templateUrl: 'resources/blog.jsp'
            })
            
            .when('/bloglist', {
                controller: 'BlogController',
                templateUrl: 'resources/bloglist.jsp'
            })
            
            .when('/userpage', {
                controller: 'UserController',
                templateUrl: 'resources/user.jsp'
            })
            
            .when('/eventpage', {
                controller: 'EventController',
                templateUrl: 'resources/event.jsp'
            })
 
           .otherwise({ redirectTo: '/' });
    });
