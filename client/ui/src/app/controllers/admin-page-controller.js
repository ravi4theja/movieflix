(function() {
    'use strict';

    angular
        .module('mapp')
        .controller('AdminPageController', AdminPageController);

    AdminPageController.$inject = ['movieService', '$location'];

    function AdminPageController(movieService, $location) {
        var adminVm = this;

        adminVm.addMovie = addMovie;
        //adminVm.updateMovie = updateMovie;

        function addMovie() {
            movieService.addMovie(adminVm.newMovie)
                .then(function(data) {
                    console.log("movie added");
                },function(error) {

                })
        }

    }
})();