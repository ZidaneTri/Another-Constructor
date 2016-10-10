var heh = angular.module('create', []);

heh.component('create', {
    templateUrl: '/templates/create.template.html',
    controller: function ($http, $scope, $routeParams) {

        $scope.name = null;

        $scope.submit = function() {
            $http.post('/site/save',angular.toJson(name)).success(function() {
                console.log("Win");
            }).error(function() {
                console.log("Fail");
            });
        };
    }
});