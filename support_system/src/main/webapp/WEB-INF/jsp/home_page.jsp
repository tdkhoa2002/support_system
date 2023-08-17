<%-- 
    Document   : home_page
    Created on : Jul 31, 2023, 7:03:19 PM
    Author     : Khoa Tran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Trang chủ!</h1>
<c:if test="${currentUser.roleName == 'ADMIN'}">
    <div>
        <a href=" <c:url value="/admin"/>  ">Trang chủ admin</a>
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div>
        Bạn không có quyền truy cập
    </div>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name == null}">
    <li>
        <a href=" <c:url value="/login"/> ">Đăng nhập</a>
    </li>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <li>
        <a href="/">${ pageContext.request.userPrincipal.name }</a>
    </li>
    <li>
        <a href=" <c:url value="/logout"/> ">Đăng xuất</a>
    </li>
</c:if>
<h1>Livestreams</h1>
<c:forEach items="${livestreams}" var="livestream">
    <div>
        <h3>${livestream.title}</h3>
    </div>
    <div>
        <button type="button" onclick="makeQuestion(${livestream.id})">Đặt câu hỏi</button>
    </div>
    <div id="questionInput" style="display: none;">
        <c:url value="/send_question" var="send_question"/>
        <form method="POST" action="${send_question}" modalAttribute="question">
            <input type="text" id="question" placeholder="Nhập câu hỏi của bạn" name="content">
            <%--<form:hidden path="livestreamId" value="${livestream}" />--%>
            <input type="hidden" name="liveId" value="${livestream.id}">
            <button type="submit" id="submitQuestion"> Gửi câu hỏi </button>
        </form>
    </div>
</c:forEach>

</body>
</html>
<script src="<c:url value="/js/main.js" />"></script>
