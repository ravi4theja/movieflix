(function() {
    'use strict';

    angular
        .module('mapp')
        .service('authService', authService);

    authService.$inject = ['$window'];

    function authService($window) {
        var self = this;
        self.getUserId = getUserId;
        self.saveToken = saveToken;
        self.getToken = getToken;
        self.parseJwt = parseJwt;
        self.isAuthed = isAuthed;
        self.logOut = logOut;
        self.getUserName = getUserName;
        self.getAdminStatus = getAdminStatus;

        function saveToken(token) {
            $window.localStorage['jwtToken'] = token;
        }

        function getToken() {
            return $window.localStorage['jwtToken'];
        }

        function parseJwt(token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace('-', '+').replace('_', '/');
            return JSON.parse($window.atob(base64));
        }

        function isAuthed() {
            var token = self.getToken();
            if(token) {
                return true;
                // var params = self.parseJwt(token);
                // return Math.round(new Date().getTime() / 1000) <= params.exp;
            } else {
                return false;
            }
        }

        function getUserName() {
            var token = self.getToken();
            if(token) {
                var claimObj = self.parseJwt(token);
                return claimObj.name;
            }
        }

        function getAdminStatus() {
            var token = self.getToken();
            if(token) {
                var claimObj = self.parseJwt(token);
                if(claimObj.role == "admin") {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        function getUserId() {
            var token = self.getToken();
            if(token) {
                var claimObj = self.parseJwt(token);
                return claimObj.sub;
            }
        }

        function logOut() {
            $window.localStorage.removeItem('jwtToken');
        }
    }
})();