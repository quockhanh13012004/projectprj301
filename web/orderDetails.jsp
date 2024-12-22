<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Manage Menu</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
        <script src="${pageContext.request.contextPath}/js/admin.js" defer></script>
        <style>
            .table-textarea {
                width: 700px;
                padding: 0.5rem;
                margin-bottom: 1rem;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="headerDashBoard.jsp"/>F

        <main class="admin-main">
            <h2>Order Details</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="listOrderDetails" items="${listOrderDetails}">
                        <tr>
                            <td>${listOrderDetails.orderDetailsID}</td>
                            <td>${listOrderDetails.dishName}</td>
                            <td>${listOrderDetails.price}</td>
                            <td>
                                ${listOrderDetails.quantity}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                
                <form action="manageOrder">
                    <input type="submit" value="Back" />
                </form>
            </table>
        </main>

        <footer class="admin-footer">
            <p>&copy; 2024 Burger House. All rights reserved.</p>
        </footer>
    </body>

    <script>
    </script>
</html>
