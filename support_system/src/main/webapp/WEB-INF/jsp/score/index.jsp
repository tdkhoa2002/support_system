<%-- 
    Document   : index
    Created on : Aug 7, 2023, 8:29:19 PM
    Author     : Khoa Tran
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<button><a href=" <c:url value="/admin/create_score" /> ">Thêm điểm</a></button>
<c:forEach items="${categories}" var="category">
    <h1>${category.name}</h1>
    <table class="table">
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên ngành</th>
                    <c:forEach var="i" begin = "0" end ="4">
                    <th>${yearNow - i}</th>
                    </c:forEach>
            </tr>
        </thead>
        <tbody>
            <c:forEach  items="${faculties}" var="faculty">
                <tr class="table-primary">
                    <td>${ faculty.id }</td>
                    <td>${ faculty.name }</td>
                    <c:set var="shouldBreak" value="false" />

                    <c:forEach var="i" begin="0" end="4">
                        <c:forEach items="${scores}" var="score">
                            <c:choose>
                                <c:when test="${!shouldBreak && score.categoryId.id == category.id && score.facultyId.id == faculty.id && score.year == yearNow - i}">
                                    <td>${score.score}</td>
                                    <c:set var="shouldBreak" value="true" />
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${loop.last && shouldBreak == true}">
                                        <td>-/-</td>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:forEach>
                    <td>
                        <button type="button" class="btn btn-primary"> <a href=" <c:url value="/view_article/${article.id}"/> ">Xem</a> </button>
                        <button type="button" class="btn btn-success"> <a href=" <c:url value="/admin/edit_article/${article.id}"/> ">Sửa</a> </button>
                        <c:url value="/delete_article/${article.id}" var="api" />
                        <button type="button" class="btn btn-danger" onclick="deleteArticle('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:forEach>
<script src="<c:url value="/js/main.js" />"></script>
