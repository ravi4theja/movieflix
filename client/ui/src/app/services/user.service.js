(function() {
    'use strict';

    angular.module('mapp')
        .service('userService', userService);

    userService.$inject = ['$http', '$q', 'CONFIG'];

    function userService($http, $q, CONFIG) {

        var self = this;

        self.getUserById = getUserById;
        self.createUser = createUser;
        self.logIn = logIn;

        function createUser(user) {
            return $http.post(CONFIG.API_HOST + '/users/', user)
                .then(successFn, errorFn);
        }

        function getUserById(id) {
            return $http.get(CONFIG.API_HOST + '/users/' + id)
                .then(successFn, errorFn);
        }

        function logIn(logInObj) {
            return $http.post(CONFIG.API_HOST + '/users/login', logInObj)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject(error.status);
        }


    }

})();