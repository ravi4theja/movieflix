package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie findByImdbId(String imdbId);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);
}
