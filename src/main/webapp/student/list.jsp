<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Trang chủ</title>
</head>
<body style = "background-color:  #f6f6f9">

<div class = "header">
    <img src="img/Logo_Đại_học_Sư_phạm_Kỹ_thuật_Đà_Nẵng.png" style="display: block; margin: 20px;" width="100" height="100">
    <div class="textLogo">
        <h6 style="color: white">ĐẠI HỌC ĐÀ NẴNG</h6>
        <h4 style="color: white">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT</h4>
        <h6 style="color: white">KHOA CÔNG NGHỆ SỐ</h6>
    </div>
    <div class = "textRight">
        <h5 style = "color: white">Quản lý tiền đoàn phí sinh viên</h5>
    </div>
</div>

<h3>Danh sách sinh viên</h3>
<div class = "search">
    <div class="add">
        <a style = "float: left; margin-left: 18px" href="${pageContext.request.contextPath}/student?action=create"><span>(+) Thêm mới</span><i></i></a>
    </div>
</div>
<div class = "list">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Mã sinh viên</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Trạng thái</th>
            <th scope="col" style="padding-left: 90px">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.student_code}</td>
            <td>${student.studentName}</td>
            <td>
                <fmt:formatDate value="${student.student_birthday}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <c:if test = "${student.student_status}">Đã nộp</c:if>
                <c:if test = "${!student.student_status}">Chưa nộp</c:if>
            </td>
            <td>
                <a style = "float: left" href= "${pageContext.request.contextPath}/student?action=update&student_code=${student.student_code}"><span>Chỉnh sửa</span><i></i></a>
                <a style = "float: left; margin-left: 20px" href= "${pageContext.request.contextPath}/student?action=delete&student_code=${student.student_code}"><span>Xóa</span><i></i></a>
            </td>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>