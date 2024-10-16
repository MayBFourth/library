package com.librabymanagement.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/ltm-server-db-1";
        String username = "dbpass";
        String password = "dbuser";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}
