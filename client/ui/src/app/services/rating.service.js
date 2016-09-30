(function() {
    'use strict';

    angular
        .module('mapp')
        .service('ratingService', ratingService);

    ratingService.$inject = ['$http', '$q', 'CONFIG'];

    function ratingService($http, $q, CONFIG) {
        var self = this;

        self.getRatingsByMovie = getRatingsByMovie;
        self.getRatingForMovieByUser = getRatingForMovieByUser;
        self.addRatingForMovie = addRatingForMovie;
        self.updateRatingForMovie = updateRatingForMovie;

        function getRatingsByMovie(movieId) {
            return $http.get(CONFIG.API_HOST + '/ratings/' + movieId)
                .then(successFn, errorFn);
        }

        function getRatingForMovieByUser(movieId, userId) {
            return $http.get(CONFIG.API_HOST + '/ratings/' + movieId +'/'+ userId)
                .then(successFn, errorFn);
        }

        function addRatingForMovie(rating) {
            return $http.post(CONFIG.API_HOST + '/ratings/add', rating)
                .then(successFn, errorFn);
        }

        function updateRatingForMovie(ratingId, rating) {
            return $http.put(CONFIG.API_HOST + '/ratings/' + ratingId, rating)
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