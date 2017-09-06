/**
 * Created by Lupus on 8/15/2017.
 */

angular.module("SnippetApp").controller('LanguageController', ['$scope', '$rootScope', '$window', '$http', '$location',
    function ($scope, $rootScope, $window, $http, $location) {

        $scope.loadLanguages = function () {
            console.log("loading snippets");

            var url = "/api/language/getAll";
            $.ajax({
                type: 'GET',
                url : url,
                contentType: 'application/json',
                dataType: 'text',
                success:  function (data) {
                    alert(JSON.stringify(data));
                    $scope.LANGUAGES = JSON.parse(data);
                    $scope.$apply();
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not load snippets!');
                }
            })
        }


        $scope.addLanguage = function () {
            console.log("Adding language");
            var language = JSON.stringify({
                "languageName":$scope.langName,
            })

            var url = "/api/language/create";
            $.ajax({
                type: 'POST',
                url : url,
                contentType: 'application/json',
                dataType: 'text',
                data : language,
                success:  function (data) {
                    if(data){
                        alert("Uspesno dodat");
                    }
                    else {
                        alert("ne valja dodavanje jezika");
                    }

                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not add jezika!');
                }
            })
        }
    }]);