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
            <h1>View Orders</h1>

            <!-- Search Form -->
            <form action="manageOrder" method="get" class="search-form" style="margin-bottom: 20px; display: flex; gap: 10px;">
                <select name="statusFilter" style="padding: 5px;">
                    <option value="0">All Statuses</option>
                    <option value="1">Progress</option>
                    <option value="2">Delay</option>
                    <option value="3">Done</option>
                </select>

                <button name="action" value="status" type="submit" class="btn" style="padding: 5px 10px;">Filter</button>
            </form>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Customer Name</th>
                        <th>Order Date</th>
                        <th>Number of table</th>
                        <th>Total</th>
                        <th>Created By</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="listOrder" items="${listOrder}">
                        <tr>
                            <td style="text-align: center">${listOrder.orderID}</td>
                            <td style="text-align: center">${listOrder.nameCustomer}</td>
                            <td style="text-align: center" >${listOrder.orderDate}</td>
                            <td>${listOrder.tableNum}</td>
                            <td>${listOrder.totalAmount}$</td>
                            <td>${listOrder.nameStaff}</td>
                            <c:if test="${listOrder.status == 1}">
                                <td>Progress</td>
                            </c:if>
                            <c:if test="${listOrder.status == 2}">
                                <td>Delay</td>
                            </c:if>
                            <c:if test="${listOrder.status == 3}">
                                <td>Done</td>
                            </c:if>
                            <td>
                                <form action="pageOrderDetails" method="GET" style="display: flex; justify-content: center; gap: 5px; margin: 0; padding: 0;">
                                    <input type="hidden" name="idOrder" value="${listOrder.orderID}">
                                    <button type="submit" class="btn" style="padding: 5px 10px; margin: 0;">View</button>
                                </form>

                                <form action="DoneOrder" method="post" style="display: flex; justify-content: center; gap: 5px; margin: 0; padding: 0;">
                                    <input type="hidden" name="orderID" value="${listOrder.orderID}">
                                    <button type="submit" class="btn" style="padding: 5px 10px; margin: 0;">Done</button>
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
