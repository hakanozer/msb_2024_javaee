package com.works.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig) throws ServletException {
        System.out.println("Server UP");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String agent = req.getHeader("user-agent");
        String url = req.getRequestURI();
        String session = req.getSession().getId();
        String lang = req.getHeader("Accept-Language");
        String token = req.getHeader("token");
        String ip = req.getRemoteAddr();
        if (token == null || token.equals("123Token")) {
            System.out.println(url+" - "+agent+" - "+session+" - "+ lang+" - "+ token+" - "+ ip);
            filterChain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        try {
            //Thread.sleep(5000);
        }catch (Exception ex) {

        }
        System.out.println("Server DOWN");
    }

}
