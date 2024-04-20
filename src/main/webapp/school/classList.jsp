<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Class List</title>
</head>
<body>
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>Ten lop</th>--%>
<%--        <th>Da nop</th>--%>
<%--        <th>Nam hoc</th>--%>
<%--        <th>So tien</th>--%>
<%--        <th>Tong tien da nop</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items = "${students}" var="students">--%>
<%--        <tr>--%>
<%--            <td>${students.class_name}</td>--%>
<%--            <td>${countStudentName}</td>--%>
<%--            <td>${students.year_name}</td>--%>
<%--            <td><fmt:formatNumber type="number" value="${price}"/></td>--%>
<%--            <td><fmt:formatNumber type="number" value="${price * countStudentName}"/></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    <td><a href="/school?action=view">Detail</a></td>--%>
<%--</table>--%>
<div class = "header">
    <img src="img/Logo_Đại_học_Sư_phạm_Kỹ_thuật_Đà_Nẵng.png" width="100" height="100" style="display: block; margin: 10px;">
    <div class="textLogo">
        <h6 style="color: white">ĐẠI HỌC ĐÀ NẴNG</h6>
        <h4 style="color: white">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT</h4>
        <h6 style="color: white">Khoa Công Nghệ Số</h6>
    </div>
    <div class="icons" style = "padding-top: 20px">
        <c:if test="${sessionScope.loginedAccount == null}">
            <a style="text-decoration: none; margin-left: 350px" class ="fas fa-user" href="${pageContext.request.contextPath}/login"><span>Tài khoản: ${sessionScope.loginedUser.userName}</span></a>
        </c:if>
        <c:if test="${sessionScope.loginedAccount == null}">
            <a style="text-decoration: none; margin-left: 10px" class="fas fa-sign-out-alt" href="${pageContext.request.contextPath}/logout"><span>Đăng xuất</span></a>
        </c:if>
    </div>
    <div class = "textRight" style = "margin-top: 50px">
        <h5 style = "color: white">Quản lý tiền đoàn phí sinh viên</h5>
    </div>
</div>
<h3>Danh sách các lớp</h3>

<div class = "list">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Tên lớp</th>
            <th scope="col">Đã nộp</th>
            <th scope="col">Năm học</th>
            <th scope="col">Số tiền</th>
            <th scope="col">Tổng tiền</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${students}" var="students">
            <tr>
                <td>${students.class_name}</td>
                <td>${countStudentName}</td>
                <td>${students.year_name}</td>
                <td><fmt:formatNumber type="number" value="${price}"/></td>
                <td><fmt:formatNumber type="number" value="${price * countStudentName}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<td>
    <a style = "float: left; margin-left: 85%" href="/school?action=view"><span>Xem chi tiết</span><i></i></a>
</td>
</body>
</html>