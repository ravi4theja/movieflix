(function() {
  'use strict';

  angular
    .module('mapp', ['ngRoute', 'ui.bootstrap'])
    .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider', '$httpProvider']
    function moduleConfig($routeProvider, $httpProvider) {

        $httpProvider.interceptors.push('authInterceptor');

        $routeProvider
            .when('/movie-list', {
                templateUrl: 'app/views/movie-list.tmpl.html',
                controller: "MovieListController",
                controllerAs: 'movieListVm'
            })
            .when('/add-user', {
                templateUrl: 'app/views/add-user.tmpl.html',
                controller: "AddUserController",
                controllerAs: "addUserVm"
            })
            .when('/sign-in', {
                templateUrl: 'app/views/sign-in.tmpl.html',
                controller: "SignInController",
                controllerAs: "signInVm"
            })
            .when('/movie-detail/:id', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: "MovieDetailController",
                controllerAs: "movieVm"
            })
            .when('/admin-page', {
                templateUrl:'app/views/admin-page.tmpl.html',
                controller: "AdminPageController",
                controllerAs: "adminVm"
            })
            .otherwise({
                redirectTo: '/movie-list'
            });
    }

})();