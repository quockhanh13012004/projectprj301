/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dal.DishesService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import model.Dishes;

/**
 *
 * @author TNO
 */
@WebServlet(name = "AddItems", urlPatterns = {"/addItems"})
public class AddItems extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idDishes = Integer.parseInt(request.getParameter("dishesID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        DishesService dishesService = new DishesService();

        Dishes dishes = dishesService.findDishesByID(idDishes);

        HttpSession session = request.getSession();
        HashMap<String, Integer> itemHashMap = (HashMap<String, Integer>) session.getAttribute("itemHashMap");

        String key = dishes.getIdDishes() + " " + dishes.getName() + " " + dishes.getPrice();

        itemHashMap.put(key, quantity);

        session.setAttribute("itemHashMap", itemHashMap);
        
        response.sendRedirect("pageStaffMenu");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
