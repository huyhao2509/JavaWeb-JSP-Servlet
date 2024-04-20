<%@ page import="model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>View student</title>
</head>
<body>
<div class = "header">
    <img src="img/Logo_Đại_học_Sư_phạm_Kỹ_thuật_Đà_Nẵng.png" style="display: block; margin: 20px;" width="100" height="100">
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
<h3>Danh sách lớp ${className}</h3>

<span style = "margin-left: 680px">Năm học ${yearName}</span>
<div class = "list" style="margin-top: 10px">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Mã sinh viên</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="students">
        <tr>
            <td>${students.student_code}</td>
            <td>${students.studentName}</td>
            <td>
                <fmt:formatDate value="${students.student_birthday}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <c:if test = "${students.student_status}">Đã nộp</c:if>
                <c:if test = "${!students.student_status}">Chưa nộp</c:if>
            </td>
        </tr>
                <%
            List<Student> students = new ArrayList<>();
            session.setAttribute("students", students);
        %>
        </c:forEach>
    </table>
</div>
<div style="float: left; margin-left: 80%">
    <p><b>Tổng tiền:</b> <fmt:formatNumber type="number" value="${price * countStudentNameStatus}"/></p>
    <p><b>Đã nộp:</b> <fmt:formatNumber type="number" value="${price * countStudentName}"/></p>
    <p><b>Còn lại:</b> <fmt:formatNumber type="number" value="${(price * countStudentNameStatus) - (price * countStudentName)}"/></p>
</div>
<a style = "float: right; margin-right: 85px" href="/school?action=export"><span>Xuất file Excel</span><i></i></a>
<a style = "float: right; margin-right: 20px" href="${pageContext.request.contextPath}/school"><span>Trở về</span><i></i></a>
</body>
</html>