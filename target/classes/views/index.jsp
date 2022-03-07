<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trang chủ </title>
</head>
<body>
<h1>Quản lý phân công xe bus</h1>
<a href="${pageContext.request.contextPath}/driver" class="btn btn-danger"> quản lý lái xe</a>

<a href="${pageContext.request.contextPath}/route" class="btn btn-danger"> Quản lý tuyến đường </a>

<a href="${pageContext.request.contextPath}/roster" class="btn btn-danger"> Quản lý bảng phân công </a>
</body>
</html>
