/**
 * Created by Lupus on 8/13/2017.
 */

angular.module("SnippetApp").controller('MainController', ['$rootScope', '$http', '$scope',
    function ($rootScope, $http, $scope) {

        $scope.register = function () {

            var json = JSON.stringify({
                "email": $scope.email,
                "password": $scope.password,
                "firstName": $scope.firstName,
                "lastName": $scope.lastName,
                "address": $scope.address,
                "picture": $scope.picture,
                "phone": $scope.phone,
                "role": "Neka uloga",
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
    }

]);