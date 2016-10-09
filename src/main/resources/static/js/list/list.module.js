angular.module('main')
    .component('site', {
        templateUrl: '/templates/site.template.html',
        controller: function ($scope,$http,$location) {
            $scope.site = [];

            $http.get('http://localhost:8080/site/get_all').success(function (data) {
                $scope.site = data;
            });
        }
    });