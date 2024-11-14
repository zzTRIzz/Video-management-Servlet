<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-md mt-5 w-50">
  <h2 class="d-flex justify-content-center mb-4">User List</h2>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Password</th>
      <th scope="col">Email</th>
      <th scope="col">Fullname</th>
      <th scope="col">Admin</th>
      <th scope="col">Function</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
      <tr>
        <td>${u.id}</td>
        <td>${u.password}</td>
        <td>${u.email}</td>
        <td>${u.fullname}</td>
        <td>${u.admin ? "Yes" : "No"}</td>
        <td>
          <a href="/user-update?id=${u.id}" class="btn btn-warning">Update</a>
          <a href="/delete-user?id=${u.id}" class="btn btn-danger">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="/user-add" class="btn btn-primary">Add User</a>
</div>
</body>
</html>
