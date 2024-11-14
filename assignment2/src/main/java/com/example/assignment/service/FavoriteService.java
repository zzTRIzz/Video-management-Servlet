package com.example.assignment.service;

import com.example.assignment.entity.Favorite;

public interface FavoriteService {
    void add(Favorite favorite);
    void remove(String userId, String videoId);

}
