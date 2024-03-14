package com.sakadream.jsf.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@ManagedBean(name = "login")
@RequestScoped
public class LoginController implements Serializable {

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        String username = getParameterByName("username");
        String password = getParameterByName("password");
        System.out.println(username);
        return "login";
    }

    public String getParameterByName(String name) {
        HttpServletRequest req = getRequest();
        return req.getParameter(name);
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public String logout() {
        return "login";
    }
}
