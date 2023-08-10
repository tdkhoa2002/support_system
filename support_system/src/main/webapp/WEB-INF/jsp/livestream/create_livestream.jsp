<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url value="/admin/create_livestream" var="action" />
<%--<c:set var="user" value="${sessionScope.currentUser}"/>--%>
<form:form method="POST" modelAttribute="livestream" action="${action}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <label for="title">Tiêu đề: </label>
    <form:input path="title" id="title" />
    <label for="date">Chọn ngày: </label>
    <input type="datetime-local" id="date" name="date">
    <label>Chọn khoa: </label>
    <form:select id="faculty" name="faculty" path="facultyId">
        <c:forEach items="${faculties}" var="faculty">
            <c:choose>
                <c:when test="${faculty.id == livestream.facultyId.id}"><option value="${faculty.id}" selected>${faculty.name}</option></c:when>
                <c:otherwise><option value="${faculty.id}">${faculty.name}</option></c:otherwise>
            </c:choose>
        </c:forEach>
    </form:select>
    <label for="file">Ảnh thumbnail: </label>
    <form:hidden path="thumbnail"/>
    <form:input type="file" path="file" id="file" />
    <button type="submit">Tạo</button>
</form:form>