package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class selectDataFromDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_database", "root", "subhadip");

            String q = "SELECT * FROM table1";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            int idWidth = 6;
            int nameWidth = 20;
            int cityWidth = 13;

            System.out.println("+--------+----------------------+---------------+");
            System.out.println("|   ID   |         Name         |     City      |");
            System.out.println("+--------+----------------------+---------------+");

            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                name = (name.length() > nameWidth) ? name.substring(0, nameWidth - 3) + "..." : name;
                city = (city.length() > cityWidth) ? city.substring(0, cityWidth - 3) + "..." : city;

                System.out.printf("| %-" + idWidth + "d | %-" + nameWidth + "s | %-" + cityWidth + "s |\n", id, name, city);
            }
            System.out.println("+--------+----------------------+---------------+");

            con.close();

        } catch (Exception e) {
            System.err.println("Oops , some error occured : " + e.getMessage());
        }
    }
}
