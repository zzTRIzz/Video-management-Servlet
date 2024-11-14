package com.example.assignment.service.impl;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;

import java.util.List;

public class UserServiceMockImpl implements UserService {
    @Override
    public boolean checkUser(String username, String password) {
        return "poly".equals(username) && "123".equals(password);
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public void add(User u) {

    }

    @Override
    public void removeID(String id) {

    }

    @Override
    public User findID(String id) {
        return null;
    }

    @Override
    public void update(User u) {

    }
}
