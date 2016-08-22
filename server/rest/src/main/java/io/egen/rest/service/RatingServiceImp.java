package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Rating;
import io.egen.rest.exception.RatingNotFoundException;
import io.egen.rest.repository.MovieRepository;
import io.egen.rest.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {

	
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Rating> findRatingsByMovie(String movieId) {
		return ratingRepository.findRatingsByMovie(movieId);
	}
	
	public Rating findRatingForMovieByUser(String movieId, String userId) {
		return ratingRepository.findRatingForMovieByUser(movieId, userId);
	}
	
	@Override
	public Rating findRating(String ratingId) {
		Rating existing = ratingRepository.findRating(ratingId);
		if(existing == null)
			throw new RatingNotFoundException("Rating with id:" + ratingId);
		return existing;
	}
	
	@Override
	@Transactional
	public Rating addRating(Rating rating) {
		
			return ratingRepository.addRating(rating);
	}
	
	@Override
	@Transactional
	public Rating updateRating(Rating rating, String ratingId) {
			Rating existing = ratingRepository.findRating(ratingId);
			if(existing == null)
				throw new RatingNotFoundException("Rating with id:" + ratingId + " not found");
			else
				return ratingRepository.updateRating(rating);
	}
	
	@Override
	@Transactional
	public void deleteRating(String ratingId) {
		Rating existing = ratingRepository.findRating(ratingId);
		if(existing == null)
			throw new RatingNotFoundException("Rating with id:" + ratingId + "not found");
		else
			ratingRepository.deleteRating(existing);
	}
	
}
