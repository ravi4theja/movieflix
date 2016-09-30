(function() {
    'use strict';


    angular
        .module('mapp')
        .factory('authInterceptor', authInterceptor);

    authInterceptor.$inject = ['authService']

    function authInterceptor(authService) {
        return {
            request: function(req) {
                var token = authService.getToken();
                if(token) {
                    req.headers.Authorization = 'Bearer ' + token;
                }
                return req;
            },

            response: function(res) {
                var logInResponse = res.data;
                if(logInResponse.token) {
                    authService.saveToken(logInResponse.token);
                }
                return res;
            }
        }
    };

})();