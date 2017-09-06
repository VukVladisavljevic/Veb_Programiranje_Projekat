/**
 * Created by Lupus on 8/17/2017.
 */
angular.module("SnippetApp").controller("CommentController", ['$scope', '$rootScope', '$window','$http',
    function ($scope, $rootScope, $window, $http) {

    $scope.rateUp = function(snippet, comment)
        {
            var comment = JSON.stringify({
                "text": txt,
                "user": $rootScope.USER,
                "snippet": snippet
            });
            var url = "../rs.ftn.jersey.webshop/rest/comment/add";
            $.ajax({
                type : 'POST',
                url : url,
                contentType : 'application/json',
                dataType : "text",
                data : comment,
                success : function(data) {
                    //redirekt
                    if(data=="OK"){
                        $scope.loadData();
                    }
                    else{
                        toastr.info('Could not add comment!');
                    }
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    toastr.info('Could not add comment!');
                }
            });
        };

        $scope.rateDown = function(snippet, comment)
        {
            var comment = JSON.stringify({
                "text": txt,
                "user": $rootScope.USER,
                "snippet": snippet
            });
            var url = "../rs.ftn.jersey.webshop/rest/comment/add";
            $.ajax({
                type : 'POST',
                url : url,
                contentType : 'application/json',
                dataType : "text",
                data : comment,
                success : function(data) {
                    //redirekt
                    if(data=="OK"){
                        $scope.loadData();
                    }
                    else{
                        toastr.info('Could not add comment!');
                    }
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    toastr.info('Could not add comment!');
                }
            });
        };
}]);
