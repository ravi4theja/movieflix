package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Rating;

@Repository
public class RatingRepositoryImp implements RatingRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Rating> findRatingsByMovie(String movieId) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findRatingsByMovie", Rating.class);
		query.setParameter("pMovie", movieId);
		List<Rating> ratings = query.getResultList();
		return ratings;
	}
	
	@Override
	public Rating findRating(String ratingId) {
		return em.find(Rating.class, ratingId);
	}
	
	@Override
	public Rating addRating(Rating rating) {
		em.persist(rating);
		return rating;
	}
	
	@Override
	public Rating updateRating(Rating rating) {
		em.merge(rating);
		return rating;
	}
	
	@Override
	public void deleteRating(Rating rating) {
		em.remove(rating);
	}
	
}
