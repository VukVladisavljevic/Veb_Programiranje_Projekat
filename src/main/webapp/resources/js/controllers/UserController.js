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
                        $scope.$apply();
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                    }
                });
            };
            
            $scope.ableToBlock = function (user) {
                if($rootScope.USER.role === "admin" && user.role !== "admin" && user.blocked === false){
                    return true;
                } else {
                    return false;
                }
            }

            $scope.ableToUnblock = function (user) {
                if($rootScope.USER.role === "admin" && user.role !== "admin" && user.blocked === true){
                    return true;
                } else {
                    return false;
                }
            }

            $scope.block = function(user)
            {
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
                        $scope.loadUsers();

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
                        $scope.loadUsers();

                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                        //toaster poruka

                    }
                });
            }

            $scope.filterUsers = function() {
                var filteredList = [];

                if($scope.searchText === undefined || $scope.searchText === ""){
                    return;
                }
                var url = "/api/users/getAll";
                $.ajax({
                    type : 'GET',
                    url : url,
                    contentType : 'application/json',
                    dataType : "text",
                    success : function(data) {
                        $scope.USERS = JSON.parse(data);
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                    }
                });

                for(var i = 0; i < $scope.USERS.length; i++){
                    if($scope.USERS[i].username.includes($scope.searchText)){
                        filteredList.push($scope.USERS[i]);
                    }
                }
                $scope.USERS = filteredList;
            }
        }]);