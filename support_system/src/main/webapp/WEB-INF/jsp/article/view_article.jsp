<%-- 
    Document   : view_article
    Created on : Aug 3, 2023, 10:32:15 AM
    Author     : Khoa Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view_article/${article.id}/comment_article" var="action" />
<h1>${article.title}</h1>
<p>${article.content}</p>
<div>
    <h3>Ý kiến</h3>
    <div>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href=" <c:url value="/login"/> ">Đăng nhập để bình luận</a>
        </c:if>
        <form method="POST" action="${action}" modelAttribute="comment">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <textarea name="content" id="txtComment" placeholder="Chia sẻ ý kiến của bạn"></textarea>
            </c:if>
            <button type="submit">Gửi</button>
        </form>
    </div>
    <div>
        <c:forEach items="${comments}" var="comment">
            <div>
                <p>${comment.content}</p>
                <c:if test="${pageContext.request.userPrincipal.name == comment.userId.username}">
                    <c:url value="/delete_comment/${comment.id}" var="api_delete" />
                    <button type="button" class="btn btn-danger" onclick="deleteComment('${api_delete}')">Xóa</button>
                </c:if>
            </div>
        </c:forEach>
    </div>
</div>
<script src="<c:url value="/js/main.js" />"></script>
