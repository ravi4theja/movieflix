package io.egen.rest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	
})
public class Watchlist {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@ManyToMany
	private List<Movie> watchlist;
	
	@OneToOne
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Movie> getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(List<Movie> watchlist) {
		this.watchlist = watchlist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Watchlist [id=" + id + ", watchlist=" + watchlist + ", user=" + user + "]";
	}
	
	
	
	
}
