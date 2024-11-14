package com.example.assignment.service;

import com.example.assignment.entity.User;

import java.util.List;

public interface UserService {
    boolean checkUser(String username, String password);
    List<User> getList();
    void add(User u);
    void removeID(String id);
    User findID(String id);
    void update(User u);
}
