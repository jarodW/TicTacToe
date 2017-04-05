var homepageModule = angular.module('homepageModule', []);

homepageModule.controller('loginController', ['$rootScope', '$scope', '$http', '$location',

    function (rootScope, scope, http, location) {

        rootScope.login = function () {
        	
        	var data = {username : scope.username, password : scope.password};
            var params = JSON.stringify(data);
            http.post("/login", params, {
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                }
            }).success(function (data, status, headers, config) {
            	console.log("suc");
            	console.log(data);
            }).error(function (data, status, headers, config) {
            	console.log("err");
              	console.log(data);
              	console.log(status);
              	console.log(headers);
              	
            });
        }

    }
]);

