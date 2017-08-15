/**
 * Created by Lupus on 8/13/2017.
 */

angular.module("SnippetApp").controller('MainController', ['$rootScope', '$http', '$scope',
    function ($rootScope, $http, $scope) {

        $rootScope.isAdmin = function()
        {
            if(!$rootScope.isLogged()) return false;
            if($rootScope.USER.role === "ADMIN")
            {
                return true;
            }
            return false;
        }
        $rootScope.isRegistered = function()
        {
            if(!$rootScope.isLogged()) return false;
            if($rootScope.USER.role === "REGISTERED_USER")
            {
                return true;
            }
            return false;
        }
        $rootScope.isAnonimus = function()
        {
            if(!$rootScope.isLogged()) return false;
            if($rootScope.USER.role === "ANONIMUS")
            {
                return true;
            }
            return false;
        }

        $scope.register = function () {

            var json = JSON.stringify({
                "email": $scope.email,
                "password": $scope.password,
                "firstName": $scope.firstName,
                "lastName": $scope.lastName,
                "address": $scope.address,
                "picture": $scope.picture,
                "phone": $scope.phone,
                "role": "registered",
            });


            var url = "http://localhost:8080/api/register";
            $.ajax(
                {
                    type: 'POST',
                    url: url,
                    contentType: "application/json",
                    data: json,
                    success: function (response) {
                        var user = response;

                        console.log("User successfully created ");
                        console.log(user.name);
                    },
                    error: function (err) {
                        console.log("nenene");
                        console.log(err);

                    }
                }
            )
        };


        $scope.login = function () {
            var user = JSON.stringify({
                "userName": $scope.username,
                "password": $scope.password,
            });
            console.log($scope.username);
            var url = "/api/login";
            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: "text",
                data: user,
                success: function (data) {
                    //redirekt
                    if (data !== null) {

                        localStorage.setItem("LoggedUser", data);
                        $rootScope.USER = JSON.parse(data);
                        $window.location = '#snippets';
                        console.log("logged in");
                    }
                    else {
                        console.log("Not logged in");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka

                }
            });
        };

        $rootScope.isLogged = function()
        {
            if($rootScope.USER !== null && $rootScope.USER !== undefined)
            {
                return true;
            }
            if(localStorage.getItem("LoggedUser") !== "" && localStorage.getItem("LoggedUser") !== null)
            {
                var url = "../rs.ftn.jersey.webshop/rest/main/get/init";
                $.ajax({
                    type : 'GET',
                    url : url,
                    contentType : 'text/plain',
                    dataType : "text"
                });
                $rootScope.USER = JSON.parse(localStorage.getItem("LoggedUser"));

                if(!$scope.$$phase) {
                    $scope.$apply();
                }
            }
            return false;
        }

        $rootScope.logout = function()
        {
            $rootScope.USER = undefined;
            localStorage.removeItem('LoggedUser');
            $window.location = '#login';
        }
    }
]);