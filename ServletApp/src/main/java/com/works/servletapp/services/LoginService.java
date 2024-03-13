package com.works.servletapp.services;

import com.works.servletapp.models.Customer;
import com.works.servletapp.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public Customer login(String email, String password) {
        DB db = new DB();
        try {
            String sql = "select * from customer where email = ? and password = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            boolean rsStatus = rs.next();
            if (rsStatus) {
                int cid = rs.getInt("cid");
                String emailDb = rs.getString("email");
                String name = rs.getString("name");
                Customer customer = new Customer();
                customer.setCid(cid);
                customer.setEmail(emailDb);
                customer.setName(name);
                return customer;
            }
        }catch (Exception ex) {
            System.err.println("login Error: " + ex);
        }finally {
            db.close();
        }
        return null;
    }

}