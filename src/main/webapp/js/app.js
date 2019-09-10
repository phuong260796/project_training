var myApp = angular.module('helloworld', ['ui.router']);

myApp.config(function($stateProvider) {
    var helloState = {
        name: 'hello',
        url: '/hello',
        templateUrl: ''
    };

    var aboutState = {
        name: 'about',
        url: '/about',
        templateUrl: ''
    }

});