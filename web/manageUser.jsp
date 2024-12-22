

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
            <h1>View User</h1>

            <!-- Search Form -->
            <form action="addUser" method="get" class="search-form" style="margin-bottom: 20px; display: flex; gap: 10px;">
                <button type="submit" class="btn" style="padding: 5px 10px;">Add User</button>
            </form>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Customer Name</th>
                        <th>Email</th>  
                        <th>Phone Number</th>
                        <th>Address</th>
                        <th>Role</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="listUser" items="${listUser}">
                        <tr>
                            <td style="text-align: center">${listUser.userID}</td>
                            <td style="text-align: center">${listUser.fullName}</td>
                            <td style="text-align: center" >${listUser.email}</td>
                            <td>${listUser.phoneNumber}</td>
                            <td>${listUser.address}</td>
                            <c:if test="${listUser.roleID == 1}">
                                <td>User</td>
                            </c:if>
                            <c:if test="${listUser.roleID == 2}">
                                <td>Staff</td>
                            </c:if>
                            <c:if test="${listUser.roleID == 3}">
                                <td>Admin</td>
                            </c:if>
                            <td>
                                <form action="detailsUser" method="GET" style="display: flex; justify-content: center; gap: 5px; margin: 0; padding: 0;">
                                    <input type="hidden" name="idUser" value="${listUser.userID}">
                                    <button type="submit" class="btn" style="padding: 5px 10px; margin: 0;">View</button>
                                </form>

                                <form action="deleteUser" method="post" style="display: flex; justify-content: center; gap: 5px; margin: 0; padding: 0;">
                                    <input type="hidden" name="orderID" value="${listOrder.orderID}">
                                    <button type="submit" class="btn" style="padding: 5px 10px; margin: 0;">Delete</button>
                                </form>
                            </td>
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

