/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.OrderService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Order;
import model.User;

/**
 *
 * @author TNO
 */
@WebServlet(name = "PageMangeOrders", urlPatterns = {"/manageOrder"})
public class PageMangeOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("accAccess");

        if (user == null || user.getRoleID() != 3) {
            response.sendRedirect("login");
            return;
        }

        String msgError = (String) session.getAttribute("msgError");

        List<Order> listOrder = getListOrder(request);

        request.setAttribute("listOrder", listOrder);
        request.setAttribute("msgError", msgError);

        request.getRequestDispatcher("orderAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private List<Order> getListOrder(HttpServletRequest request) {
        OrderService orderService = new OrderService();

        List<Order> listOrder = null;

        String action = request.getParameter("action") == null
                ? "defaultFindAll"
                : request.getParameter("action");
        switch (action) {
            case "status":
                int status = Integer.parseInt(request.getParameter("statusFilter"));
                if (status == 0) {
                    listOrder = orderService.findAllOrder();
                } else {
                    listOrder = orderService.findAllOrderByStatus(status);
                }

                break;
            default:
                listOrder = orderService.findAllOrder();

        }

        return listOrder;
    }

}
