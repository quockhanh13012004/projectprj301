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
        <title>Dish Details</title>
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
            <h1>Details Dish</h1>
            <form action="updateDish" method="post" enctype="multipart/form-data">
                <input type="hidden" name="idDish" value="${dish.idDishes}">
                <input type="text" value="${dish.name}" name="name" placeholder="name" required class="input-field"><br/>
                <textarea name="description" placeholder="description" required class="input-field" rows="4">${dish.description}</textarea><br/>
                <input type="number" value="${dish.price}" step="0.01" name="price" placeholder="Price" required class="input-field"><br/>
                <input type="file" name="image" accept="image/*" class="input-field"><br/>
                <div class="preview" style="display: block;">
                    <img style="width: 250px" src="${dish.image}" alt="Image Preview">
                </div>
                <select name="status" required class="input-field">
                    <option value="">Select Status</option>
                    <option ${dish.status == 1 ? 'selected' : ""} value="1">Available</option>
                    <option ${dish.status == 0 ? 'selected' : ""} value="0">Unavailable</option>
                </select><br/>
                <button type="submit" class="btn">Update</button>
            </form>
            <form action="manageMenu">
                <button type="submit" class="btn">Back</button>
            </form>
        </main>

        <footer class="admin-footer">
            <p>&copy; 2024 Burger House. All rights reserved.</p>
        </footer>
    </body>
</html>
