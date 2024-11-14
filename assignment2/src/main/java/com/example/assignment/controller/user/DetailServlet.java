package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    VideoService service = ServiceFactory.getVideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("requestURI", req.getRequestURI());
        String videoId = req.getParameter("id");
        String username = (String) req.getSession().getAttribute("username");

        if (videoId == null) {
            resp.sendRedirect("home");
            return;
        }

        Video video = service.findById(videoId);
        if (video == null) {
            resp.sendRedirect("home");
            return;
        }

        req.setAttribute("video", video);

        if (username != null) {
            boolean likedByUser = service.isVideoLikedByUser(videoId, username);
            req.setAttribute("likedByUser", likedByUser);
        }

        req.getRequestDispatcher("/view/detail.jsp").forward(req, resp);
    }
}
