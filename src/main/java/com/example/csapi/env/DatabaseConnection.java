package com.example.csapi.env;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {

        String username = "<username>";
        String password = "<password>";
        String serverAddress = "<server_address>";
        String port = "<port>"; //1521 Oracle
        String databaseName = "<database_name>";

        String url = "jdbc:oracle:thin:@" + serverAddress + ":" + port + ":" + databaseName;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}