package app.bookstore.socialbookstore.services;

import org.springframework.stereotype.Service;

import app.bookstore.socialbookstore.domain.User;

@Service
public interface UserService {
	public void saveUser(User user);
	public boolean isUserPresent(User user);
}