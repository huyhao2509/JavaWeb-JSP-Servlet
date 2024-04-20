<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="icon" href="image/logo.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Trang chủ</title>
</head>
<body>
<div class = "header">
    <img src="img/Logo_Đại_học_Sư_phạm_Kỹ_thuật_Đà_Nẵng.png" width="100" height="100" style="display: block; margin: 10px;">


    <div class="textLogo">
        <h6 style="color: white">ĐẠI HỌC ĐÀ NẴNG</h6>
        <h4 style="color: white">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT</h4>
        <h6 style="color: white">Khoa Công Nghệ Số </h6>
    </div>
    <div class="icons" style="padding-top: 20px; margin-left: -50px;">
        <c:if test="${sessionScope.loginedAccount == null}">
            <a style="text-decoration: none; margin-left: 600px" class ="fas fa-user" href="${pageContext.request.contextPath}/login"><span>Tài khoản: ${sessionScope.loginedUser.userName}</span></a>
        </c:if>
        <c:if test="${sessionScope.loginedAccount == null}">
            <a style="text-decoration: none; margin-left: 10px" class="fas fa-sign-out-alt" href="${pageContext.request.contextPath}/logout"><span>Đăng xuất</span></a>
        </c:if>
    </div>
    <div class = "textRight" style = "margin-top: 50px">
        <h5 style = "color: white">Quản lý tiền đoàn phí sinh viên</h5>
    </div>
</div>
<nav class="navbar">
    <a style="text-decoration: none; margin-left: 20px" href="${pageContext.request.contextPath}/home"><span>Trang chủ</span></a>
    <c:if test="${sessionScope.loginedUser.role == 1}">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/student"><span>Quản lý sinh viên lớp</span></a>
    </c:if>
    <c:if test="${sessionScope.loginedUser.role == 0}">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/school"><span>Quản lý lớp</span></a>
    </c:if>
</nav>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>