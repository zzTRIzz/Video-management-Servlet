<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Video</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
</head>
<body>
<form action="video-add" method="post">
  <div class="container w-50 mt-5">
    <h2 class="d-flex justify-content-center mb-4">Add New Video</h2>
    <input type="hidden" name="action" value="add">
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="" class="fw-bold">Id:</label>
      </div>
      <div class="col-10">
        <input type="text" class="form-control col-8" name="id" value="${currentVideo.id}">
      </div>
    </div>
    <c:if test="${not empty alert[0]}">
      <div class="alert alert-danger alert-dismissible fade show d-flex justify-content-center align-items-center mt-3"
           role="alert" style="height: 10px; font-size: 11px;">
          ${alert[0]}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"
                style="height: 10px; font-size: 11px;"></button>
      </div>
    </c:if>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="" class="fw-bold">Title:</label>
      </div>
      <div class="col-10">
        <input type="text" class="form-control col-8" name="title" value="${currentVideo.title}">
      </div>
    </div>
    <c:if test="${not empty alert[1]}">
      <div class="alert alert-danger alert-dismissible fade show d-flex justify-content-center align-items-center mt-3"
           role="alert" style="height: 10px; font-size: 11px;">
          ${alert[1]}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"
                style="height: 10px; font-size: 11px;"></button>
      </div>
    </c:if>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="" class="fw-bold">Description:</label>
      </div>
      <div class="col-10">
        <textarea class="form-control" rows="3" name="description">${currentVideo.description}</textarea>
      </div>
    </div>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="" class="fw-bold">ctive:</label>
      </div>
      <div class="col-1">
        <input class="form-check-input" type="checkbox" value="true" name="admin" ${currentVideo.active ? 'checked' : ''}>
      </div>
    </div>
    <div class="row align-items-center mt-2">
      <div class="col-2">
        <label for="" class="fw-bold">Poster:</label>
      </div>
      <div class="col-10">
        <input type="text" class="form-control col-8" name="poster" value="${currentVideo.poster}">
      </div>
    </div>
    <c:if test="${not empty alert[2]}">
      <div class="alert alert-danger alert-dismissible fade show d-flex justify-content-center align-items-center mt-3"
           role="alert" style="height: 10px; font-size: 11px;">
          ${alert[2]}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"
                style="height: 10px; font-size: 11px;"></button>
      </div>
    </c:if>
    <div class="d-flex justify-content-center mt-4">
      <button class="btn btn-success">Add</button>
    </div>
  </div>
</form>
</body>
</html>
