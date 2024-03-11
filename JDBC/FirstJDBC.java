package JDBC;

import java.sql.*;

public class FirstJDBC {
    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creating a connection
            String url = "jdbc:mysql://localhost:3306/movies_database";
            String username = "root";
            String password = "subhadip";

            Connection con = DriverManager.getConnection(url, username, password);

            if (con.isClosed()) {
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connection created!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
