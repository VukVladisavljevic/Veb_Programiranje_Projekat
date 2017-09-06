/**
 * Created by Lupus on 8/13/2017.
 */

angular.module("SnippetApp").controller('MainController', ['$rootScope', '$http', '$scope', '$window',
    function ($rootScope, $http, $scope, $window) {

        $rootScope.isAdmin = function()
        {
            if(!$rootScope.isLogged())
                return false;
            if($rootScope.USER.role === "admin")
            {
                return true;
            }
            return false;
        };

        $rootScope.isRegistered = function()
        {
            if(!$rootScope.isLogged()) {
                return false;
            }
            if($rootScope.USER.role === "reg_user") {
               {
                   return true;
               }
            }
            return false;
        };

        $rootScope.isGuest = function()
        {
            if(!$rootScope.isLogged()) return false;
            if($rootScope.USER.role === "guest")
             {
             return true;
             }
            return false;
        };

        $rootScope.isLogged = function (){

            if($rootScope.USER !== null && $rootScope.USER !== undefined)
            {
                return true;
            }
            if(localStorage.getItem("LoggedUser") !== "" && localStorage.getItem("LoggedUser") !== null)
            {
                return true;
            }
            return false;
        };

        $scope.register = function () {

            alert(document.profilePic.src);
            var json = JSON.stringify({
                "username":$scope.username,
                "email": $scope.email,
                "password": $scope.password,
                "firstName": $scope.firstName,
                "lastName": $scope.lastName,
                "address": $scope.address,
                "picture": document.profilePic.src,
                "phone": $scope.phone,
                "role": "reg_user",
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
        $scope.setPicture = function () {
            var preview = document.profilePic; //selects the query named img
            var file = document.querySelector('input[type=file]').files[0]; //sames as here
            var reader = new FileReader();
            reader.onloadend = function () {
                preview.src = reader.result;
            }

            if (file) {
                reader.readAsDataURL(file);
            } else {
                preview.src = "";
            }
        }

        $scope.login = function () {
            var user = JSON.stringify({
                "username": $scope.username,
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
                        $window.location = '#allSnippets';
                        console.log("logged in");
                    }
                    else {
                        console.log("Not logged in");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("Login not successful, try again! ");
                    //toaster poruka

                }
            });
        };

        $scope.logout = function()
        {
            $rootScope.USER = undefined;
            localStorage.removeItem('LoggedUser');
            $window.location = '#login';
        }

        $scope.loginAsGuest = function()
        {
            var user = JSON.stringify({
                "userName": "guest",
                "password": "guest",
            });
            var url = "/api/login";
            $.ajax({
                type : 'POST',
                url : url,
                contentType : 'application/json',
                dataType : "text",
                data : user,
                success: function (data) {
                    //redirekt
                    if (data !== null) {
                        localStorage.setItem("LoggedUser", data);
                        $rootScope.USER = JSON.parse(data);
                        $window.location = '#allSnippets';
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
        }
    }
]);