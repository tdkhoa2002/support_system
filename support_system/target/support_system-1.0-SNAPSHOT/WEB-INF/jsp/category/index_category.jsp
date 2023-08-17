<%-- 
    Document   : index_category
    Created on : Aug 10, 2023, 3:49:03 PM
    Author     : Khoa Tran
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<button><a href=" <c:url value="/admin/create_category" /> ">Thêm hình thức tuyển sinh</a></button>
<table class="table">
    <thead>
        <tr>
            <th>STT</th>
            <th>Hình thức</th>
            <th>Handle</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach  items="${categories}" var="category">
            <tr class="table-primary">
                <td>${ category.id }</td>
                <td>${ category.name }</td>
                <td>
                    <button type="button" class="btn btn-primary"> <a href=" <c:url value="/view_category/${category.id}"/> ">Xem</a> </button>
                    <button type="button" class="btn btn-success"> <a href=" <c:url value="/admin/edit_category/${category.id}"/> ">Sửa</a> </button>
                    <c:url value="/api/delete_category/${category.id}/" var="api" />
                    <button type="button" class="btn btn-danger" onclick="deleteObject('${api}')">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>
