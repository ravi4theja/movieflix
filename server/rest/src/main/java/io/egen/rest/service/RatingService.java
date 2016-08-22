package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Rating;

public interface RatingService {
	
	public List<Rating> findRatingsByMovie(String movieId);
	
	public Rating findRatingForMovieByUser(String movieId, String userId);
	
	public Rating findRating(String ratingId) ;
	
	public Rating addRating(Rating rating);
	
	public Rating updateRating(Rating rating, String ratingId);
	
	public void deleteRating(String ratingId);
	
}
