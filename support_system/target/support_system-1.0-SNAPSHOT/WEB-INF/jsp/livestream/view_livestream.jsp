<%-- 
    Document   : view_livestream
    Created on : Aug 10, 2023, 3:31:38 PM
    Author     : Khoa Tran
--%>

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
            <td>${question.id}</td>
            <td>${question.userId.name}</td>
            <td>${question.content}</td>
            <td>${question.dateSubmitted}</td>
        </c:forEach>
</tbody>
</table>
