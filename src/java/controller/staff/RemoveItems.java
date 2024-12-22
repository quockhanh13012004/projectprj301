/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author TNO
 */
@WebServlet(name = "RemoveItems", urlPatterns = {"/removeItems"})
public class RemoveItems extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> itemHashMap = (HashMap<String, Integer>) session.getAttribute("itemHashMap");

        String idDishes = request.getParameter("idDishes");
        if (deleteFromListItems(idDishes, itemHashMap)) {
            response.sendRedirect("pageStaffMenu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private boolean deleteFromListItems(String idDishesInput, HashMap<String, Integer> itemHashMap) {
       Iterator<Map.Entry<String, Integer>> iterator = itemHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String[] key = entry.getKey().split(" ");
            String dishesID = key[0];

            if (idDishesInput.equalsIgnoreCase(dishesID)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
