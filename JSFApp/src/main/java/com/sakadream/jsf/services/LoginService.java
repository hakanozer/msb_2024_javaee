package com.sakadream.jsf.services;

public class LoginService {

    public boolean login( String email, String password, boolean remember ) {
        boolean status = false;
        if (email.equals("ali@mail.com") && password.equals("12345")) {
            status = true;
        }
        return status;
    }

}
