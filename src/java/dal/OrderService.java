/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.ItemDishes;
import model.Order;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.OrderDetails;
import model.OrderResponse;

/**
 *
 * @author TNO
 */
public class OrderService {

    private PreparedStatement ps;
    private ResultSet rs;
    private List<Order> listOrder;
    private List<OrderDetails> listOrderDetails;

    public OrderService() {
        listOrder = new ArrayList<>();
        listOrderDetails = new ArrayList<>();
    }

    public boolean createOrderAndORderDetails(int taleNum, String nameCustomer, String phoneNum,
            BigDecimal totalAllItems, List<ItemDishes> listItemDishes, int idStaff,
            String staffName) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([table_num]\n"
                + "           ,[name_customer]\n"
                + "           ,[phone_customer]\n"
                + "           ,[total_amount]\n"
                + "           ,[createdBy]\n"
                + "           ,[status_id])\n"
                + "     VALUES (?, ?, ?, ?, ?, ?)";

        String insertOrderDetails = "INSERT INTO [dbo].[OrderDetails]\n"
                + "           ([order_id]\n"
                + "           ,[dish_id]\n"
                + "           ,[quantity]\n"
                + "           ,[price])\n"
                + "     VALUES (?, ?, ?, ?)";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);

            ps.setInt(1, taleNum);
            ps.setString(2, nameCustomer);
            ps.setString(3, phoneNum);
            ps.setString(4, totalAllItems.toString());
            ps.setInt(5, idStaff);
            ps.setInt(6, 1);

            int rowAffected = ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idOrder = generatedKeys.getInt(1);
                    for (int i = 0; i < listItemDishes.size(); i++) {
                        ps = connection.prepareStatement(insertOrderDetails);

                        String idDish = listItemDishes.get(i).getId();
                        String price = listItemDishes.get(i).getPrice().toString();
                        int quantity = listItemDishes.get(i).getQuantity();

                        ps.setInt(1, idOrder);
                        ps.setString(2, idDish);
                        ps.setInt(3, quantity);
                        ps.setString(4, price);

                        int rowOrderDetailsAffected = ps.executeUpdate();

                        if (rowOrderDetailsAffected < 0) {
                            return false;
                        }
                    }
                }
            }

            if (rowAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return false;
    }

    public List<Order> findAllOrder() {
        String sql = "SELECT o.order_id, o.order_date, o.table_num, o.name_customer, o.phone_customer, \n"
                + "    o.total_amount, o.createdBy, o.status_id, u.full_name \n"
                + "FROM Orders o \n"
                + "JOIN Users u \n"
                + "ON o.createdBy = u.[user_id] \n"
                + "ORDER BY o.order_date DESC";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("order_id");
                Timestamp orderDate = rs.getTimestamp("order_date");
                int tableNum = rs.getInt("table_num");
                String nameCustomer = rs.getString("name_customer");
                String phoneNum = rs.getString("phone_customer");
                BigDecimal totalAmount = rs.getBigDecimal("total_amount");
                int createdBy = rs.getInt("createdBy");
                int status = rs.getInt("status_id");
                String nameStaff = rs.getString("full_name");

                Order orders = new OrderResponse(nameStaff, orderID, orderDate,
                        tableNum, nameCustomer, phoneNum, totalAmount, createdBy, status);

                listOrder.add(orders);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listOrder;
    }

    public List<OrderDetails> findOrderDetailsByOrderID(int orderIdInput) {
        String sql = "select o.order_detail_id, o.order_id, o.dish_id, o.quantity, o.price, d.[name] from OrderDetails o\n"
                + "	join Dishes d\n"
                + "	on o.dish_id = d.dish_id\n"
                + "	where o.order_id = ?";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, orderIdInput);

            rs = ps.executeQuery();

            while (rs.next()) {
                int orderDetailsID = rs.getInt("order_detail_id");
                int orderID = rs.getInt("order_id");
                int dishID = rs.getInt("dish_id");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");
                String dishName = rs.getString("name");

                OrderDetails orderDetails = new OrderDetails(orderDetailsID, orderID,
                        dishID, quantity, price, dishName);

                listOrderDetails.add(orderDetails);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listOrderDetails;
    }

    public List<Order> findAllOrderByStatus(int statusInput) {
        String sql = "select o.order_id, o.order_date, o.table_num, o.name_customer, o.phone_customer, \n"
                + "	o.total_amount, o.createdBy, o.status_id, u.full_name from Orders o\n"
                + "	join Users u\n"
                + "	on o.createdBy = u.[user_id]\n"
                + "	where o.status_id = ?";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, statusInput);

            rs = ps.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("order_id");
                Timestamp orderDate = rs.getTimestamp("order_date");
                int tableNum = rs.getInt("table_num");
                String nameCustomer = rs.getString("name_customer");
                String phoneNum = rs.getString("phone_customer");
                BigDecimal totalAmount = rs.getBigDecimal("total_amount");
                int createdBy = rs.getInt("createdBy");
                int status = rs.getInt("status_id");
                String nameStaff = rs.getString("full_name");

                Order orders = new OrderResponse(nameStaff, orderID, orderDate,
                        tableNum, nameCustomer, phoneNum, totalAmount, createdBy, status);

                listOrder.add(orders);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listOrder;
    }

    public boolean UpdateStatusOrder(int status, int idOrder) {
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [status_id] = ?\n"
                + " WHERE order_id = ?;";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, status);
            ps.setInt(2, idOrder);

            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return false;
    }

    public List<Order> findOrderByTableNum(int tableNumInput) {
        String sql = "select o.order_id, o.order_date, o.table_num, o.name_customer, o.phone_customer,\n"
                + "o.total_amount, o.createdBy, o.status_id, u.full_name from Orders o\n"
                + "join Users u\n"
                + "on o.createdBy = u.[user_id]\n"
                + "where o.table_num = ?";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, tableNumInput);

            rs = ps.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("order_id");
                Timestamp orderDate = rs.getTimestamp("order_date");
                int tableNum = rs.getInt("table_num");
                String nameCustomer = rs.getString("name_customer");
                String phoneNum = rs.getString("phone_customer");
                BigDecimal totalAmount = rs.getBigDecimal("total_amount");
                int createdBy = rs.getInt("createdBy");
                int status = rs.getInt("status_id");
                String nameStaff = rs.getString("full_name");

                Order orders = new OrderResponse(nameStaff, orderID, orderDate,
                        tableNum, nameCustomer, phoneNum, totalAmount, createdBy, status);

                listOrder.add(orders);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listOrder;
    }

}
