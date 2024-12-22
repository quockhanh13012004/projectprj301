<%-- 
    Document   : pageAddUser
    Created on : Jul 13, 2024, 2:45:12 PM
    Author     : TNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>View Orders</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
        <script src="${pageContext.request.contextPath}/js/admin.js" defer></script>
    </head>
    <body>
        <jsp:include page="headerDashBoard.jsp"/>

        <main class="admin-main">
            <h1>View Details User</h1>
            <h4 style="color: red">${msg}</h4>

            <!-- Add Staff Form -->
            <form action="updateUser" method="post" class="add-staff-form" style="margin-bottom: 20px; display: flex; flex-direction: column; gap: 10px;">
                <label for="username">Username:</label>
                <input value="${user.username}" disabled type="text" id="username" name="username" required>

                <label for="password">Password:</label>
                <input value="${user.password}"  disabled= type="password" id="password" name="password" required>

                <label for="email">Email:</label>
                <input value="${user.email}" type="email" id="email" name="email" required>

                <label for="fullName">Full Name:</label>
                <input value="${user.fullName}" type="text" id="fullName" name="fullName" required>

                <label for="phoneNumber">Phone Number:</label>
                <input value="${user.phoneNumber}" type="text" id="phoneNumber" name="phoneNumber" required>

                <label for="address">Address:</label>
                <input value="${user.address}" type="text" id="address" name="address" required>

                <label for="role">Role:</label>
                <select id="role" name="role" required>
                    <option ${user.roleID == 1 ? 'selected' : ""} value="1">User</option>
                    <option ${user.roleID == 2 ? 'selected' : ""} value="2">Staff</option>
                    <option ${user.roleID == 3 ? 'selected' : ""} value="3">Admin</option>
                </select>
                
                    <input style="display: none" value="${user.userID}" type="text" name="idUser" required>
                <button type="submit" class="btn" style="padding: 5px 10px;">Update</button>
            </form>
            <form action="manageUsers" method="GET">
                <button type="submit" class="btn" style="padding: 5px 10px;">Back</button>
            </form>
        </main>

        <footer class="admin-footer">
            <p>&copy; 2024 Burger House. All rights reserved.</p>
        </footer>
    </body>
</html>