package com.works.servletapp.servlets;

import com.works.servletapp.utils.Util;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet Call");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login call");
        //req.setAttribute("data", "New Data");
        req.getSession().setAttribute("data", "new Data");
        resp.sendRedirect(Util.baseUrl+"login.jsp");
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
        //dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("LoginServlet destroy");
    }
}
