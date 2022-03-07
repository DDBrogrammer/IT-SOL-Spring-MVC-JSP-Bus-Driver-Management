
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
<form class="col-3 needs-validation" action="${pageContext.request.contextPath}/driver/do-add" modelAttribute="driver" method="POST">
  <div class="form-group mb-3">
    <label for="name">Name</label>
    <input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name"
           required
           maxlength="50" value="${driver.name}">
    <span id="name_error"></span>
  </div>
  <div class="form-group mb-3">
    <label for="address">Address</label>
    <input path="address" type="text" class="form-control" id="address" placeholder="Enter address" name="address"
           required
           maxlength="50"  value="${driver.address}">
    <span id="address_error"></span>
  </div>
  <div class="form-group mb-3">
    <label for="phone">Mobie phone</label>
    <input path="phone" type="number" class="form-control" id="phone" placeholder="Enter phone" value="${driver.phone}
           name="phone" required >
    <span id="phone_error"></span>
  </div>
  <div class="form-group mb-5">
    <label for="skill" style="margin-right: 10px">DriveLevel</label>
    <select path="skill" id="skill" name="skill" style="padding-right: 20px;padding-left: 20px">
      <option value="A">A</option>
      <option value="B">B</option>
      <option value="C">C</option>
      <option value="D">D</option>
      <option value="E">E</option>
      <option value="F">F</option>
    </select>
    <span id="driveLevel_error"></span>
  </div>
  <button type="submit" class="btn btn-info" id="saves-button">Save</button>
</form>

<div class="col-3"></div>
</body>
</html>
