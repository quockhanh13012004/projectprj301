/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author TNO
 */
public class UserService {

    private PreparedStatement ps;
    private ResultSet rs;

    private List<User> listUser;

    public UserService() {
        listUser = new ArrayList<>();
    }

    public User findUser(String usernameInput, String password) {
        String sql = "select * from Users u\n"
                + "where u.username = ? and u.[password] = ?";

        User user = null;
        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setString(1, usernameInput);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt("user_id");
                int roleID = rs.getInt("role_id");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                String fullName = rs.getString("full_name");
                String phoneNum = rs.getString("phone_number");
                String address = rs.getString("address");

                user = new User(userID, roleID, username, password,
                        email, fullName, phoneNum, address);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return user;
    }

    public List<User> findAllUser() {
        String sql = "select * from Users";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idUser = rs.getInt("user_id");
                int roleID = rs.getInt("role_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String fullName = rs.getString("full_name");
                String phoneNumber = rs.getString("phone_number");
                String address = rs.getString("address");

                User user = new User(idUser, roleID, username, password,
                        email, fullName, phoneNumber, address);

                listUser.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listUser;

    }

    public boolean addUser(String username, String password, String email, String fullName,
            String phoneNumber, String address, int role) {
        String sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([role_id]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[full_name]\n"
                + "           ,[phone_number]\n"
                + "           ,[address])\n"    
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, role);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, fullName);
            ps.setString(6, phoneNumber);
            ps.setString(7, address);

            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return false;

    }

    public User findUserByID(int idUserInput) {
        String sql = "select * from Users u\n"
                + "where u.[user_id] = ?";

        User user = null;

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, idUserInput);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idUser = rs.getInt("user_id");
                int roleID = rs.getInt("role_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String fullName = rs.getString("full_name");
                String phoneNumber = rs.getString("phone_number");
                String address = rs.getString("address");

                user = new User(idUser, roleID, username, password,
                        email, fullName, phoneNumber, address);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return user;
    }

    public boolean updateUser(int userID, String email, String fullName, String phoneNumber,
            String address, int role) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "SET [role_id] = ?,\n"
                + "    [email] = ?,\n"
                + "    [full_name] = ?,\n"
                + "    [phone_number] = ?,\n"
                + "    [address] = ?\n"
                + "WHERE [user_id] = ?";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, role);
            ps.setString(2, email);
            ps.setString(3, fullName);
            ps.setString(4, phoneNumber);
            ps.setString(5, address);
            ps.setInt(6, userID);

            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return false;
    }
    public static void main(String[] args) {
        UserService user = new UserService();
        boolean isAdded = user.addUser("khanh", "123", "nguyenquoc@", "quockhanh", "0123456", "ha noi", 0);
        if(isAdded){
         System.out.println("New staff added successfully.");
        }else{
         System.out.println("Failed to add new staff.");
        }
    }
}
