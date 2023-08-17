<%-- 
    Document   : index_faculty
    Created on : Aug 7, 2023, 2:37:28 PM
    Author     : Khoa Tran
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<button><a href=" <c:url value="/admin/create_faculty" /> ">Thêm khoa</a></button>
<table class="table">
    <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Mô tả</th>
            <th>Link website</th>
            <th>Link video</th>
            <th>Handle</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach  items="${faculties}" var="faculty">
            <tr class="table-primary">
                <td>${ faculty.id }</td>
                <td>${ faculty.name }</td>
                <td>${ faculty.description }</td>
                <td>${ faculty.websiteUrl }</td>
                <td>${ faculty.videoUrl }</td>
                <td>
                    <button type="button" class="btn btn-primary"> <a href=" <c:url value="/api/articles/faculty/${faculty.id}"/> ">Xem</a> </button>
                    <button type="button" class="btn btn-success"> <a href=" <c:url value="/admin/edit_faculty/${faculty.id}"/> ">Sửa</a> </button>
                    <c:url value="/api/delete_faculty/${faculty.id}/" var="api" />
                    <button type="button" class="btn btn-danger" onclick="deleteObject('${api}')">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>
