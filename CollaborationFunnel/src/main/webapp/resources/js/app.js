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
 
           /* .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })*/
            
            .when('/blog1', {
                controller: 'BlogController',
                templateUrl: 'resources/blog.jsp'
            })
 
           /* .otherwise({ redirectTo: '/login' });*/
    });
