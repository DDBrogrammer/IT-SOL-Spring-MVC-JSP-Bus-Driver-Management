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

<div class="container ">
  <%-- <a type="button" class="btn btn-primary btn-md ms-4 mt-5" href="${pageContext.request.contextPath}/add-driver">Add Driver</a>--%>
  <table class="table table-striped table-dark" id="table-data">
    <thead>
    <tr>
      <th scope="col">Action</th>
      <th scope="col">Driver ID</th>
      <th scope="col">Driver name</th>
      <th scope="col">Route</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="feRoster" items="${feRosters}">
      <tr>
        <td>
          <a type="button" class="btn btn-primary"
             href="${pageContext.request.contextPath}/roster/edit?id=${feRoster.driver.id}">Update</a>
          <a type="button" class="btn btn-danger"
             href="${pageContext.request.contextPath}/roster/delete?id=${feRoster.driver.id}">Delete</a>
        </td>
        <td class="id">${feRoster.driver.id}</td>
        <td class="name">${feRoster.driver.name}</td>
       <td>
         <table class="table table-striped table-dark" >
           <thead>
           <tr>
             <th scope="col">Id</th>
             <th scope="col">Khoảng cách</th>
             <th scope="col">Tổng số lượt</th>
           </tr>
           </thead>
           <tbody>
           <c:forEach var="route" items="${feRoster.routes}">
             <tr>
               <td class="id">${route.id}</td>
               <td class="distance">${route.distance}</td>
               <td class="total-bus-stop">${route.totalBusStop}</td>
             </tr>
           </c:forEach>
           </tbody>
         </table>
        </td>

      </tr>
    </c:forEach>
    </tbody>
  </table>
    <a type="button" class="btn btn-primary"
       href="">Add</a>
</div>

</body>
</html>

