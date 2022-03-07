
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body>
<div class="col-3"></div>
<form class="col-3 needs-validation" action="${pageContext.request.contextPath}/route/do-add" modelAttribute="route" method="POST">
  <div class="form-group mb-3">
    <label for="distance">Khoảng cách</label>
    <input path="distance" type="number" class="form-control" id="distance" placeholder="Enter name" name="distance"
           required
           maxlength="50">
    <span id="name_error"></span>
  </div>
  <div class="form-group mb-3">
    <label for="totalBusStop">Tổng số lượt</label>
    <input path="totalBusStop" type="number" class="form-control" id="totalBusStop" placeholder="Enter address" name="totalBusStop"
           required
           maxlength="50">
    <span id="address_error"></span>
  </div>
  <button type="submit" class="btn btn-info" id="saves-button">Save</button>

</form>

<div class="col-3"></div>
</body>
</html>

