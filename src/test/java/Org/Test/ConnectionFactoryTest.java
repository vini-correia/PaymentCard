package Org.Test;

import JavaClasses.dao.ConnectionFactory;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

public class ConnectionFactoryTest {

    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "vini240605";

    @Test

    void testeGetConnection(){

        Connection connectionMock = mock(Connection.class);


    try(MockedStatic<DriverManager> mokedDriverManager = mockStatic(DriverManager.class)){
        mokedDriverManager.when(() -> {
            DriverManager.getConnection(URL, USER, PASSWORD);
        } ).thenReturn(connectionMock);

    }

    Connection connection = ConnectionFactory.getConnection();

    assertNotNull(connection);
    }
}
