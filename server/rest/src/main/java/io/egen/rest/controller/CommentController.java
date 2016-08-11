package io.egen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.egen.rest.entity.Comment;
import io.egen.rest.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/movies/{movieId}/comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findCommentsByMovie(@PathVariable("movieId") String movieId) {
		return commentService.findCommentsByMovie(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{userId}/comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findCommentsByUser(@PathVariable("userId") String userId) {
		return commentService.findCommentsByUser(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/comments/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment findComment(@PathVariable("id") String commentId) {
		return commentService.findComment(commentId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/comments/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/comments/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment updateComment(@PathVariable("id") String commentId, @RequestBody Comment comment) {
		return commentService.updateComment(comment, commentId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/comments/{id}")
	public void delete(@PathVariable("id") String commentId) {
		commentService.delete(commentId);
	}
	
}
