<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Admin Dashboard</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    </head>
    <body>
        <jsp:include page="headerDashBoard.jsp"/>

        <main class="admin-main">
            <div class="admin-dashboard">
                <h1>Admin Dashboard</h1>
                <div class="admin-dashboard__cards">
                    <div class="admin-dashboard__card">
                        <h2>
                            <a href="manageMenu">Manage Menu</a>
                        </h2>
                        <p>1</p>
                    </div>
                    <div class="admin-dashboard__card">
                        <h2>
                            <a href="manageOrder">Manage Order</a>
                        </h2>
                        <p>1</p>
                    </div>
                    <div class="admin-dashboard__card">
                        <h2>
                            <a href="manageUsers">Manage User</a>
                        </h2>
                        <p>1</p>
                    </div>
                </div>
            </div>
        </main>

        <footer class="admin-footer">
            <p>&copy; 2024 Burger House. All rights reserved.</p>
        </footer>
    </body>
</html>
