package JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertByUserInput {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creating a connection
            String url = "jdbc:mysql://localhost:3306/movies_database";
            String username = "root";
            String password = "subhadip";
            Connection con = DriverManager.getConnection(url, username, password);

            //SQL query to insert data into the table with user input for dynamic values
            String q = "insert into table1(tName,tCity) values (?,?)";

            // get the preparedStatement object
            PreparedStatement psmt = con.prepareStatement(q);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name:");
            String name = br.readLine();

            System.out.println("Enter city:");
            String city = br.readLine();

            //Set the value to the quary
            psmt.setString(1, name);
            psmt.setString(2, city);

            psmt.executeUpdate();
            System.out.println("Details updated successfully!...");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
