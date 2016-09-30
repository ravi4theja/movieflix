package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Rating;

public interface RatingRepository {

	public List<Rating> findRatingsByMovie(String movieId);
	
	public Rating findRatingForMovieByUser(String movieId, String userId);
	
	public Rating findRating(String ratingId);
	
	public Rating addRating(Rating rating);
	
	public Rating updateRating(Rating rating);
	
	public void deleteRating(Rating rating);
}
