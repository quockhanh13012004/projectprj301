/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dal.UserService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author TNO
 */
@WebServlet(name="PageDetailsUser", urlPatterns={"/detailsUser"})
public class PageDetailsUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       int idUser = Integer.parseInt(request.getParameter("idUser"));
       
        UserService userService = new UserService();
        
        User user = userService.findUserByID(idUser);
        
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("viewDetailsUser.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
