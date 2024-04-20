<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<h1>Search Student</h1>
<a href= "${pageContext.request.contextPath}/student?action=list">Back to list</a>
<table border = "1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${studentList}" var = "studentList">
        <tr>
            <td>${studentList.studentCode}</td>
            <td>${studentList.studentName}</td>
            <td>${studentList.studentBirthday}</td>
            <td>${studentList.studentStatus}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>