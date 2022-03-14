<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>

  $(document).ready(function () {
  $(".route-table").change(function () {
    for (const checkbox of document.querySelectorAll('input[type="checkbox"]')) {
      if (checkbox.checked === true) {
        $('#'+checkbox.value).prop('disabled', false);
      }else {
        $('#'+checkbox.value).prop('disabled', true);
      }
    }
  });
  });

</script>
</head>
<body class="bg-dark text-white">

<div class="container">
  <form method="POST"  modelAttribute="feRoster" >
  <table class="table table-striped table-dark" id="table-data">
    <thead>
    <tr>
      <th scope="col">Chọn</th>
      <th scope="col">Id</th>
      <th scope="col">Họ và tên</th>
      <th scope="col">Địa chỉ</th>
      <th scope="col">Số điện thoại</th>
      <th scope="col">Trình độ</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="driver" items="${drivers}">
      <tr>
        <td>
          <input type="radio" name="driver" value="${driver}">
        </td>
        <td class="id">${driver.id}</td>
        <td class="fullName">${driver.name}</td>
        <td class="address">${driver.address}</td>
        <td class="phoneNumber">${driver.phone}</td>
        <td class="driveLevel">${driver.skill}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

    <div class="route-table">
      <label>Chose routes </label><br>
      <c:forEach var="route" items="${routes}">
        <input type="checkbox" name="routes" value="${route}"> ${route.id}</input>
        <input type="number" name="total" id="${route.id}" disabled >
        <br>
      </c:forEach>
    </div>
    <button type="submit" class="btn btn-info" id="saves-button">Lưu</button>
</form>
</div>

</body>
</html>

