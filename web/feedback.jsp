<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Feedback</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
</head>
<body>
    <header class="admin-header">
        <nav class="admin-nav">
            <div class="admin-nav__logo">
                <a href="index.jsp"><img src="${pageContext.request.contextPath}/img/logo-white.png" alt="Burger House Logo"></a>
            </div>
            <ul class="admin-nav__links">
                <li><a href="admin.jsp">Dashboard</a></li>
                <li><a href="MenuAdminServlet">Menu</a></li>
                <li><a href="OrderAdminServlet">Orders</a></li>
            </ul>
        </nav>
    </header>

    <main class="admin-main">
        <h1>Customer Feedback</h1>
        <table>
            <thead>
                <tr>
                    <th>Feedback</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="feedback" items="${feedbackList}">
                    <tr>
                        <td>${feedback}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>

    <footer class="admin-footer">
        <p>&copy; 2024 Burger House. All rights reserved.</p>
    </footer>
</body>
</html>
