var heh = angular.module('user', []);

heh.component('siteList', {
    templateUrl: '/templates/site.template.html',
    controller: function ($scope, $http, $location) {
        $scope.user = [];
        $scope.site = [];
        // $http.get('http://localhost:8080/user/info/' + window.location.search.slice(4)).success(function (data) {
        //     $scope.user = data;
        // });
        $http.get('http://localhost:8080/site/info/' + window.location.search.slice(4)).success(function (data) {
            $scope.site = data;
        });
    }
});

