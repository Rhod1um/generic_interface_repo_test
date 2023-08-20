package com.example.interface_repo_test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static String username;
    private static String password;
    private static String hostname;
    private static Connection conn;

    public static Connection getConnection(){
        if (conn != null) {
            return conn;
        }

        setHostname("jdbc:mysql://keaserver.mysql.database.azure.com:3306/bilabonnement");
        setUsername("kea");
        setPassword("pnQvY%d6GgMo");

        try {
            conn = DriverManager.getConnection(getHostname(), getUsername(), getPassword());
        } catch (SQLException e) {
            System.out.println("no connection to DB");
            throw new RuntimeException(e);
        }
        System.out.println("Connection to Database Sucessful.");
        return conn;
    }


    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DatabaseConnector.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DatabaseConnector.password = password;
    }

    public static String getHostname() {
        return hostname;
    }

    public static void setHostname(String hostname) {
        DatabaseConnector.hostname = hostname;
    }
}

