<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Map"%>
<%@page import="model.MenuItem"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Admin Manage Menu</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
        <script src="${pageContext.request.contextPath}/js/admin.js" defer></script>
        <style>
            .textarea {
                width: 700px;
                padding: 0.5rem;
                margin-bottom: 1rem;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
        </style>
    </head>

    <body>

        <jsp:include page="headerDashBoard.jsp"/>

        <main class="admin-main">
            <h1>Manage Menu</h1>
            <form action="AddDish" method="GET">
                <input type="submit" value="Add Dish" />
            </form>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach  items="${listDishes}" var="listDishes">
                        <tr>
                            <td>${listDishes.idDishes}</td>
                            <td style="width: 150px">
                                <img src="${listDishes.image}" width="100px" alt="alt"/>
                            </td>
                            <td>${listDishes.name}</td>
                            <td>${listDishes.description}</td>
                            <td>${listDishes.price}</td>
                            <td>
                                <form action="detailsDish" method="GET" style="display: flex; justify-content: center; gap: 5px; margin: 0; padding: 0;">
                                    <input type="hidden" name="dishID" value="${listDishes.idDishes}">
                                    <button type="submit" class="btn" action="delete" style="padding: 5px 10px; margin: 0;">View</button>
                                </form>

                                <form action="deleteDish" method="post" style="display: flex; justify-content: center; gap: 5px; margin: 0; padding: 0;">
                                    <input type="hidden" name="idDish" value="${listDishes.idDishes}">
                                    <button type="submit" class="btn" action="delete" style="padding: 5px 10px; margin: 0;">Delete</button>
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
