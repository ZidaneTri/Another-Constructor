var heh = angular.module('user', ['ngRoute']);

heh.component('user', {
    templateUrl: '/templates/user.template.html',
    controller: function ($scope,$http) {
        $http.get('http://localhost:8080/site/get_user_data').success(function (data) {
            $scope.site = data;
        });
    }});
