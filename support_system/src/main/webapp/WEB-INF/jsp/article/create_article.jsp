<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url value="/create_article" var="action" />
<%--<c:set var="user" value="${sessionScope.currentUser}"/>--%>

<form:form method="POST" modelAttribute="article" action="${action}" enctype="multipart/form-data">
    <div class="form-group">
        <label for="usernameId">Nội dung: </label>
        <input name="content" id="contentId" class="form-control" />
    </div>
    <div class="form-group">
        <label for="date">Ngày đăng: </label>
        <input type="date" id="dateId" name="date" class="form-control"  />
    </div>
    <div class="form-group">
        <input type="submit"/>
    </div> 
</form:form>