<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="/user-add" method="post">
  <div class="container w-50 mt-5">
    <h2 class="d-flex justify-content-center mb-4">Add User</h2>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="id" class="fw-bold">Id:</label>
      </div>
      <div class="col-10">
        <input type="text" class="form-control" name="id" value="${currentUser.id}">
      </div>
    </div>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="password" class="fw-bold">Password:</label>
      </div>
      <div class="col-10">
        <input type="password" class="form-control" name="password" value="${currentUser.password}">
      </div>
    </div>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="email" class="fw-bold">Email:</label>
      </div>
      <div class="col-10">
        <input type="text" class="form-control" name="email" value="${currentUser.email}">
      </div>
    </div>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="fullname" class="fw-bold">Fullname:</label>
      </div>
      <div class="col-10">
        <input type="text" class="form-control" name="fullname" value="${currentUser.fullname}">
      </div>
    </div>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="admin" class="fw-bold">Admin:</label>
      </div>
      <div class="col-1">
        <input class="form-check-input" type="checkbox" name="admin" ${currentUser.admin ? "checked" : ""}>
      </div>
    </div>
    <c:if test="${not empty alert}">
      <c:forEach items="${alert}" var="er">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${er}
          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
      </c:forEach>
    </c:if>
    <div class="d-flex justify-content-center mt-4">
      <button class="btn btn-success">Add</button>
    </div>
  </div>
</form>
</body>
</html>
