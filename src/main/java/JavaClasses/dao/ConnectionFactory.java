package JavaClasses.dao;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static void getPassword() {
        ClassLoader classLoader = ConnectionFactory.class.getClassLoader();
        String resourceName = "senha.txt";

        try (InputStream inputStream = classLoader.getResourceAsStream(resourceName)) {

            if (inputStream == null) {
                throw new IOException("O arquivo de recurso '" + resourceName + "' não foi encontrado no classpath.");
            }

            try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {

                String linha;
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }
            }

        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao ler a senha.");
            e.printStackTrace();
        }
    }

    private static final String URL = "jdbc:postgresql://localhost:3306/payment_card";
    private static final String USER = "postgres";
    private static final String PASSWORD = "vini240605";

    public static Connection getConnection() {
        getPassword();

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException a) {
            a.printStackTrace();
            throw new RuntimeException("Error connecting to database");
        }
    }
}
