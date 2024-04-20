<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Chỉnh sửa</title>
</head>
<body>
<div class = "header">
    <img src="img/Logo_Đại_học_Sư_phạm_Kỹ_thuật_Đà_Nẵng.png" style="display: block; margin: 20px;" width="100" height="100">
    <div class="textLogo">
        <h6 style="color: white">ĐẠI HỌC ĐÀ NẴNG</h6>
        <h4 style="color: white">TRƯỜNG ĐẠI HỌC SƯ PHẠM Kỹ THUẬT</h4>
        <h6 style="color: white">Khoa Công Nghệ Số</h6>
    </div>
    <div class = "textRight">
        <h5 style = "color: white">Quản lý tiền đoàn phí sinh viên</h5>
    </div>
</div>
<div class = "addForm" style = "border: 3px solid #270082; background-color: azure; height: 520px; margin-top: 50px">
    <h3>Chỉnh sửa thông tin sinh viên</h3>
    <form action = "${pageContext.request.contextPath}/student" method = "post">
        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px; margin-top: 20px">
            <span class="input-group-text" id="basic-addon1" style="background-color: #270082; color: white">Mã sinh viên</span>
            <p style="margin-left: 20px;">${student.student_code}</p>
        </div>

        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px; margin-top: 10px">
            <span class="input-group-text" id="basic-addon2" style="background-color: #270082; color: white">Họ và tên</span>
            <input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="basic-addon2" name = "studentName" value="${student.studentName}">
        </div>

        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px; margin-top: 10px">
            <span class="input-group-text" id="basic-addon3" style="background-color: #270082; color: white">Ngày sinh</span>
            <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" name = "student_birthday" value ="${student.studentBirthdayAsString}" >
        </div>

        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px; margin-top: 10px; height: 50px">
            <span class="input-group-text" style="background-color: #270082; color: white; height: 40px">Lớp sinh hoạt</span>
            <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name = "student_class_id" style="height: 40px; font-size: 15px">
                <option selected>Open this select menu</option>
                <option ${student.student_class_id == 1 ? 'selected' : ''} value = "1">20CNTT</option>
            </select>
        </div>

        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px">
            <span class="input-group-text" style="background-color: #270082; color: white; height: 40px">Năm</span>
            <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name = "student_year_id" style="height: 40px; font-size: 15px">
                <option selected>Open this select menu</option>
                <option ${student.student_year_id == 1 ? 'selected' : ''} value = "1">2022-2023</option>
            </select>
        </div>

        <div class="input-group mb-3" style="width: 90%; float: left">
            <span class="input-group-text" style="background-color: #270082; color: white; margin-left: 40px; margin-top: -5px">Trạng thái</span>
            <c:choose>
                <c:when test="${student.student_status}">
                    <input style="margin-left: 20px; margin-top: -10px" type = "radio" name = "student_status" value = "Đã nộp" checked>Đã nộp
                    <input style="margin-left: 20px; margin-top: -10px" type = "radio" name = "student_status" value = "Chưa nộp">Chưa nộp
                </c:when>
                <c:otherwise>
                    <input style="margin-left: 20px; margin-top: -10px" type = "radio" name = "student_status" value = "Đã nộp">Đã nộp
                    <input style="margin-left: 20px; margin-top: -10px" type = "radio" name = "student_status" value = "Chưa nộp" checked>Chưa nộp
                </c:otherwise>
            </c:choose>
        </div>

        <div>
            <td colspan="2">
                <input style = "float: right; margin-right: 90px; margin-top: 10px" type = "submit" value = "Cập nhật">
                <a style = "float: right; margin-right: 20px" href="${pageContext.request.contextPath}/student"><span>Trở về</span><i></i></a>
            </td>
        </div>
        <input type = "hidden" name = "action" value= "update"/>
        <input type = "hidden" name = "student_code" value= "${student.student_code}"/>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>