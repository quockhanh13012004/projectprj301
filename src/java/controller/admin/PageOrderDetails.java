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
import java.util.List;
import model.OrderDetails;

/**
 *
 * @author TNO
 */
@WebServlet(name = "PageOrderDetails", urlPatterns = {"/pageOrderDetails"})
public class PageOrderDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        OrderService orderService = new OrderService();

        List<OrderDetails> listOrderDetails = orderService.findOrderDetailsByOrderID(idOrder);

        request.setAttribute("listOrderDetails", listOrderDetails);

        request.getRequestDispatcher("orderDetails.jsp").forward(request, response);
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
