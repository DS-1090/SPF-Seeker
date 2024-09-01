package com.mycompany.test2maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Upender Vennam
 */
public class Test2maven {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sun_proj";
        String username = "root";
        String password = "divdb";

        try {
            // 1. Establish a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 2. Create a statement for executing SQL queries
            Statement statement = connection.createStatement();

            // 3. Execute an SQL query (e.g., select all rows from a table)
            String sqlQuery = "SELECT * FROM sundata";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // 4. Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt("SPF");
                String name = resultSet.getString("Name");
                // Process and use the retrieved data here
                System.out.println("SPF: " + id + ", Name: " + name);
            }

            // 5. Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
