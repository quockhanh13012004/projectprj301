/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Dishes;

/**
 *
 * @author TNO
 */
public class DishesService {

    private PreparedStatement ps;
    private ResultSet rs;

    private List<Dishes> listDishes;

    public DishesService() {
        listDishes = new ArrayList<>();
    }

    public List<Dishes> findAllDishes() {
        String sql = "select * from Dishes d\n"
                + "where d.[status] = 1";
        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idDishes = rs.getInt("dish_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                String image = rs.getString("image");
                int status = rs.getInt("status");

                Dishes dishes = new Dishes(idDishes, name, description, price, image, status);

                listDishes.add(dishes);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return listDishes;
    }

    public Dishes findDishesByID(int idDishesInput) {
        String sql = "select * from Dishes d\n"
                + "  where d.dish_id = ?";

        Dishes dishes = null;
        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, idDishesInput);

            rs = ps.executeQuery();

            if (rs.next()) {
                int idDishes = rs.getInt("dish_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                String image = rs.getString("image");
                int status = rs.getInt("status");

                dishes = new Dishes(idDishes, name, description, price, image, status);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return dishes;
    }

    public boolean insertDish(String name, String description, String price, String image, int status) {
        String sql = "INSERT INTO [dbo].[Dishes] ([name], [description], [price], [image], [status]) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, price);
            ps.setString(4, image);
            ps.setInt(5, status);

            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return false;
    }

    public boolean updateDish(int idDish, String name, String description, String price,
            String image, int status, int updateImageMode) {

        String sql = "";

        switch (updateImageMode) {
            case 0:
                sql = "UPDATE [dbo].[Dishes]\n"
                        + "   SET [name] = ?\n"
                        + "      ,[description] = ?\n"
                        + "      ,[price] = ?\n"
                        + "      ,[status] = ?\n"
                        + " WHERE [dish_id] = ?";
                break;
            case 1:
                sql = "UPDATE [dbo].[Dishes]\n"
                        + "   SET [name] = ?\n"
                        + "      ,[description] = ?\n"
                        + "      ,[price] = ?\n"
                        + "      ,[status] = ?\n"
                        + "      ,[image] = ?\n"
                        + " WHERE [dish_id] = ?";
                break;
            default:
                throw new AssertionError();
        }

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, price);
            ps.setInt(4, status);

            if (updateImageMode == 1) {
                ps.setString(5, image);
                ps.setInt(6, idDish);
            } else {
                ps.setInt(5, idDish);
            }
            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return false;
    }

    public boolean updateStatusDish(int status, int idDish) {

        String sql = "UPDATE [dbo].[Dishes]\n"
                + "   SET [status] = ?\n"
                + " WHERE [dish_id] = ?";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, status);
            ps.setInt(2, idDish);

            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return false;
    }

}
