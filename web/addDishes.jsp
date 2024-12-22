<%-- 
    Document   : addDishes
    Created on : Jul 12, 2024, 11:37:53 PM
    Author     : TNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Add Dish</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
        <script src="${pageContext.request.contextPath}/js/admin.js" defer></script>
        <style>
            .input-field {
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
            <h1>Add Dishes</h1>
            <h4 style="color: red">${msgError}</h4>

            <form action="AddDish" method="post" enctype="multipart/form-data">
                <input type="hidden" name="action" value="add">
                <input type="text" name="name" placeholder="name" required class="input-field"><br/>
                <textarea name="description" placeholder="description" required class="input-field" rows="4"></textarea><br/>
                <input type="number" step="0.01" name="price" placeholder="Price" required class="input-field"><br/>
                <input type="file" name="image" accept="image/*" required class="input-field"><br/>
                <select name="status" required class="input-field">
                    <option value="">Select Status</option>
                    <option value="1">Available</option>
                    <option value="0">Unavailable</option>
                </select><br/>
                <button type="submit" class="btn">Add</button>
            </form>
        </main>

        <footer class="admin-footer">
            <p>&copy; 2024 Burger House. All rights reserved.</p>
        </footer>
    </body>
</html>
