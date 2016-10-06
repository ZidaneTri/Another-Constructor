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
                    otherwise('/');
        }
        );