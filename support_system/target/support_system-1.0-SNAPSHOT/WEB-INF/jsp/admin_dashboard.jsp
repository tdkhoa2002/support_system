<%-- 
    Document   : index
    Created on : Aug 1, 2023, 2:52:05 AM
    Author     : Khoa Tran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Admin page</h1>
<button><a href=" <c:url value="/admin/articles" /> ">Tin tuyển sinh</a></button>
<button><a href=" <c:url value="/admin/categories" /> ">Hình thức tuyển sinh</a></button>
<button><a href=" <c:url value="/admin/faculties" /> ">Thông tin các khoa</a></button>
<button><a href=" <c:url value="/admin/scores" /> ">Tổng hợp điểm trúng tuyển các năm</a></button>
<button><a href=" <c:url value="/admin/livestreams" /> ">Quản lý livestreams</a></button>

