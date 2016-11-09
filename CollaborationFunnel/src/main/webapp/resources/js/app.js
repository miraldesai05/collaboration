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
            
             .when('/logout', {
                controller: 'UserController'	
            })
            
            
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
   
app.run( function ($rootScope, $location,$cookieStore, $http){ 
	
	$rootScope.$on('$locationChangeStart', function (event, next, current) {
        // redirect to login page if not logged in and trying to access a restricted page
        var restrictedPage = $.inArray($location.path(), ['/','/login', '/userpage']) === -1;
        console.log("restrictedPage:" +restrictedPage)
        var loggedIn = $rootScope.currentUser.userId;
        console.log("loggedIn:" +loggedIn)
        if (restrictedPage && !loggedIn) {
        	console.log("Navigating to login page")
            $location.path('/login');
        }
    });
	
    // keep user logged in after page refresh
    $rootScope.currentUser = $cookieStore.get('currentUser') || {};
    if ($rootScope.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser; 
    }
});
