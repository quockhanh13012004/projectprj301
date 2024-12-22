/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.DishesService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Dishes;
import model.User;

/**
 *
 * @author TNO
 */
@WebServlet(name = "PageManageMenu", urlPatterns = {"/manageMenu"})
public class PageManageMenu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("accAccess");

        if (user == null || user.getRoleID() != 3) {
            response.sendRedirect("login");
            return;
        }
        
        DishesService dishesService = new DishesService();

        List<Dishes> listDishes = dishesService.findAllDishes();

        request.setAttribute("listDishes", listDishes);

        request.getRequestDispatcher("menuAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
