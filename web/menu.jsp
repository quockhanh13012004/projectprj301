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
        <jsp:include page="headerDashBoard.jsp"/>

        <main class="admin-main">
            <h1>Add Items</h1>
            <form action="addItems" method="post">
                <!-- Dropdown menu for selecting category/type -->
                <select name="dishesID" required class="table-textarea">
                    <option value="" disabled selected>Select Dishes</option>
                    <c:forEach items="${listDishes}" var="listDishes">
                        <option value="${listDishes.idDishes}">${listDishes.name}</option>
                    </c:forEach>

                    <!-- Add more options as needed -->
                </select><br/>

                <!-- Input field for quantity -->
                <input min="0" type="number" name="quantity" placeholder="quantity" required class="table-textarea"><br/>

                <button type="submit" class="btn">Add Item</button>
            </form>
            <h2>Menu Items</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="listItemDishes" items="${listItemDishes}">
                        <tr>
                            <td>${listItemDishes.id}</td>
                            <td>${listItemDishes.name}</td>
                            <td>${listItemDishes.price}</td>
                            <td>
                                <input type="number" data-id="${listItemDishes.quantity}" name="quantityItems" value="${listItemDishes.quantity}" min="1" required>
                            </td>
                            <td>${listItemDishes.total}</td>
                            <td>
                                <a href="removeItems?idDishes=${listItemDishes.id}" class="btn">Delete</a >
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form id="updateForm" action="updateItems" method="POST">
                <input style="display: none"type="text" name="arrtayQuantity" value="" />
                <button type="submit" class="btn">Update All</button>
            </form>
            <div>
                <h3>Total Price: <span id="totalPrice">${totalAllItems}$</span></h3>
            </div>
            <h2>Create Order</h2>
            <form action="createOrder" method="post">
                <input type="text" name="nameCustomer" placeholder="Customer Name" required><br>
                <input type="text" name="phoneNum" placeholder="Phone Number"><br>
                <input type="text" name="tableNum" placeholder="Table Number"><br>
                <button type="submit" class="btn">Create Order</button>
            </form>
            <h4 style="color: red">${msg}</h4>
        </main>

        <footer class="admin-footer">
            <p>&copy; 2024 Burger House. All rights reserved.</p>
        </footer>
    </body>

    <script>
        // Đợi cho tài liệu HTML được tải hoàn chỉnh
        document.addEventListener('DOMContentLoaded', function () {
            // Lấy tất cả các phần tử input số có thuộc tính data-id
            const quantityInputs = document.querySelectorAll('input[type="number"][data-id]');

            // Lắng nghe sự kiện khi giá trị của input số thay đổi
            quantityInputs.forEach(function (input) {
                input.addEventListener('change', function () {
                    // Tạo một mảng để lưu trữ các giá trị của các input số
                    let quantities = [];

                    // Lặp qua tất cả các input số để lấy giá trị và thêm vào mảng
                    quantityInputs.forEach(function (input) {
                        quantities.push(input.value);
                    });

                    // Gắn các giá trị của mảng vào input arrtayQuantity, ngăn cách bằng dấu phẩy
                    const arrtayQuantityInput = document.querySelector('input[name="arrtayQuantity"]');
                    arrtayQuantityInput.value = quantities.join(',');
                });
            });
        });
    </script>
</html>
