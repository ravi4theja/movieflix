package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Rating.findRatingsByMovie", query = "SELECT r FROM Rating r WHERE r.movie.id = :pMovie"),
	@NamedQuery(name = "Rating.findRatingsByUser", query = "SELECT r FROM Rating r WHERE r.user.id = :pUser"),
	@NamedQuery(name = "Rating.findRatingsForMovieByUser", query = "SELECT r FROM Rating r WHERE r.movie.id = :pMovie AND r.user.id = :pUser")
})
public class Rating {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	private int rating;
	
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", movie=" + movie + ", user=" + user + "]";
	}
	
	
}

	