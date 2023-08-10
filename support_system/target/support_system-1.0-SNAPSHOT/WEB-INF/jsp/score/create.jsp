<%-- 
    Document   : create
    Created on : Aug 7, 2023, 9:05:44 PM
    Author     : Khoa Tran
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value = "/admin/create_score" var="action"/>
<form:form method="POST" modelAttribute="score" action="${action}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <label>Chọn khoa: </label>
    <form:select id="faculty" name="faculty" path="facultyId">
        <c:forEach items="${faculties}" var="faculty">
            <c:choose>
                <c:when test="${faculty.id == score.facultyId.id}"><option value="${faculty.id}" selected>${faculty.name}</option></c:when>
                <c:otherwise><option value="${faculty.id}">${faculty.name}</option></c:otherwise>
            </c:choose>
        </c:forEach>
    </form:select>

    <label>Chọn thông tin tuyển sinh: </label>
    <form:select id="cate" name="cate" path="categoryId">
        <c:forEach items="${categories}" var="c">
            <c:choose>
                <c:when test="${c.id == score.categoryId.id}"><option value="${c.id}" selected>${c.name}</option></c:when>
                <c:otherwise><option value="${c.id}">${c.name}</option></c:otherwise>
            </c:choose>
        </c:forEach>
    </form:select>
    <div>
        <label>Chọn năm: </label>
        <input type="number" placeholder="YYYY" min="1999" max="9999" name="yearPicked">
    </div>
    <div>
        <label>Nhập điểm: </label>
        <input type="number" name="score" min="0">
    </div>

    <input type="submit" />
</form:form>
<script src="<c:url value="/js/main.js" />"></script>
