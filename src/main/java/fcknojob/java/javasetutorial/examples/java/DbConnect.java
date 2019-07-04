package fcknojob.java.javasetutorial.examples.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";

        String database = "addressBook";

        String userName = "local";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url + database, userName, password)) {
            System.out.println("Databae connection: Successful");
        } catch (Exception e) {
            System.out.println("Database connection: Failed");
            e.printStackTrace();
        }
    }
}
