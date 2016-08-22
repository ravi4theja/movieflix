package io.egen.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findByImdbId", query = "SELECT m FROM Movie m WHERE m.imdbId = :pImdbId"),
	@NamedQuery(name = "Movie.filterByGenre", query = "SELECT m From Movie m WHERE m.genre LIKE :pGenre"),
	@NamedQuery(name = "Movie.filterByImdbRating", query = "SELECT m FROM Movie m WHERE m.imdbRating BETWEEN :pRatingGT and :pRatingLT"),
	@NamedQuery(name = "Movie.filterByMetascore", query = "SELECT m FROM Movie m WHERE m.metascore BETWEEN :pMscoreGT and :pMscoreLT"),
	@NamedQuery(name = "Movie.filterByVotes", query = "SELECT m FROM Movie m WHERE m.imdbVotes BETWEEN :pVotesGT and :pVotesLT")
})
public class Movie {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	@JsonProperty(value="Title")
	private String title;
	
	@JsonProperty(value="Year")
	private String year;
	
	@JsonProperty(value="Rated")
	private String rated;
	
	@JsonProperty(value="Released")
	private String released;
	
	@JsonProperty(value="Runtime")
	private String runtime;
	
	@JsonProperty(value="Genre")
	private String genre;
	
	@JsonProperty(value="Director")
	private String director;
	
	@JsonProperty(value="Writer")
	private String writer;
	
	@JsonProperty(value="Actors")
	private String actors;
	
	@JsonProperty(value="Plot")
	@Column(columnDefinition="TEXT")     // plot as text to accommodate long string
	private String plot;
	
	@JsonProperty(value="Language")
	private String language;
	
	@JsonProperty(value="Country")
	private String country;
	
	@JsonProperty(value="Awards")
	private String awards;
	
	@JsonProperty(value="Poster")
	private String poster;
	
	@JsonProperty(value="Metascore")
	private String metascore;
	
	private String imdbRating;
	
	private String imdbVotes;
	
	@JsonProperty(value="imdbID")
	@Column(unique = true)      // unique imdbId
	private String imdbId;
	
	@JsonProperty(value="Type")
	private String type;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released
				+ ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer
				+ ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + ", type=" + type + "]";
	}
	
	
	
}
