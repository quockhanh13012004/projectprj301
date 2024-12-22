/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.guest;

import dal.DishesService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import model.Dishes;

/**
 *
 * @author TNO
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        HashMap<String, Integer> itemHashMapSession = (HashMap<String, Integer>) session.getAttribute("itemHashMap");

        if (itemHashMapSession == null || itemHashMapSession.isEmpty()) {
            HashMap<String, Integer> itemHashMap = new HashMap<>();
            session.setAttribute("itemHashMap", itemHashMap);
        }

        DishesService dishesService = new DishesService();

        List<Dishes> listDishes = dishesService.findAllDishes();

        request.setAttribute("listDishes", listDishes);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
