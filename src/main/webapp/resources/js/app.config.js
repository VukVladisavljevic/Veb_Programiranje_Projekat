angular.module("SnippetApp").config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/resources/js/views/home.html',
        controller: 'MainController'
    }).when('/register', {
        templateUrl: '/resources/js/views/register.html',
        controller: 'MainController'
    }).otherwise({
        redirectTo: '/'
    });
});