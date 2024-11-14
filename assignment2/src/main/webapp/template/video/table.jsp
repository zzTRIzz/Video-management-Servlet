<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<form action="" method="post">
  <div class="container-md mt-5 w-50">
    <h2 class="d-flex justify-content-center mb-4">Màn hình danh sách</h2>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col">Active</th>
        <th scope="col">Poster</th>
        <th scope="col">Function</th>
      </tr>
      </thead>
      <tbody>

      <c:forEach items="${list}" var="u">
        <tr>
          <td>${u.id}</td>
          <td>${u.title}</td>
          <td>${u.description}</td>
          <td>${u.active ? "Yes" : "No"}</td> <!-- Thay đổi ở đây -->
          <td><img src="${u.poster}" alt="${u.title}" style="width:100px;height:auto;"></td>
          <td>
            <a href="/video-update?id=${u.id}"><span class="btn btn-warning" name="action" value="update">Update</span></a>
            <a href="/delete-video?id=${u.id}" onclick="return showAlertDelete()"><span class="btn btn-danger">Delete</span></a>
          </td>
        </tr>
      </c:forEach>

      </tbody>
    </table>

    <a href="/movie-add"><button class="btn btn-primary" name="action" value="add">New movie</button></a>
  </div>
</form>

<script type="text/javascript">
  function showAlertDelete() {
    return confirm("Bạn có muốn xóa không");
  }
</script>
</body>
</html>
