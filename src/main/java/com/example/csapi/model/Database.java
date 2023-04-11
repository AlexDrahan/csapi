package com.example.csapi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        /*String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "";
        String password = "";*/


       /* try {
            Connection conn = DriverManager.getConnection(url, username, password);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
