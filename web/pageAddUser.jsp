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
            <h1>Add User</h1>
            <h4 style="color: red">${msg}</h4>

            <!-- Add Staff Form -->
            <form action="addUser" method="post" class="add-staff-form" style="margin-bottom: 20px; display: flex; flex-direction: column; gap: 10px;">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" required>

                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" required>

                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>

                <label for="role">Role:</label>
                <select id="role" name="role" required>
                    <option value="1">User</option>
                    <option value="2">Staff</option>
                    <option value="3">Admin</option>
                </select>

                <button type="submit" class="btn" style="padding: 5px 10px;">Add Staff</button>
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