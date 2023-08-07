<%-- 
    Document   : home_page
    Created on : Jul 31, 2023, 7:03:19 PM
    Author     : Khoa Tran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Trang chủ!</h1>
<sec:authorize access=" hasRole('ADMIN') ">
    <div>
        <a href=" <c:url value="/admin"/>  ">Admin page</a>
    </div>
</sec:authorize>
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
<button>
    <a href="create_category">Thêm thông tin tuyển sinh</a>
</button>
</body>
</html>
