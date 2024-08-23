package dev.app.devreilway.service;


import dev.app.devreilway.model.User;

public interface UserService {
    User findById(Long id);
    User create(User create);
}
