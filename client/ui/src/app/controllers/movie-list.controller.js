(function() {
    'use strict';

    angular.module('mapp')
        .controller('MovieListController', MovieListController);

    MovieListController.$inject = ['movieService', '$uibModal'];

    function MovieListController(movieService, $uibModal) {
        var movieListVm = this;

        init();
        movieListVm.openMovieModal = openMovieModal;
        movieListVm.getMovie = getMovie;

        function init() {
            console.log('in MovieListController');

            movieListVm.sorter = {
                sortBy: 'Year',
                sortOrder: false
            };

            movieService.getMovies()
                .then(function(data) {
                    movieListVm.movies = data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        }

        movieListVm.filterValue = "";

        function getMovie(id) {
            movieService
                .getMovie(id)
                .then(function(data) {
                    console.log("got the movie");
                    movieListVm.movie = data;
                    movieListVm.openMovieModal();
                }, function(error) {
                    console.log(error);
                });
        }

        function openMovieModal() {

            var movieModal = $uibModal.open({
                animation: true,
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieVm',
                size: 'lg',
                resolve: {
                    movie: function(){
                        return movieListVm.movie;
                    }
                }
            });

            movieModal.result.then(function(logString) {
                console.log(logString);
            });
        }

    }
})();