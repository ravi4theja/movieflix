(function() {
    'use strict';

    angular
        .module('mapp')
        .service('commentService', commentService);

    commentService.$inject = ['$http', '$q', 'CONFIG'];

    function commentService($http, $q, CONFIG) {
        var self = this;

        self.getCommentsByMovie = getCommentsByMovie;
        self.getCommentsByUser = getCommentsByUser;
        self.addComment = addComment;

        function getCommentsByMovie(movieId) {
            return $http.get(CONFIG.API_HOST + '/comments/movie/' + movieId)
                .then(successFn, errorFn);
        }

        function getCommentsByUser(userId) {
            return $http.get(CONFIG.API_HOST + '/comments/user/' + userId)
                .then(successFn, errorFn);
        }

        function addComment(comment) {
            return $http.post(CONFIG.API_HOST + '/comments/add', comment)
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