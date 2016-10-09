angular.module('user')
    .component('site', {
    templateUrl: '/templates/site.template.html',
    controller: function ($scope) {
        $scope.user = [];
        $scope.sitee = [
            {   sitee_name: 'blabla'}
            ,{  sitee_name: 'adasda'}
            ,{  sitee_name: 'dasdada'}
        ];
        //$scope.site = [];
        // $http.get('http://localhost:8080/user/info/' + window.location.search.slice(4)).success(function (data) {
        //     $scope.user = data;
        // });
        //$http.get('http://localhost:8080/site/info/' + window.location.search.slice(4)).success(function (data){
        // $http.get('siteList').success(function (data){
         //    $scope.site = data;
         //});
    }
});


