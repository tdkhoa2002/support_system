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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Đăng ký tài khoản</h1>
<c:url value="/register" var="action"/>
<form:form action="${action}" modelAttribute="user" method="POST" enctype="multipart/form-data">
    <label for="username">Username: </label>
    <form:input path="username" id="username" />
    <label for="password">Password: </label>
    <form:password path="password" id="password" />
    
    <label for="email">Email: </label>
    <form:input path="email" id="email" />

    <label for="file">Ảnh sản phẩm</label>
    <form:input type="file" path="file" id="file"  />

    <input type="submit" />
</form:form>
