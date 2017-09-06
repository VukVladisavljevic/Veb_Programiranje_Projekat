/**
 * Created by Lupus on 8/15/2017.
 */

angular.module("SnippetApp").controller('SnippetController', ['$scope', '$rootScope', '$window', '$http', '$location',
    function ($scope, $rootScope, $window, $http, $location) {

    $scope.loadSnippets = function () {
        console.log("loading snippets");

        var url = "/api/snippet/getAll";
        $.ajax({
            type: 'GET',
            url : url,
            contentType: 'application/json',
            dataType: 'text',
            success:  function (data) {
                $scope.SNIPPETS = JSON.parse(data);
                $scope.$apply();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                //toaster poruka
                alert('Could not load snippets!');
            }
        });
    };

        $scope.loadLanguages = function () {
            console.log("loading snippets");

            var url = "/api/language/getAll";
            $.ajax({
                type: 'GET',
                url : url,
                contentType: 'application/json',
                dataType: 'text',
                success:  function (data) {
                    $scope.LANGUAGES = JSON.parse(data);
                    $scope.$apply();
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not load snippets!');
                }
            })
        }


    $scope.addSnippet = function () {
        console.log("Adding snippet");
        var snippet = JSON.stringify({
            "description":$scope.description,
            "code":$scope.code,
            "programmingLanguage":$scope.programmingLanguage,
            "repository":$scope.repository,
            "user":$rootScope.USER
        })

        var url = "/api/snippet/create";
        $.ajax({
            type: 'POST',
            url : url,
            contentType: 'application/json',
            dataType: 'text',
            data : snippet,
            success:  function (data) {
                if(data !== null){
                    alert("Uspesno dodat");
                }
                else {
                    alert("ne valja dodavanje snipeta");
                }

            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                //toaster poruka
                alert('Could not add snippet!');
            }
        })
    }

        $scope.deleteSnippet = function (snippetID) {
            console.log("deleting snippet");
            var snippet = JSON.stringify({
                "id":snippetID
            })

            var url = "/api/snippet/delete";
            $.ajax({
                type: 'POST',
                url : url,
                contentType: 'application/json',
                dataType: 'text',
                data : snippet,
                success:  function (data) {
                    if(data !== null){
                        alert("Uspesno izbrisan");

                    }
                    else {
                        alert("ne valja brisanje snipeta");
                    }
                    $scope.$apply();
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not delete snippet!');
                }
            })
        }

        $scope.blockSnippet = function (snippetID) {
            console.log("blocking snippet");
            var snippet = JSON.stringify({
                "id":snippetID
            })

            var url = "/api/snippet/block";
            $.ajax({
                type: 'POST',
                url : url,
                contentType: 'application/json',
                dataType: 'text',
                data : snippet,
                success:  function (data) {
                    if(data !== null){
                        alert("Uspesno blokiran");

                    }
                    else {
                        alert("ne valja blokiranje snipeta");
                    }
                    $scope.$apply();
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not block snippet!');
                }
            })
        }

        $scope.unblockSnippet = function (snippetID) {
            console.log("unblocking snippet");
            var snippet = JSON.stringify({
                "id":snippetID
            })

            var url = "/api/snippet/unblock";
            $.ajax({
                type: 'POST',
                url : url,
                contentType: 'application/json',
                dataType: 'text',
                data : snippet,
                success:  function (data) {
                    if(data !== null){
                        alert("Uspesno unblokiran");

                    }
                    else {
                        alert("ne valja unblokiranje snipeta");
                    }
                    $scope.$apply();
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not delete snippet!');
                }
            })
        }

        $scope.snippetDetails = function (snippetID) {
            for(var i = 0; i < $scope.SNIPPETS.length; i++){
                if(snippetID === $scope.SNIPPETS[i].id){
                    $rootScope.currentSnippet = $scope.SNIPPETS[i];
                }
            }
            $location.path('/snippetDetails');
        }

        $scope.loadDetailedSnippet = function () {

        }

        $scope.commentSnippet = function(txt)
        {
            var comment = JSON.stringify({
                "text": txt,
                "user": $rootScope.USER,
                "snippet": $rootScope.currentSnippet
            });
            var url = "/api/snippet/comment/add";
            $.ajax({
                type : 'POST',
                url : url,
                contentType : 'application/json',
                dataType : "text",
                data : comment,
                success : function(data) {
                    //redirekt
                    if(data !== null){
                        alert("OK");
                    }
                    else{
                       alert("NIJE");
                    }
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert("GRESKA");
                }
            });
        };

        $scope.gradeComment = function(comment)
        {
            alert(comment.text);
            $scope.grade = 1;
            var gradeData = JSON.stringify({
                "comment": comment,
                "user": $rootScope.USER,
                "snippet": $rootScope.currentSnippet,
                "grade": $scope.grade
            });
            var url = "api/snippet/comment/rate";
            $.ajax({
                type : 'POST',
                url : url,
                contentType : 'application/json',
                dataType : "text",
                data : gradeData,
                success : function(data) {
                    //redirekt
                    alert("PROSLO");
                    //$scope.loadData();
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {

                }
            });
        }
}]);