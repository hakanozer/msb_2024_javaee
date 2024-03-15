package com.sakadream.jsf.controller;


import com.sakadream.jsf.services.LoginService;
import com.sakadream.jsf.utils.Util;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "login")
@RequestScoped
@Data
public class LoginController implements Serializable {

    @ManagedProperty("email")
    private String email;
    @ManagedProperty("password")
    private String password;
    @ManagedProperty("remember")
    private Boolean remember;

    LoginService loginService = new LoginService();

    public String login() {
        boolean loginStatus = loginService.login(email, password, remember);
        if (loginStatus) {
            Util.redirect("dashboard.xhtml");
        }
        return "login";
    }



    public String logout() {
        return "login";
    }
}
