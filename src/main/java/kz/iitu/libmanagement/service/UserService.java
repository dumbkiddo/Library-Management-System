package kz.iitu.libmanagement.service;

import kz.iitu.libmanagement.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
}