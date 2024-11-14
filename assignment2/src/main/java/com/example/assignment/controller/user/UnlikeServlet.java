package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.service.FavoriteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/unlike")
public class UnlikeServlet extends HttpServlet {
    FavoriteService favoriteService = ServiceFactory.getFavoriteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String videoId = req.getParameter("id");
        String username = (String) req.getSession().getAttribute("username");

        if (username == null) {
            resp.sendRedirect("login");
            return;
        }

        // Remove video from user's favorite list
        favoriteService.remove(username, videoId);

        resp.sendRedirect("detail?id=" + videoId);
    }
}
