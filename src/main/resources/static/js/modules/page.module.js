var heh = angular.module('page', []);

heh.component('page', {
    templateUrl: '/templates/page.template.html',
    controller: function ($http, $scope, $window) {

        $scope.name = null;

        $scope.submit = function() {
            console.log($scope.name);
            $http.post('/site/save',$scope.name).success(function() {
                $window.location.href = '#/userpage';
            }).error(function() {
                console.log("Fail");
            });
        };
    }

});