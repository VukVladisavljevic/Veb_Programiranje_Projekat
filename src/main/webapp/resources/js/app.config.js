angular.module("SnippetApp").config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/resources/js/views/home.html',
        controller: 'MainController'
    }).when('/register', {
        templateUrl: '/resources/js/views/register.html',
        controller: 'MainController'
    }).when('/login', {
        templateUrl: '/resources/js/views/login.html',
        controller: 'MainController'
    }).otherwise({
        redirectTo: '/'
    });
});