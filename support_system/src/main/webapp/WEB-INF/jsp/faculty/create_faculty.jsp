<%-- 
    Document   : create_faculty
    Created on : Aug 1, 2023, 3:48:52 AM
    Author     : Khoa Tran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url value="/admin/create_faculty" var="action" />

<form:form method="POST" modelAttribute="faculty" action="${action}">
    <form:hidden path="id"/>
    <label for="name">Tên khoa: </label>
    <form:input path="name" id="name" />
    <label for="description">Lời giới thiệu: </label>
    <form:input path="description" id="description" />
    <label for="websiteUrl">Link website: </label>
    <form:input path="websiteUrl" id="websiteUrl" />
    <label for="videoUrl">Link video: </label>
    <form:input path="videoUrl" id="videoUrl" />
    <input type="submit" />
</form:form>