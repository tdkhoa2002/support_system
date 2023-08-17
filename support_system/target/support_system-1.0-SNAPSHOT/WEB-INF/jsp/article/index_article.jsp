<%-- 
    Document   : index_article
    Created on : Aug 1, 2023, 2:55:15 AM
    Author     : Khoa Tran
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<button><a href=" <c:url value="/admin/create_article" /> ">Thêm tin tuyển sinh</a></button>
<table class="table">
    <thead>
        <tr>
            <th>STT</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Ngày đăng</th>
            <th>Thông tin tuyển sinh</th>
            <th>Khoa</th>
            <th>Handle</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach  items="${articles}" var="article">
            <tr class="table-primary">
                <td>${ article.id }</td>
                <td>${ article.title }</td>
                <td>${ article.content }</td>
                <td>${ article.date }</td>
                <td>${ article.categoryId.name }</td>
                <td>${ article.facultyId.name }</td>
                <td>
                    <button type="button" class="btn btn-primary"> <a href=" <c:url value="/view_article/${article.id}"/> ">Xem</a> </button>
                    <button type="button" class="btn btn-success"> <a href=" <c:url value="/admin/edit_article/${article.id}"/> ">Sửa</a> </button>
                    <c:url value="/api/delete_article/${article.id}/" var="api" />
                    <button type="button" class="btn btn-danger" onclick="deleteObject('${api}')">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>


