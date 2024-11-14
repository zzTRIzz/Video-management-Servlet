package com.example.assignment.controller.admin;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/video", "/video-update", "/video-add", "/delete-video"})
public class VideoServlet extends HttpServlet {
    VideoService vs = ServiceFactory.getVideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("/delete-video")) {
            String id = req.getParameter("id");
            vs.deleteById(id);
            resp.sendRedirect("/video");
        } else if (url.contains("/video-add")) {
            req.setAttribute("currentVideo", new Video());
            req.getRequestDispatcher("/template/video/add.jsp").forward(req, resp);
        } else if (url.contains("/video-update")) {
            String id = req.getParameter("id");
            Video v = vs.findById(id);
            req.setAttribute("currentVideo", v);
            req.getRequestDispatcher("/template/video/edit.jsp").forward(req, resp);
        } else {
            req.setAttribute("list", vs.findAll());
            req.getRequestDispatcher("/template/video/table.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Boolean active = req.getParameter("admin") != null;
        String poster = req.getParameter("poster");

        Video v = new Video(id, title, description, poster, active);

        List<String> errors = new ArrayList<>();

        if ("add".equals(action) || req.getRequestURI().contains("/video-add")) {
            String checkIDError = checkID(v);
            if (checkIDError != null) {
                errors.add(checkIDError);
            }
        }


        String checkTitleError = checkTitle(v);
        if (checkTitleError != null) {
            errors.add(checkTitleError);
        }

        String checkPosterError = checkPoster(v);
        if (checkPosterError != null) {
            errors.add(checkPosterError);
        }


        if (!errors.isEmpty()) {
            req.setAttribute("alert", errors);
            req.setAttribute("currentVideo", v);
            if ("add".equals(action) || req.getRequestURI().contains("/video-add")) {
                req.getRequestDispatcher("/template/video/add.jsp").forward(req, resp);
            } else if ("update".equals(action) || req.getRequestURI().contains("/video-update")) {
                req.getRequestDispatcher("/template/video/edit.jsp").forward(req, resp);
            }
        } else {
            if ("add".equals(action) || req.getRequestURI().contains("/video-add")) {
                vs.add(v);
            } else if ("update".equals(action) || req.getRequestURI().contains("/video-update")) {
                vs.update(v);
            }
            resp.sendRedirect("/video");
        }
    }

    private String checkID(Video v) {
        if (v.getId() == null || v.getId().trim().isEmpty()) {
            return "ID không được bỏ trống";
        }
        for (Video video : vs.findAll()) {
            if (video.getId().equals(v.getId())) {
                return "ID đã tồn tại";
            }
        }
        return null;
    }

    private String checkTitle(Video v) {
        if (v.getTitle() == null || v.getTitle().trim().isEmpty()) {
            return "Title không được bỏ trống";
        }
        return null;
    }

    private String checkPoster(Video v) {
        if (v.getPoster() == null || v.getPoster().trim().isEmpty()) {
            return "Poster không được bỏ trống";
        }
        return null;
    }

}
