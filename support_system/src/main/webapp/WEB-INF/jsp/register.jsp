<%--
  Created by IntelliJ IDEA.
  User: Khoa Tran
  Date: 7/12/2023
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Đăng ký</title>
    </head>
    <body>
        <h1>Đăng ký tài khoản</h1>
        <c:url value="/register" var="action"/>
        <form:form action="${action}" modelAttribute="user" method="POST" >
            <div>
                <label>Username: </label>
                <form:input path="username" />
            </div>
            <div>
                <label>Password: </label>
                <form:input path="password" />
            </div>
            <div>
                <label>Avatar: </label>
                <form:input type="file" path="file" />
            </div>
            <button type="submit">Submit</button>
        </form:form>
    </body>
</html>
