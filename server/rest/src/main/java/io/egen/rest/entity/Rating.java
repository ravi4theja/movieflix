package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Rating.findRatingsByMovie", query = "SELECT r FROM Rating r WHERE :pMovie = ANY(SELECT m.id FROM r.movies m)")
})
public class Rating {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	private short rating;
	
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Movie> movies;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<User> users;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", movies=" + movies + ", users=" + users + "]";
	}

}
