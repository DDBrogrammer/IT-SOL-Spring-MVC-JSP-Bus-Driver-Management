
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body class="bg-dark text-white">
<div class="col-3"></div>
<form class="col-3 needs-validation" action="${pageContext.request.contextPath}/route/add" modelAttribute="route" method="POST">
  <c:if test="${id!=null}" var="condition">
    <div class="form-group mb-3">
      <label for="id">Id</label>
      <input path="id"type="number" id="id" name="id" value="${route.id}"  readonly>
    </div>
  </c:if>


  <div class="form-group mb-3">
    <label for="distance">Distance</label>
    <input path="distance" type="number" class="form-control" id="distance" placeholder="Enter distance" name="distance"
           required
           step="0.01"
           value="${route.distance}">
    <span id="distance_error"></span>
  </div>

  <div class="form-group mb-3">
    <label for="totalBusStop">Total bus stop </label>
    <input path="totalBusStop" type="number" class="form-control" id="totalBusStop" placeholder="Enter total bus stop" name="totalBusStop"
           required
           maxlength="50"  value="${route.totalBusStop}">
    <span id="address_error"></span>
  </div>


  <button type="submit" class="btn btn-info" id="saves-button">Save</button>
</form>

<div class="col-3"></div>
</body>
</html>


