package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertDynamicQuery {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creating a connection to the MySQL database
            String url = "jdbc:mysql://localhost:3306/movies_database"; // URL to connect to the database
            String username = "root"; // MySQL username
            String password = "subhadip"; // MySQL password
            Connection con = DriverManager.getConnection(url, username, password); // Establishing the connection

            // SQL query to insert data into the table with placeholders for dynamic values
            String q = "insert into table1(tName, tCity) values (?,?)";

            // Creating a PreparedStatement object to execute the query
            PreparedStatement preparedStatement = con.prepareStatement(q);

            // Setting values for the placeholders in the query
            preparedStatement.setString(1, "Subhadip Kundu"); // Setting the value for the first placeholder (?)
            preparedStatement.setString(2, "Bankura"); // Setting the value for the second placeholder (?)

            // Executing the insert query
            preparedStatement.executeUpdate();

            // Printing a message indicating successful insertion
            System.out.println("Insertion Done...");

            // Closing the database connection
            con.close();
        } catch (Exception e) {
            // Handling any exceptions that may occur during the process
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
