package com.works.servletapp.servlets;

import com.works.servletapp.utils.Util;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("*")
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String[] freeUrls = {"/", "/login.jsp", "/login.jsp?error"};
        boolean loginStatus = true;
        for (String item : freeUrls) {
            if (item.equals(url)) {
                loginStatus = false;
                break;
            }
        }

        if(loginStatus) {
            // Session Control
            Object obj = req.getSession().getAttribute("customer");
            if (obj == null) {
                // Oturum yok
                res.sendRedirect(Util.baseUrl+"login.jsp");
            }else {
                // Oturum var
                filterChain.doFilter(req, res);
            }
        }else {
            filterChain.doFilter(req, res);
        }


    }

}
