angular.
    module('app').
    config(
        function ($httpProvider, $routeProvider) {
            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

            $routeProvider.
                    when('/', {
                          template: '<main></main>'
                    }).
                    when('/userpage', {
                          template: '<user></user>'
                    }).
                    when('/drag', {
                        template: '<drag></drag>'
                    }).
                    when('/create/site/', {
                        template: '<create></create>'
                    }).
                    when('/edit/site/:siteId', {
                        template: '<site></site>'
                    }).
                    when('/add/page/site/:siteId', {
                        template: '<page></page>'
                    }).
                    otherwise('/');
        }
        );