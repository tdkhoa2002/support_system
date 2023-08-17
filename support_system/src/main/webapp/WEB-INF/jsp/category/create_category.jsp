<%-- 
    Document   : create_category
    Created on : Jul 31, 2023, 8:41:38 PM
    Author     : Khoa Tran
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Tạo thông tin tuyển sinh</h1>
<c:url value="/api/create_category/" var="action"/>
<form:form action="${action}" modelAttribute="category" method="POST">
    <form:hidden path="id"/>
    <label for="name">Tên:  </label>
    <form:input path="name" id="name" />
    <input type="submit" />
</form:form>
