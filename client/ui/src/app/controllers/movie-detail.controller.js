(function(){
    'use strict';

    angular.module('mapp')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['authService', 'commentService', 'ratingService', 'userService', '$uibModalInstance', 'movie'];

    function MovieDetailController(authService, commentService, ratingService, userService, $uibModalInstance, movie) {
        var movieVm = this;

        movieVm.movie = movie;
        movieVm.getUser = getUser;

        //comment section declarations
        movieVm.addComment = addComment;
        movieVm.getComments = getComments;
        movieVm.comment = new Object();

        //rating section declarations
        movieVm.ratingSum = 0;
        movieVm.yourRating = 0;
        movieVm.maxRating = 10;
        movieVm.updateRating = true;
        movieVm.hoveringOver = hoveringOver;
        movieVm.getRatings = getRatings;
        movieVm.getRatingByUser = getRatingByUser;
        movieVm.addRating = addRating;
        movieVm.rating = new Object();
        //Declarations ended

        //Initializing the modal
        movieVm.isAuthed = authService.isAuthed();

        movieVm.getComments();
        movieVm.getRatings();
        if(movieVm.isAuthed) {
            console.log("getting user");
            movieVm.getUser();
        }

        //Modal init functions
        function getComments() {
            commentService.getCommentsByMovie(movieVm.movie.id)
                .then(function(data) {
                    movieVm.comments = data;
                })
                .catch(function(error) {
                    console.log(error);
                });
        }

        function getRatings() {
            ratingService.getRatingsByMovie(movieVm.movie.id)
                .then(function(data) {
                    movieVm.ratings = data;
                    console.log(movieVm.ratings);
                    movieVm.ratings.forEach(function(rating) {
                        movieVm.ratingSum += rating.rating;
                    });
                    console.log(movieVm.ratingSum);
                    if(movieVm.ratings.length == 0) {           //checking if no ratings
                        movieVm.overAllRating = "No Ratings";
                        console.log(movieVm.overAllRating);
                    }
                    else {
                        movieVm.overAllRating = movieVm.ratingSum / movieVm.ratings.length;
                        console.log(movieVm.overAllRating);
                        movieVm.ratingSum = 0;
                    }
                })
                .catch(function(error) {
                    movieVm.overAllRating = 0;
                    console.log("No ratings yet for the movie");
                });
        }

        function getRatingByUser() {
            ratingService.getRatingForMovieByUser(movieVm.movie.id, movieVm.userId)
                .then(function(data) {
                    console.log(data.rating);
                    movieVm.yourRating = data.rating;
                    movieVm.rating.id = data.id;
                    movieVm.updateRating = true;
                })
                .catch(function(error) {
                    movieVm.updateRating = false;           //If the user hasn't rated this movie
                    console.log("you haven't rated this movie yet");
                });
        }

        //getting the user if logged in
        function getUser() {
            movieVm.userId =  authService.getUserId();
            console.log(movieVm.userId);
            userService.getUserById(movieVm.userId)
                .then(function(data) {
                    movieVm.comment.user = data;
                    movieVm.rating.user = data;
                    console.log(movieVm.rating.user);
                    if(movieVm.updateRating) {
                        movieVm.getRatingByUser();
                    }
                })
                .catch(function(error) {
                    console.log("You need to first log in");
                });
        }

        //adding comment
        function addComment(commentInput) {
            movieVm.comment.comment = commentInput;
            //movieVm.comment.user = movieVm.getUser();

            movieVm.comment.movie = movieVm.movie;
            console.log(movieVm.comment.user);
            if(movieVm.isAuthed) {
                commentService.addComment(movieVm.comment)
                    .then(function(data) {
                        movieVm.getComments();
                    })
                    .catch(function(error) {
                        console.log(error);
                    });
            }

        }

        //rating

        function hoveringOver(value) {
            movieVm.overStar = value;
        }

        function addRating(yourRating) {
            movieVm.rating.rating = yourRating;
            movieVm.rating.movie = movieVm.movie;
            if(movieVm.updateRating) {
                ratingService.updateRatingForMovie(movieVm.rating.id, movieVm.rating)
                    .then(function(data) {
                        console.log("In update rating");
                        console.log(data);
                        movieVm.getRatings();
                        movieVm.getRatingByUser();
                    })
                    .catch(function(error) {
                        console.log(error);
                    });
            }
            else {
                ratingService.addRatingForMovie(movieVm.rating)
                    .then(function(data) {
                        console.log("In add rating");
                        console.log(data);
                        movieVm.updateRating = true;
                        movieVm.getRatings();
                        movieVm.getRatingByUser();
                    })
                    .catch(function(error) {
                        console.log(error);
                    });
            }

        }

        movieVm.ok = ok;
        function ok() {
            $uibModalInstance.close("successfully closed");
        };

    }
})();