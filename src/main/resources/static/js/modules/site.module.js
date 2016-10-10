var heh = angular.module('site', []);

heh.component('site', {
    templateUrl: '/templates/site.template.html',
    controller: function ($scope,$http,$routeParams,$window) {
        siteid = $routeParams.siteId;

        $http.get('/site/info/'+siteid).success(function (data) {
            if(data=null){
                $scope.name = data.siteName;
                $http.get('/site/pages/'+siteid).success(function (data) {
                    console.log(data);
                    $scope.pages = data;
                });
            }else {
                alert("NOT YOUR SITE");
                $window.location.href = '#/userpage'

            }


        });

        $scope.removeItem = function removeItem(row) {
            var index = $scope.pages.indexOf(row);
            var id = $scope.pages[index].id;
            $http.get('/site/page/'+id+'/delete').success(function () {
                if (index !== -1) {
                    console.log("all good")
                    $scope.pages.splice(index, 1);
                }
            });
        }
    }});
