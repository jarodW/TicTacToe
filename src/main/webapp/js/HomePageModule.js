var homepageModule = angular.module('homepageModule', []);

homepageModule.controller('registerController', ['$scope', '$http', '$location','$window',

    function ($scope, $http, $location,$window) {

        $scope.register = function () {
        	console.log("here");
        	var data = {userName : $scope.username, password : $scope.password,  email: "q@q.com"};
        	console.log(data.userName);
    		$http.post("http://localhost:8080/player/create", data).success(function(re){
    			console.log(re);
    			$window.alert("Success");
    		}).error(function(re){
    			$window.alert("User Name Exist");
    		});
        }

    }
]);

homepageModule.controller('loginController', ['$scope', '$http', '$location','$window',

    function ($scope, $http, $location,$window) {

        $scope.login = function () {
        	console.log("here");
        	var data = {username : $scope.username, password : $scope.password};
        	console.log(data.userName);
    		$http.post("http://localhost:8080/login", data).success(function(re){
    			console.log(re);
    			$window.alert("Success");
    		}).error(function(re){
    			$window.alert("User Name Exist");
    		});
        }

    }
]);