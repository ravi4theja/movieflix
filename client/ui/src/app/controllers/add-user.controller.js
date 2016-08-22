(function() {
    'use strict';

    angular
        .module('mapp')
        .controller('AddUserController', AddUserController);

    AddUserController.$inject = ['userService', '$location'];

    function AddUserController(userService, $location) {
        var addUserVm = this;

        addUserVm.addUser = addUser;

        init();

        function init() {
            console.log('in AddUserController');
        }

        function addUser() {
            userService
                .createUser(addUserVm.newUser)
                .then(function(data) {
                    $location.path('/movie-list');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();