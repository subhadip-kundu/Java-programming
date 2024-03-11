package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertPicture {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_database", "root", "subhadip");

            String q = "insert into images(pic) values(?)";
            PreparedStatement prst = con.prepareStatement(q);

            FileInputStream file = new FileInputStream("000.jpg");
            prst.setBinaryStream(1, file, file.available());
            prst.executeUpdate();

            System.out.println("Upload done!");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
