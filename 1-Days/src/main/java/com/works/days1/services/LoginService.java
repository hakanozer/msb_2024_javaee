package com.works.days1.services;

public class LoginService {

    String city = "Ankara";
    public boolean userLogin( String email, String password ) {
        if (email.equals("ali@mail.com") && password.equals("12345")) {
           return true;
        }
        return false;
    }

}
