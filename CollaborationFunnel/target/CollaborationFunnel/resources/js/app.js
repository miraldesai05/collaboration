var app = angular.module('App', ['ngRoute', 'ngCookies']);
 
    app.config(function($routeProvider) {
        $routeProvider
        
            /*.when('/', {
                controller: 'HomeController',
                templateUrl: 'home/home.view.html',
                controllerAs: 'vm'
            })*/
 
            .when('/login', {
                controller: 'UserController',
                templateUrl: 'login.jsp'
            })
 
           /* .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })*/
            
            .when('/blog1', {
                controller: 'BlogController',
                templateUrl: 'blog.jsp'
            })
 
           /* .otherwise({ redirectTo: '/login' });*/
    });
