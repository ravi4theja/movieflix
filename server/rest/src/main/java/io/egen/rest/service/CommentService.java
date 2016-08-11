package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Comment;

public interface CommentService {

	public List<Comment> findCommentsByMovie(String movieId);
	
	public List<Comment> findCommentsByUser(String userId);
	
	public Comment findComment(String commentId);
	
	public Comment addComment(Comment comment);
	
	public Comment updateComment(Comment comment, String commentId);
	
	public void delete(String commentId);
	
	
}
