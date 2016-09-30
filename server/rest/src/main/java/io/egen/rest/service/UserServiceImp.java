package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.classes.LoginObj;
import io.egen.rest.classes.LoginResponse;
import io.egen.rest.entity.User;
import io.egen.rest.exception.UserAlreadyExistsException;
import io.egen.rest.exception.UserNotFoundException;
import io.egen.rest.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + user.getEmail());
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		repository.delete(existing);
	}
	
	@Override
	@Transactional
	public LoginResponse createToken(LoginObj loginObj) {
		User existing = repository.findByEmail(loginObj.email);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + loginObj.email + " not found");
		}
		return repository.createToken(existing);
	}

}
