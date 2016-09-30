(function() {
    'use strict';

    angular
        .module('mapp')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q', 'CONFIG'];

    function movieService($http, $q, CONFIG) {
        var self = this;

        self.getMovies = getMovies;
        self.getMovie = getMovie;
        self.addMovie = addMovie;

        function getMovies() {
            return $http.get(CONFIG.API_HOST + '/movies')
                .then(successFn, errorFn);
        }

        function getMovie(id) {
            return $http.get(CONFIG.API_HOST + '/movies/' + id)
                .then(successFn, errorFn);
        }

        function addMovie(movie) {
            return $http.post(CONFIG.API_HOST + '/movies', movie)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data; //RESOLVE
        }

        function errorFn(response) {
            return $q.reject(error.status); //REJECT
        }
    }
})();