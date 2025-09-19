package JavaClasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:3306/payment_card";
    private static final String USER = "postgres";
    private static final String PASSWORD = "vini240605";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException a) {
            a.printStackTrace();
            throw new RuntimeException("Error connecting to database");
        }
    }
}
