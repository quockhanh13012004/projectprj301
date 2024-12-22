<%-- 
    Document   : headerDashBoard
    Created on : Jul 13, 2024, 9:32:54 AM
    Author     : TNO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="admin-header">
    <nav class="admin-nav">
        <div class="admin-nav__logo">
            <a href="index.jsp"><img src="${pageContext.request.contextPath}/img/logo-white.png" alt="Burger House Logo"></a>
        </div>
        <ul class="admin-nav__links">
            <li><a href="home">HOME</a></li>
        </ul>
        <c:if test="${sessionScope.accAccess == null}">
            <ul class="admin-nav__links">
                <li><a href="login">LOGIN</a></li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.accAccess != null}">
            <ul class="admin-nav__links">
                <li><a href="logout">LOGOUT</a></li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.accAccess.roleID == 2}">
            <ul class="admin-nav__links">
                <li><a href="pageStaffMenu">Create Order</a></li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.accAccess.roleID == 3}">
            <ul class="admin-nav__links">
                <li><a href="dashBoard">Dash Board</a></li>
            </ul>
        </c:if>

    </nav>
</header>
