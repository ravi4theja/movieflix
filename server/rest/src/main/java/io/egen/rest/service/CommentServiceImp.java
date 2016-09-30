package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Comment;
import io.egen.rest.entity.Movie;
import io.egen.rest.exception.CommentNotFoundException;
import io.egen.rest.exception.MovieNotFoundException;
import io.egen.rest.repository.CommentRepository;
import io.egen.rest.repository.MovieRepository;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Comment> findCommentsByMovie(String movieId) {
		return commentRepository.findCommentsByMovie(movieId);
	}
	
	@Override
	public List<Comment> findCommentsByUser(String userId) {
		return commentRepository.findCommentsByUser(userId);
	}
	
	@Override
	public Comment findComment(String commentId) {
		Comment existing = commentRepository.findComment(commentId);
		if(existing == null)
			throw new CommentNotFoundException("Comment with id:" + commentId + " not found");
		else
			return existing;
	}
	
	@Override
	@Transactional
	public Comment addComment(Comment comment) {
		Movie existing = movieRepository.findOne(comment.getMovie().getId());
		if (existing == null) 
			throw new MovieNotFoundException("Movie with id:" + comment.getMovie().getId() + " not found");
		else
			return commentRepository.addComment(comment);
	}
	
	@Override
	public Comment updateComment(Comment comment, String commentId) {
		Comment existing = commentRepository.findComment(commentId);
		if(existing == null)
			throw new CommentNotFoundException("Comment with id:" + commentId + " not found");
		else
			return commentRepository.updateComment(comment);
	}
	
	@Override
	@Transactional
	public void delete(String commentId) {
		Comment existing = commentRepository.findComment(commentId);
		if(existing == null)
			throw new CommentNotFoundException("Comment with id:" + commentId + "not found");
		else
			commentRepository.delete(existing);
	}
	
}
