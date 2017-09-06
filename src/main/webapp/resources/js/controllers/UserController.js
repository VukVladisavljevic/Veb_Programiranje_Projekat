/**
 * Created by Lupus on 8/17/2017.
 */
angular.module("SnippetApp")
    .controller('UserController', ['$scope', '$rootScope', '$window','$http',
        function ($scope, $rootScope, $window, $http) {

            $scope.loadUsers = function()
            {
                var url = "/api/users/getAll";
                $.ajax({
                    type : 'GET',
                    url : url,
                    contentType : 'application/json',
                    dataType : "text",
                    success : function(data) {
                        $scope.USERS = JSON.parse(data);
                        if(!$scope.$$phase) {
                            $scope.$apply();
                        }
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                    }
                });
            };

            $scope.block = function(user)
            {
                alert("blokiranje");
                var userData = JSON.stringify({
                    "username": user.username
                });
                var url = "api/users/block";
                $.ajax({
                    type : 'POST',
                    url : url,
                    contentType : 'application/json',
                    dataType : "text",
                    data : userData,
                    success : function(data) {
                        console.log("blokiran");
                        //$scope.loadData();
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                        //toaster poruka

                    }
                });
            }

            $scope.unblock = function(user)
            {
                var userData = JSON.stringify({
                    "username": user.username
                });
                var url = "api/users/unblock";
                $.ajax({
                    type : 'POST',
                    url : url,
                    contentType : 'application/json',
                    dataType : "text",
                    data : userData,
                    success : function(data) {
                        console.log("odblokiran");
                        //$scope.loadData();
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                        //toaster poruka

                    }
                });
            }
        }]);