package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Comment;

public interface CommentRepository {

	public List<Comment> findCommentsByMovie(String movieId);
	
	public List<Comment> findCommentsByUser(String userId);
	
	public Comment findComment(String commentId);
	
	public Comment addComment(Comment comment);
	
	public Comment updateComment(Comment comment);
	
	public void delete(Comment comment);
}
