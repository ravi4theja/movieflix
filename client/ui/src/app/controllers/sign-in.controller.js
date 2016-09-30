(function(){
    'use strict';

    angular.module('mapp')
        .controller('SignInController', SignInController);


    SignInController.$inject = ['userService', 'authService', '$location'];

    function SignInController(userService, authService, $location) {
        var signInVm = this;

        signInVm.logIn = logIn;
        signInVm.isAuthed = isAuthed;
        signInVm.logOut = logOut;
        signInVm.getUserName = getUserName;
        signInVm.getAdminStatus = getAdminStatus;

        function handleRequest(logInResponse) {
            var token = logInResponse ? logInResponse.token : null;
            if(token) {
                console.log('JWT:', token);
                console.log(authService.parseJwt(token));
                $location.path('/movie-list');
            }
        }

        function logIn() {
            userService.logIn(signInVm.logInObj)
                .then(handleRequest, handleRequest);
        }

        function logOut() {
            authService.logOut();
        }

        function isAuthed() {
            return authService.isAuthed();
        }

        function getUserName() {
            return authService.getUserName();
        }

        function getAdminStatus() {
            return authService.getAdminStatus();
        }
    }
})();