<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

</head>
<body>

<div class="container">
  <%-- <a type="button" class="btn btn-primary btn-md ms-4 mt-5" href="${pageContext.request.contextPath}/add-driver">Add Driver</a>--%>
  <table class="table table-striped table-dark" id="table-data">
    <thead>
    <tr>
      <th scope="col">Action</th>
      <th scope="col">Id</th>
      <th scope="col">Khoảng cách</th>
      <th scope="col">Tổng số lượt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="route" items="${routes}">
      <tr>
        <td>
          <a type="button" class="btn btn-primary"
             href="">Update</a>
          <a type="button" class="btn btn-danger"
             href="${pageContext.request.contextPath}/route/delete?id=${route.id}">Delete</a>
        </td>
        <td class="id">${route.id}</td>
        <td class="fullName">${route.distance}</td>
        <td class="address">${route.totalBusStop}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

    <a type="button" class="btn btn-primary "
       href="${pageContext.request.contextPath}/route/add">Add</a>
</div>

</body>
</html>

