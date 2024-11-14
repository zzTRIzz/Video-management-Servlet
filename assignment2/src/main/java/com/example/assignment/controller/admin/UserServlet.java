package com.example.assignment.controller.admin;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/user", "/user-add", "/user-update", "/delete-user"})
public class UserServlet extends HttpServlet {
    UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/delete-user")) {
            String id = req.getParameter("id");
            userService.removeID(id);
            resp.sendRedirect("/user");
            return;
        } else if (url.contains("/user-add")) {
            req.setAttribute("currentUser", new User());
            req.getRequestDispatcher("/template/nguoidung/add.jsp").forward(req, resp);
        } else if (url.contains("/user-update")) {
            String id = req.getParameter("id");
            User currentUser = userService.findID(id);
            req.setAttribute("currentUser", currentUser);
            req.getRequestDispatcher("/template/nguoidung/edit.jsp").forward(req, resp);
        } else {
            List<User> list = userService.getList();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/template/nguoidung/table.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        List<String> alert = new ArrayList<>();
        User user = new User();
        user.setId(req.getParameter("id"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setFullname(req.getParameter("fullname"));
        user.setAdmin("on".equals(req.getParameter("admin")));

        if (url.contains("/user-add")) {
            alert = checkValidateThongBaoAdd(user);
            if (alert.isEmpty()) {
                userService.add(user);
                resp.sendRedirect("/user");
            } else {
                req.setAttribute("currentUser", user);
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("/template/nguoidung/add.jsp").forward(req, resp);
            }
        } else if (url.contains("/user-update")) {
            alert = checkValidateThongBaoUpdate(user);
            if (alert.isEmpty()) {
                userService.update(user);
                resp.sendRedirect("/user");
            } else {
                req.setAttribute("currentUser", user);
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("/template/nguoidung/edit.jsp").forward(req, resp);
            }
        }
    }

    private List<String> checkValidateThongBaoAdd(User user) {
        List<String> listError = new ArrayList<>();
        if (user.getId().trim().isEmpty()) {
            listError.add("ID không được bỏ trống");
        }
        if (user.getPassword().trim().isEmpty()) {
            listError.add("Password không được bỏ trống");
        } else if (user.getPassword().length() <= 6 || !user.getPassword().matches("^(?=.*[a-zA-Z])(?=.*\\d).+$")) {
            listError.add("Password phải > 6 kí tự, chứa ít nhất 1 chữ số và ít nhất 1 chữ cái");
        }
        if (user.getEmail().trim().isEmpty()) {
            listError.add("Email không được bỏ trống");
        }
        if (user.getFullname().trim().isEmpty()) {
            listError.add("Fullname không được bỏ trống");
        }
        for (User u : userService.getList()) {
            if (user.getId().equalsIgnoreCase(u.getId())) {
                listError.add("ID không được trùng nhau");
            }
        }
        return listError;
    }

    private List<String> checkValidateThongBaoUpdate(User u) {
        List<String> listError = new ArrayList<>();
        if (u.getPassword().trim().isEmpty()) {
            listError.add("Password không được bỏ trống");
        } else if (u.getPassword().length() <= 6 || !u.getPassword().matches("^(?=.*[a-zA-Z])(?=.*\\d).+$")) {
            listError.add("Password phải > 6 kí tự, chứa ít nhất 1 chữ số và ít nhất 1 chữ cái");
        }
        if (u.getEmail().trim().isEmpty()) {
            listError.add("Email không được bỏ trống");
        }
        if (u.getFullname().trim().isEmpty()) {
            listError.add("Fullname không được bỏ trống");
        }
        return listError;
    }
}

