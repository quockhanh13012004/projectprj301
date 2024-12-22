<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Order Status</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/status.css">
        <script src="${pageContext.request.contextPath}/js/admin.js" defer></script>
    </head>
    <body>
        <header class="admin-header">
            <nav class="nav">
                <div class="nav__logo">
                    <a href="index.jsp"><img src="${pageContext.request.contextPath}/img/logo-dark.png" alt="Burger House Logo"></a>
                </div>
                <ul class="nav__links">
                    <li><a href="index.jsp">Home</a></li>
                    <!--            <li><a href="menu.jsp">Menu</a></li>
                                    <li><a href="contact.jsp">Contact Us</a></li>
                                    <li><a href="status.jsp">Status</a></li>-->
                </ul>
            </nav>
        </header>

        <main class="admin-main">
            <h1>Order Status</h1>
            <form action="trackingOrder" method="POST">
                <input type="number" name="tableNum" placeholder="Table Number" required class="table-textarea"><br/>
                <button type="submit" class="cs-btn">Check Status</button>
            </form>

            <c:if test="${not empty listOrder}">
                <h2>Your Orders</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Name Customer</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listOrder" items="${listOrder}">
                            <tr>
                                <td>${listOrder.orderID}</td>
                                <td>${listOrder.nameCustomer}</td>
                                <td>${listOrder.totalAmount}</td>
                                <c:if test="${listOrder.status == 1}">
                                    <td> Progress</td>
                                </c:if>
                                <c:if test="${listOrder.status == 2}">
                                    <td> Delay</td>
                                </c:if>
                                <c:if test="${listOrder.status == 3}">
                                    <td>Done</td>
                                </c:if>
                                    <td>
                                        <a href="requestDelay?idOrder=${listOrder.orderID}">send request order delay</a>
                                    </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <h3 style="color: red">${msg}</h3>

        </main>

        <footer class="admin-footer">
            <p>&copy; 2024 Burger House. All rights reserved.</p>
        </footer>
    </body>
</html>
