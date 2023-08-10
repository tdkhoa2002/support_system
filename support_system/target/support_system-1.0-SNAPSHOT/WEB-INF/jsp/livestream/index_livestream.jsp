<%-- 
    Document   : index_livestream
    Created on : Aug 9, 2023, 10:50:12 PM
    Author     : Khoa Tran
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<button><a href=" <c:url value="/admin/create_livestream" /> ">Tạo lịch livestream</a></button>

<table class="table">
    <thead>
        <tr>
            <th>STT</th>
            <th>Tiêu đề</th>
            <th>Ngày</th>
            <th>Thời gian</th>
            <th>Thumbnail</th>
            <th>Khoa</th>
            <th>Handle</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach  items="${livestreams}" var="livestream">
            <tr class="table-primary">
                <td>${ livestream.id }</td>
                <td>${ livestream.title }</td>
                <td>${ livestream.date }</td>
                <td>${ livestream.time }</td>
                <td> <img width="50px" src="${ livestream.thumbnail }" alt="alt"/></td>
                <td>${ livestream.facultyId.name }</td>
                <td>
                    <button type="button" class="btn btn-primary"> <a style="color: white;" href=" <c:url value="/admin/view_livestream/${livestream.id}"/> ">Xem các câu hỏi</a> </button>
                    <button type="button" class="btn btn-success"> <a href=" <c:url value="/admin/edit_livestream/${livestream.id}"/> ">Sửa thông tin</a> </button>
                    <c:url value="/delete_article/${article.id}" var="api" />
                    <button type="button" class="btn btn-danger" onclick="deleteArticle('${api}')">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
