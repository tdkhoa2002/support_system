<%--
  Created by IntelliJ IDEA.
  User: Khoa Tran
  Date: 7/12/2023
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
    <h1>Đăng ký tài khoản</h1>
    <form:form method="POST">
        <div>
            <label>Tên đăng nhập: </label>
            <input type="text" name="username" placeholder="Tên đăng nhập">
        </div>
        <div>
            <label>Mật khẩu: </label>
            <input type="password" name="password" placeholder="Mật khẩu" max="16">
        </div>
        <div>
            <label>Xác nhận mật khẩu: </label>
            <input type="password" name="confirmPassword" placeholder="Xác nhận mật khẩu" max="16">
        </div>
        <div>
            <label>Email: </label>
            <input type="email" name="email" placeholder="Email">
        </div>
        <button type="submit">Đăng ký</button>
    </form:form>
    <p>${ message }</p>
</body>
</html>
