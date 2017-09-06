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
    }).when('/allUsers', {
        templateUrl: '/resources/js/views/allUsers.html',
        controller: 'UserController'
    }).when('/addSnippet', {
        templateUrl: '/resources/js/views/addSnippet.html',
        controller: 'SnippetController'
    }).when('/allSnippets', {
        templateUrl: '/resources/js/views/allSnippets.html',
        controller: 'SnippetController'
    }).when('/addLanguage', {
        templateUrl: '/resources/js/views/addLanguages.html',
        controller: 'LanguageController'
    }).when('/allLanguages', {
        templateUrl: '/resources/js/views/allLanguages.html',
        controller: 'LanguageController'
    }).when('/snippetDetails', {
        templateUrl: '/resources/js/views/snippetDetails.html',
        controller: 'SnippetController'
    }).when('/profile', {
        templateUrl: '/resources/js/views/profile.html',
        controller: 'UserController'
    }).otherwise({
        redirectTo: '/'
    });
});