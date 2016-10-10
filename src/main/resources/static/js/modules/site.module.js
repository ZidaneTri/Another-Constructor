var heh = angular.module('site', ['ngRoute']);

heh.component('site', {
    templateUrl: '/templates/site.template.html',
    controller: function ($scope,$http,$routeParams) {
        $scope.siteName = $routeParams;
        $http.get('http://localhost:8080/site/'+ siteName +'/pages').success(function (data) {
            $scope.pages = data;
        });
    }});
