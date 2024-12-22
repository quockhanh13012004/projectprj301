/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dal.DishesService;
import dal.OrderService;
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
@WebServlet(name = "CreateOrder", urlPatterns = {"/createOrder"})
public class CreateOrder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nameCustomer = request.getParameter("nameCustomer");
        String phoneNum = request.getParameter("phoneNum");
        int tableNum = Integer.parseInt(request.getParameter("tableNum"));

        DishesService dishesService = new DishesService();
        HttpSession session = request.getSession();
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

        User user = (User) session.getAttribute("accAccess");
        int idStaff = 0;
        String staffName = "";

        if (user != null) {
            idStaff = user.getUserID();
            staffName = user.getFullName();
        }

        String msg = "";

        OrderService orderService = new OrderService();

        if (orderService.createOrderAndORderDetails(tableNum ,nameCustomer, phoneNum, totalAllItems,
                listItemDishes, idStaff, staffName)) {
            msg = "Order sucessfully!";
        } else {
            msg = "Order failed!";
        }

        List<Dishes> listDishes = dishesService.findAllDishes();

        request.setAttribute("msg", msg);
        request.setAttribute("listDishes", listDishes);
        request.setAttribute("listItemDishes", listItemDishes);
        request.setAttribute("totalAllItems", totalAllItems);

        request.getRequestDispatcher("menu.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
