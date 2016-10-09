var heh = angular.module('user', []);

heh.component('site', {
    templateUrl: '/templates/site.template.html',
    controller: function () {
        $scope.user = [];
        $scope.site = [
            {
                site_name: "blabla"
            }
        ];
        // $http.get('http://localhost:8080/user/info/' + window.location.search.slice(4)).success(function (data) {
        //     $scope.user = data;
        // });
        //$http.get('http://localhost:8080/site/info/' + window.location.search.slice(4)).success(function (data)
        // $http.get('siteList').success(function (data){
        //     $scope.site = data;
        // });
    }
});


