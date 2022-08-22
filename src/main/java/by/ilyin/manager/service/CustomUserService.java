package by.ilyin.manager.service;

import by.ilyin.manager.entity.User;

import java.util.Optional;

public interface CustomUserService {

    public void save(User user);

    public Optional<User> findByUsername(String username);

    public Optional<User> findById(Long id);
}
