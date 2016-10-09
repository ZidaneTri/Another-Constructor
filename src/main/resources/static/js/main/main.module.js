var heh = angular.module('main', []);

heh.component('main', {
    templateUrl: '/templates/main.template.html',
    controller: function ($http, $scope) {

        var samplejson = {
            "kek": null,
            "number": null,
            "string": "Hello World"
        };

        $scope.logout = function() {
            $http.post('/data', samplejson).success(function() {
                console.log("RECIEVED")
            }).error(function(data) {
                console.log("fail")
            });
        };

    }

    });