package com.example.assignment;

import com.example.assignment.service.FavoriteService;
import com.example.assignment.service.UserService;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.impl.*;

public class ServiceFactory {
    static VideoService videoService = new VideoServiceImpl();
    static UserService userService = new UserServiceImpl();
    static FavoriteService favoriteService = new FavoriteServiceImpl();

    public static VideoService getVideoService(){
        return videoService;
    }

    public static UserService getUserService(){
        return userService;
    }
    public static FavoriteService getFavoriteService(){
        return favoriteService;
    }
}
