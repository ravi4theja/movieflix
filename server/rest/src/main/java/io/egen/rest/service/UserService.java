package io.egen.rest.service;

import java.util.List;

import io.egen.rest.classes.LoginObj;
import io.egen.rest.classes.LoginResponse;
import io.egen.rest.entity.User;

public interface UserService {
	
	public List<User> findAll();

	public User findOne(String id);

	public User create(User user);

	public User update(String id, User user);

	public void delete(String id);
	
	public LoginResponse createToken(LoginObj loginObj);
}
