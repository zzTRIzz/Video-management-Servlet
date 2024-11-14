//package NguoiDung;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet({"/user", "/user-add", "/user-update", "/delete-user"})
//public class UserServlet extends HttpServlet {
//    UserService userService = new UserService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        if (url.contains("/delete-user")) {
//            String id = req.getParameter("id");
//            System.out.println("ID to delete: " + id);
//            userService.removeID(id);
//            resp.sendRedirect("/user");
//            return;
//        }
//        if (url.contains("/user-add")) {
//            req.setAttribute("currentUser", new User());
//            req.getRequestDispatcher("/template/nguoidung/add.jsp").forward(req, resp);
//
//        }
//        else if (url.contains("/user-update")) {
//            String id = req.getParameter("id");
//            User u = userService.findID(id);
//            req.setAttribute("currentUser", u);
//            req.getRequestDispatcher("/template/nguoidung/edit.jsp").forward(req, resp);
//        }
//        req.setAttribute("list", userService.getList());
//        req.getRequestDispatcher("/template/nguoidung/table.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if ("add".equals(action)) {
//            resp.sendRedirect("user-add");
//        } else if ("update".equals(action)) {
//            resp.sendRedirect("user-update");
//        }
//
//
//        String id = req.getParameter("id");
//        User u1 = userService.findID(id);
//        String password;
//        if (u1 == null || u1.getPassword().isEmpty()) {
//            password = req.getParameter("password");
//        } else {
//            password = u1.getPassword();
//        }
//        String email = req.getParameter("email");
//        String fullname = req.getParameter("fullname");
//        Boolean admin = req.getParameter("admin") != null;
//        User u = new User(id, password, email, fullname, admin);
//
//
//        if (req.getRequestURI().contains("/user-add")) {
//            List<String> alert = checkValidateThongBao(u);
//            if (alert.size() > 0) {
//                System.out.println(alert);
//                req.setAttribute("alert", alert);
//                req.getRequestDispatcher("/template/nguoidung/add.jsp").forward(req, resp);
//            } else {
//                req.setAttribute("currentUser", u);
//                userService.add(u);
//                resp.sendRedirect("user");
//            }
//        }
//        if (req.getRequestURI().contains("/user-update")) {
//            List<String> alert = checkValidateThongBaoUpdate(u);
//            if (alert.size() > 0) {
//                System.out.println(alert);
//                req.setAttribute("alert", alert);
//                req.getRequestDispatcher("/template/nguoidung/edit.jsp").forward(req, resp);
//            } else {
//                userService.update(u);
//                resp.sendRedirect("user");
//            }
//
//        }
//    }
//
//    List checkValidateThongBao(User u) {
//        List<String> listError = new ArrayList<>();
//        if (u.getId().trim().isEmpty()) {
//            listError.add("ID khong duoc bo trong\n");
//        }
//        if (u.getPassword().trim().isEmpty()) {
//            listError.add("Password khong duoc bo trong\n");
//        } else if (u.getPassword().length() <= 6 && !u.getPassword().matches("\"^(?=.*[a-zA-Z])(?=.*\\\\d).+$\"")) {
//            listError.add("Password phai > 6 ki tu, chứa ít nhất 1 chữ số và ít nhất 1 chữ cái\n");
//        }
//        if (u.getEmail().trim().isEmpty()) {
//            listError.add("Email khong duoc bo trong\n");
//        }
//        if (u.getFullname().trim().isEmpty()) {
//            listError.add("Fullname khong duoc bo trong\n");
//        }
//        for (User user : userService.getList()) {
//            if (user.getId().equals(u.getId())) {
//                listError.add("ID : " + u.getId() + " da ton tai\n");
//            }
//            if (user.getEmail().equals(u.getEmail())) {
//                listError.add("Email : " + u.getEmail() + " da ton tai\n");
//            }
//        }
//        return listError;
//    }
//
//    List checkValidateThongBaoUpdate(User u) {
//        List<String> listError = new ArrayList<>();
//        if (u.getId().trim().isEmpty()) {
//            listError.add("ID khong duoc bo trong\n");
//        }
//        if (u.getPassword().trim().isEmpty()) {
//            listError.add("Password khong duoc bo trong\n");
//        } else if (u.getPassword().length() <= 6 && !u.getPassword().matches("\"^(?=.*[a-zA-Z])(?=.*\\\\d).+$\"")) {
//            listError.add("Password phai > 6 ki tu, chứa ít nhất 1 chữ số và ít nhất 1 chữ cái\n");
//        }
//        if (u.getEmail().trim().isEmpty()) {
//            listError.add("Email khong duoc bo trong\n");
//        }
//        if (u.getFullname().trim().isEmpty()) {
//            listError.add("Fullname khong duoc bo trong\n");
//        }
//        return listError;
//    }
//
//
//}
