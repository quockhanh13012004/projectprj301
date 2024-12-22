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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Dishes;
import model.ItemDishes;
import model.User;

/**
 *
 * @author TNO
 */
@WebServlet(name = "PageStaffMangeMenu", urlPatterns = {"/pageStaffMenu"})
public class PageStaffMangeMenu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DishesService dishesService = new DishesService();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("accAccess");

        if (user == null || user.getRoleID() != 2) {
            response.sendRedirect("login");
            return;
        }

        List<ItemDishes> listItemDishes = new ArrayList<>();
        HashMap<String, Integer> itemHashMap = (HashMap<String, Integer>) session.getAttribute("itemHashMap");
        BigDecimal totalAllItems = BigDecimal.ZERO;

        for (Map.Entry<String, Integer> entry : itemHashMap.entrySet()) {
            String[] key = entry.getKey().split(" ");
            String idDishes = key[0];
            String priceDishesString = key[key.length - 1];
            BigDecimal priceDishes = new BigDecimal(priceDishesString);

            StringBuilder dishesNameBuilder = new StringBuilder();
            for (int i = 1; i < key.length - 1; i++) {
                dishesNameBuilder.append(key[i]);
                if (i < key.length - 2) {
                    dishesNameBuilder.append(" ");
                }
            }

            String nameOfDishes = dishesNameBuilder.toString();

            int quantity = entry.getValue();

            BigDecimal totalEachDishes = priceDishes.multiply(BigDecimal.valueOf(quantity));

            totalAllItems = totalAllItems.add(totalEachDishes);

            ItemDishes itemDishes = new ItemDishes(idDishes, nameOfDishes,
                    priceDishes, quantity, totalEachDishes);

            listItemDishes.add(itemDishes);

        }

        List<Dishes> listDishes = dishesService.findAllDishes();

        request.setAttribute("listDishes", listDishes);
        request.setAttribute("listItemDishes", listItemDishes);
        request.setAttribute("totalAllItems", totalAllItems);

        request.getRequestDispatcher("menu.jsp").forward(request, response);
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
