package com.works.servletapp.services;

import com.works.servletapp.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public String login(String email, String password) {
        String dbEmail = "";
        DB db = new DB();
        try {
            String sql = "select * from customer where email = ? and password = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            boolean rsStatus = rs.next();
            if (rsStatus) {
                dbEmail = rs.getString("email");
            }
        }catch (Exception ex) {
            System.err.println("login Error: " + ex);
        }finally {
            db.close();
        }
        return dbEmail;
    }

}