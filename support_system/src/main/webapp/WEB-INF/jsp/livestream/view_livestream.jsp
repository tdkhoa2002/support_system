<%-- 
    Document   : view_livestream
    Created on : Aug 10, 2023, 3:31:38 PM
    Author     : Khoa Tran
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Tổng hợp các câu hỏi của livestream</h1>

<h3>${livestream.title}</h3>
<table class="table">
    <thead>
        <tr>
            <th>STT</th>
            <th>Họ tên</th>
            <th>Câu hỏi</th>
            <th>Thời gian</th>
            <th>Handle</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${questions}" var="question">
            <tr class="table-primary">
                <td>${question.id}</td>
                <td>${question.userId.username}</td>
                <td>${question.content}</td>
                <td>${question.dateSubmitted}</td>
                <td>
                    <c:url value="/api/delete_question/${question.id}/" var="api" />
                    <button type="button" class="btn btn-danger" onclick="deleteObject('${api}')">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>
