<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Thêm mới</title>
</head>
<body>
<div class = "header">
    <img src="img/Logo_Đại_học_Sư_phạm_Kỹ_thuật_Đà_Nẵng.png" style="display: block; margin: 20px;" width="100" height="100">
    <div class="textLogo">
        <h6 style="color: white">ĐẠI HỌC ĐÀ NẴNG</h6>
        <h4 style="color: white">TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT</h4>
        <h6 style="color: white">KHOA CÔNG NGHỆ SỐ </h6>
    </div>
    <div class = "textRight">
        <h5 style = "color: white">Quản lý tiền đoàn phí sinh viên</h5>
    </div>
</div>

<%--<form action = "${pageContext.request.contextPath}/student" method = "post">--%>
<%--    <table border = "1">--%>
<%--        <tr>--%>
<%--            <td>Code</td>--%>
<%--            <td><input type = "text" name = "student_code"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Name</td>--%>
<%--            <td><input type = "text" name = "studentName"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>Birthday</td>--%>
<%--            <td><input type = "text" name = "student_birthday"></td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>Class</td>--%>
<%--            <td>--%>
<%--                <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name = "student_class_id">--%>
<%--                    <option selected>Open this select menu</option>--%>
<%--                    <option ${student.student_class_id == 1 ? 'selected' : ''} value = "1">20CNTT</option>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>Year</td>--%>
<%--            <td>--%>
<%--                <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name = "student_year_id">--%>
<%--                    <option selected>Open this select menu</option>--%>
<%--                    <option ${student.student_year_id == 1 ? 'selected' : ''} value = "1">2022-2023</option>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Status</td>--%>
<%--            <td>--%>
<%--                <input type = "radio" name = "student_status" value = "Chua nop">Chua nop--%>
<%--                <input type = "radio" name = "student_status" value = "Da nop">Da nop--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan="2">--%>
<%--                <input type = "submit" value = "Register">--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <input type = "hidden" name = "action" value= "create"/>--%>
<%--</form>--%>
<%--</form>--%>

<div class = "addForm" style = "border: 3px solid #270082; background-color: azure; height: 520px; margin-top: 50px">
    <h3>Thêm mới sinh viên</h3>
    <form action = "${pageContext.request.contextPath}/student" method = "post">

        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px; margin-top: 20px">
            <span class="input-group-text" id="basic-addon1" style="background-color: #270082; color: white">Mã sinh viên</span>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name = "student_code">
        </div>

        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px; margin-top: 10px">
            <span class="input-group-text" id="basic-addon2" style="background-color: #270082; color: white">Họ và tên</span>
            <input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="basic-addon2" name = "studentName">
        </div>

        <div class="input-group mb-3" style="width: 90%; float: left; margin-left: 40px; margin-top: 10px">
            <span class="input-group-text" id="basic-addon3" style="background-color: #270082; color: white">Ngày sinh</span>
            <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" name = "student_birthday">
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
            <div class="form-check form-check-inline" style="margin-top: 10px; margin-left: 20px">
                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                <label class="form-check-label" for="inlineRadio1">Đã nộp</label>
            </div>

            <div class="form-check form-check-inline" style="margin-top: 10px;">
                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                <label class="form-check-label" for="inlineRadio2">Chưa nộp</label>
            </div>
        </div>

        <div>
            <td colspan="2">
                <input class="btn btn-primary" style = "float: right; margin-right: 90px; margin-top: 3px" type = "submit" value = "Thêm mới">
                <a style = "float: right; margin-right: 20px" href="${pageContext.request.contextPath}/student"><span>Trở về</span><i></i></a>
            </td>
        </div>
        <input type = "hidden" name = "action" value= "create"/>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>