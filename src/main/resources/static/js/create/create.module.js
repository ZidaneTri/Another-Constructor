var heh = angular.module('create', []);

heh.component('create', {
    templateUrl: '/templates/create.template.html',
    controller: function ($http, $scope, $routeParams) {
        $scope.params = $routeParams;
    }
});