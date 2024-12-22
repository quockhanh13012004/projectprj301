/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.DishesService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author TNO
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
@WebServlet(name = "AddDishToMenu", urlPatterns = {"/AddDish"})
public class AddDishToMenu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addDishes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
//        HttpSession session = request.getSession();
        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String price = request.getParameter("price");
            int status = Integer.parseInt(request.getParameter("status"));

            String uploadFolder = getServletContext().getRealPath("") + "../../web/img";

            File folder = new File(uploadFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            Part filePart = request.getPart("image");
            String fileName = getSubmittedFileName(filePart);
            String imagePath = "img/" + fileName;

            OutputStream out = null;
            InputStream fileContent = null;

            try {
                out = new FileOutputStream(new File(uploadFolder + File.separator + fileName));
                fileContent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

            } catch (FileNotFoundException fne) {
                fne.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
            }

            DishesService dishesService = new DishesService();

            if (dishesService.insertDish(name, description, price, imagePath, status)) {
                msg = "Add successfully!";
                request.setAttribute("msgError", msg);
                request.getRequestDispatcher("addDishes.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException e) {
            msg = "Error " + e.getMessage();
            request.setAttribute("msgError", msg);
            request.getRequestDispatcher("addDishes.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
