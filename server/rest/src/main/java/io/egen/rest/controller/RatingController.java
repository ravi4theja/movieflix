package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Rating;
import io.egen.rest.service.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/movies/{movieId}/ratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Rating> findRatingsByMovie(@PathVariable("movieId") String movieId) {
		return ratingService.findRatingsByMovie(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating findOne(@PathVariable("id") String ratingId) {
		return ratingService.findRating(ratingId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/ratings/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating addRating(@RequestBody Rating rating) {
		return ratingService.addRating(rating);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/ratings/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating updateRating(@PathVariable("id") String ratingId, @RequestBody Rating rating) {
		return ratingService.updateRating(rating, ratingId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/rating/{id}")
	public void deleteRating(@PathVariable("id") String ratingId) {
		ratingService.deleteRating(ratingId);
	}

}
