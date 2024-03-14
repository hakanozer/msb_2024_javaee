package com.works.servletapp.servlets;

import com.works.servletapp.services.ProductService;
import com.works.servletapp.utils.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.server.UID;

@WebServlet({"/product", "/productDelete"})
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Integer price = Integer.valueOf(req.getParameter("price"));
        String detail = req.getParameter("detail");
        productService.productAdd(title, price, detail);
        resp.sendRedirect(Util.baseUrl+"dashboard.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stPid = req.getParameter("pid");
        try {
            int pid = Integer.valueOf(stPid);
            productService.productDelete(pid);
            resp.sendRedirect(Util.baseUrl+"dashboard.jsp");
        }catch (Exception ex) {
            req.getSession().removeAttribute("customer");
            resp.sendRedirect(Util.baseUrl);
        }
    }
}
