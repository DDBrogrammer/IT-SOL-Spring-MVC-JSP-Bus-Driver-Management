<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trang chủ </title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <style>
.main{height: auto;
width: 100%;}
  </style>
</head>
<body class="bg-dark text-white">

<div class="row bg-dark" >
  <h1 class="col-12 text-center">Quản lý phân công xe bus</h1>
  <div class=" px-5 col-4" ><a href="${pageContext.request.contextPath}/driver" class=" mx-5 mb-5 col-4 btn btn-danger"> Quản lý lái xe</a></div>
  <div class=" px-5 col-4" > <a href="${pageContext.request.contextPath}/route" class=" mx-5 mb-5 col-4 btn btn-danger"> Quản lý tuyến đường </a> </div>
  <div class=" px-5 col-4" > <a href="${pageContext.request.contextPath}/roster" class=" mx-5 mb-5 col-4 btn btn-danger"> Quản lý bảng phân công </a></div>

</div>
<div class="main ">
</div>
</body>
</html>
