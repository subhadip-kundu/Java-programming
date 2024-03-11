package JDBC;

import java.sql.*;

public class insertJDBC {
    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creating a connection
            String url = "jdbc:mysql://localhost:3306/movies_database";
            String username = "root";
            String password = "subhadip";

            Connection con = DriverManager.getConnection(url, username, password);

            //Create a query
            String q = "alter table images modify pic blob"; // We can use long blob instead of blob for get more size into it

            //Create a statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table created in database!");

            con.close();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
