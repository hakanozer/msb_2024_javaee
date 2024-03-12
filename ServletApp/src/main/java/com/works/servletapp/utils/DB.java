package com.works.servletapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private final String driver = "org.h2.Driver";
    private final String url = "jdbc:h2:file:~/msb_ee";
    private final String userName = "sa";
    private final String password = "sa";

    private Connection conn = null;

    public Connection connect() {
        try {
            if (conn == null) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, userName, password);
                System.out.println("Connection Succsess");
            }
        }catch (Exception ex) {
            System.err.println("Connection Error:" +ex);
        }
        return conn;
    }


    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("DB Close Succsess");
            }
        }catch (Exception ex) {
            System.err.println("Close Error:" + ex);
        }
    }

}
