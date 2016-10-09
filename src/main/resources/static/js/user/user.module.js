var heh = angular.module('user', ['ngRoute']);

heh.component('user', {
    templateUrl: '/templates/user.template.html',
    controller: function ($http, $scope) {
        $http.get("/userdata").success(function(data) {
            console.log(data);
        });
    }
});
