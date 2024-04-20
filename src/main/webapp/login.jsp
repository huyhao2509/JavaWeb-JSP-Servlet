<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styleLogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
<div class="container">
    <div class="wrapper">
        <div class="title"><span>Đăng nhập</span></div>
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" name="userName" placeholder="Tên đăng nhập" value= "${user.userName}" />
            </div>
            <div class="row">
                <i class="fas fa-lock"></i>
                <input type="password" name="password" placeholder="Mật khẩu" value= "${user.password}" />
            </div>
            <div class="row button" style="margin-top: 10px">
                <input type="submit" value="Đăng nhập">
            </div>
            <p style="text-align: center; color: red">${errorString}</p>
        </form>
    </div>
</div>
</body>
</html>
