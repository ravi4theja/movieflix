package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Comment;

@Repository
public class CommentRepositoryImp implements CommentRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Comment> findCommentsByMovie(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findCommentsByMovie", Comment.class);
		query.setParameter("pMovie", movieId);
		return query.getResultList();
	}
	
	@Override
	public List<Comment> findCommentsByUser(String userId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findCommentsByUser", Comment.class);
		query.setParameter("pUser", userId);
		return query.getResultList();
	}
	
	@Override
	public Comment findComment(String commentId) {
		return em.find(Comment.class, commentId);
	}
	
	@Override
	public Comment addComment(Comment comment) {
		em.persist(comment);
		return comment;
	}
	
	@Override
	public Comment updateComment(Comment comment) {
		em.merge(comment);
		return comment;
	}
	
	@Override
	public void delete(Comment comment) {
		em.remove(comment);
	}
	
	
	
}
