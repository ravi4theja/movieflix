package io.egen.rest.entity;

import javax.persistence.Column;
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
	@NamedQuery(name = "Comment.findCommentsByMovie", query = "SELECT c FROM Comment c WHERE c.movie.id = :pMovie"),
	@NamedQuery(name = "Comment.findCommentsByUser", query = "SELECT c FROM Comment c WHERE c.user.id = :pUser")
})

public class Comment {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@Column(columnDefinition="TEXT")  //comment as a long string
	private String comment;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Movie movie;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", user=" + user + ", movie=" + movie + "]";
	}
}
