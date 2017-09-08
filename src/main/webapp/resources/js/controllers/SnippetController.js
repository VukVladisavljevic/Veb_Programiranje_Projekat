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
                url: url,
                contentType: 'application/json',
                dataType: 'text',
                success: function (data) {
                    $scope.SNIPPETS = JSON.parse(data);
                    $scope.loadLanguages();
                    $scope.$apply();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not load snippets!');
                }
            });
        };

        $scope.reloadSnippet = function () {
            var url = "/api/snippet/getAll";
            $.ajax({
                type: 'GET',
                url: url,
                contentType: 'application/json',
                dataType: 'text',
                success: function (data) {
                    $scope.SNIPPETS = JSON.parse(data);
                    for (var i = 0; i < $scope.SNIPPETS.length; i++) {
                        if ($scope.currentSnippet.id === $scope.SNIPPETS[i].id) {
                            $rootScope.currentSnippet = $scope.SNIPPETS[i];
                        }
                    }
                    $scope.$apply();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not load snippets!');
                }
            });
        }

        $scope.loadLanguages = function () {
            console.log("loading snippets");

            var url = "/api/language/getAll";
            $.ajax({
                type: 'GET',
                url: url,
                contentType: 'application/json',
                dataType: 'text',
                success: function (data) {
                    $scope.LANGUAGES = JSON.parse(data);
                    $scope.$apply();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not load snippets!');
                }
            })
        }

        $scope.ableToBlock = function () {
            return ($rootScope.currentSnippet.blocked === false && $rootScope.USER.role === "admin");
        }

        $scope.ableToUnblock = function () {
            return ($rootScope.currentSnippet.blocked === true && $rootScope.USER.role === "admin");
        }

        $scope.ableToDelete = function () {
            if ($rootScope.currentSnippet.user.username === $rootScope.USER.username || $rootScope.USER.role === "admin") {
                return true;
            } else {
                return false;
            }
        }

        $scope.ableToComment = function () {
            if ($rootScope.currentSnippet.blocked === false) {
                return true;
            } else {
                return false;
            }
        }

        $scope.ableToRate = function (comment) {
            {
                if($rootScope.isGuest())
                {
                    return false;
                }
                for(var i = 0; i < comment.grade.users.length; i++)
                {

                    if(strcmp(comment.grade.users[i].userName, $rootScope.USER.userName) == 0)
                    {
                        return false;
                    }
                }
                return true;
            };
        }

        $scope.addSnippet = function () {
            console.log("Adding snippet");
            var snippet = JSON.stringify({
                "description": $scope.description,
                "code": $scope.code,
                "programmingLanguage": $scope.programmingLanguage,
                "repository": $scope.repository,
                "user": $rootScope.USER
            })

            var url = "/api/snippet/create";
            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: 'text',
                data: snippet,
                success: function (data) {
                    if (data !== null) {
                        alert("DODAT");
                        $rootScope.currentSnippet = JSON.parse(data);

                    }
                    else {
                        alert("ne valja dodavanje snipeta");
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not add snippet!');
                }
            })
        }

        $scope.deleteSnippet = function () {
            console.log("deleting snippet");
            var snippet = JSON.stringify({
                "id": $rootScope.currentSnippet.id
            })

            var url = "/api/snippet/delete";
            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: 'text',
                data: snippet,
                success: function (data) {
                    if (data !== null) {
                        alert("Uspesno izbrisan");
                        $location.path('/allSnippets');

                    }
                    else {
                        alert("ne valja brisanje snipeta");
                    }
                    $scope.$apply();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not delete snippet!');
                }
            })
        }

        $scope.blockSnippet = function () {
            console.log("blocking snippet");
            var snippet = JSON.stringify({
                "id": $rootScope.currentSnippet.id
            })

            var url = "/api/snippet/block";
            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: 'text',
                data: snippet,
                success: function (data) {
                    if (data !== null) {
                        $scope.reloadSnippet();;

                    }
                    else {
                        alert("ne valja blokiranje snipeta");
                    }
                    $scope.$apply();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not block snippet!');
                }
            })
        }

        $scope.unblockSnippet = function () {
            console.log("unblocking snippet");
            var snippet = JSON.stringify({
                "id": $rootScope.currentSnippet.id
            })

            var url = "/api/snippet/unblock";
            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: 'text',
                data: snippet,
                success: function (data) {
                    if (data !== null) {
                        $scope.reloadSnippet();

                    }
                    else {
                        alert("ne valja unblokiranje snipeta");
                    }
                    $scope.$apply();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not delete snippet!');
                }
            })
        }

        $scope.snippetDetails = function (snippetID) {
            for (var i = 0; i < $scope.SNIPPETS.length; i++) {
                if (snippetID === $scope.SNIPPETS[i].id) {
                    $rootScope.currentSnippet = $scope.SNIPPETS[i];
                }
            }
            $location.path('/snippetDetails');

        }

        $scope.loadDetailedSnippet = function () {

        }

        $scope.commentSnippet = function (txt) {
            var comment = JSON.stringify({
                "text": txt,
                "user": $rootScope.USER,
                "snippet": $rootScope.currentSnippet
            });
            var url = "/api/snippet/comment/add";
            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: "text",
                data: comment,
                success: function (data) {
                    //redirekt
                    if (data !== null) {
                        $scope.reloadSnippet();
                    }
                    else {
                        alert("NIJE");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert("GRESKA");
                }
            });
        };

        $scope.rateUp = function (comment) {
            $scope.rating = "+";
            $scope.gradeComment(comment);
        }

        $scope.rateDown = function (comment) {
            $scope.rating = "-";
            $scope.gradeComment(comment);
        }


        $scope.gradeComment = function (comment) {

            if($scope.rating === "+"){
                $scope.grade = 1;
            } else if($scope.rating === "-") {
                $scope.grade = -1;
            } else {
                return;
            }
            alert($scope.grade);
            var gradeData = JSON.stringify({
                "comment": comment,
                "user": $rootScope.USER,
                "snippet": $rootScope.currentSnippet,
                "grade": $scope.grade
            });
            var url = "api/snippet/comment/rate";
            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: "text",
                data: gradeData,
                success: function (data) {
                    //redirekt
                    alert("PR");
                   // $scope.reloadSnippet();
                    //$scope.loadData();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {

                }
            });
        }

        $scope.filterByDescription = function () {
            var filteredList = [];
            if ($scope.searchDescription !== undefined || $scope.searchDescription !== "") {
                var url = "/api/snippet/getAll";
                $.ajax({
                    type: 'GET',
                    url: url,
                    contentType: 'application/json',
                    dataType: "text",
                    success: function (data) {
                        $scope.SNIPPETS = JSON.parse(data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    }
                });

                for (var i = 0; i < $scope.SNIPPETS.length; i++) {
                    if ($scope.SNIPPETS[i].description.includes($scope.searchDescription)) {
                        filteredList.push($scope.SNIPPETS[i]);
                    }
                }
                $scope.SNIPPETS = filteredList;
            }
        }

        $scope.filterByDate = function () {
            var filteredList = [];
            if ($scope.dateFilter !== undefined || $scope.dateFilter !== "") {
                var url = "/api/snippet/getAll";
                $.ajax({
                    type: 'GET',
                    url: url,
                    contentType: 'application/json',
                    dataType: "text",
                    success: function (data) {
                        $scope.SNIPPETS = JSON.parse(data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    }
                });

                for (var i = 0; i < $scope.SNIPPETS.length; i++) {
                    var snippetDate = new Date($scope.SNIPPETS[i].time);
                    if (snippetDate.getFullYear() === $scope.dateFilter.getFullYear() &&
                        snippetDate.getDate() === $scope.dateFilter.getDate() &&
                        snippetDate.getMonth() === $scope.dateFilter.getMonth()) {
                        result.push($scope.SNIPPETS[i]);
                    }
                }
                $scope.SNIPPETS = filteredList;
            }
        }

        $scope.filterByLanguage = function () {
            var filteredList = [];
            if ($scope.languageFilter !== undefined || $scope.languageFilter !== "") {
                var url = "/api/snippet/getAll";
                $.ajax({
                    type: 'GET',
                    url: url,
                    contentType: 'application/json',
                    dataType: "text",
                    success: function (data) {
                        $scope.SNIPPETS = JSON.parse(data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    }
                });

                for (var i = 0; i < $scope.SNIPPETS.length; i++) {
                    if ($scope.SNIPPETS[i].language === $scope.languageFilter) {
                        filteredList.push($scope.SNIPPETS[i]);
                    }
                }
                $scope.SNIPPETS = filteredList;
            }
        }
    }]);