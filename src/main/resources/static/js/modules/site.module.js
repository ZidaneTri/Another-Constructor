var heh = angular.module('site', []);

heh.component('site', {
    templateUrl: '/templates/site.template.html',
    controller: function ($scope,$http,$routeParams) {
        siteid = $routeParams.siteId;

        $http.get('/site/info/'+siteid).success(function (data) {

            $scope.name = data.siteName;
        });
        $http.get('/site/pages/'+siteid).success(function (data) {
            console.log(data);
            $scope.pages = data;
        });


    }});
