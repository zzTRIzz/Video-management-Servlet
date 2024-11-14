package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Favorite;
import com.example.assignment.service.FavoriteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
    FavoriteService favoriteService = ServiceFactory.getFavoriteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String videoId = req.getParameter("id");
        String userId = (String) req.getSession().getAttribute("username");

        if (videoId != null && userId != null) {
            Favorite favorite = new Favorite();
            favorite.setUserId(userId);
            favorite.setVideoId(videoId);
            favoriteService.add(favorite);
        }

        resp.sendRedirect("detail?id=" + videoId);
    }
}
