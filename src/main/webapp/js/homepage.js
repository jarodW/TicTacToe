var homePage = angular.module('homePage', ['ngRoute','homepageModule']);




homePage.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/about', {
            templateUrl: 'templates/about.html'
        }).
        when('/home', {
            templateUrl: 'templates/home.html'
        }).
        when('/register', {
            templateUrl: 'templates/register.html',
            controller: 'registerController'
        }).
        when('/login',{
        	templateUrl: 'templates/login.html',
        	controller: 'loginController'
        }).
        otherwise({
            redirectTo: '/home'
        });
}]);
