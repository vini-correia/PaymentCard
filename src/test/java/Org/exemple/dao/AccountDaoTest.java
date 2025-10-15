package JavaClasses.dao;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AccountDaoTest {

    @Test
    void testInsertAccount() throws SQLException {

        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);

        try (MockedStatic<ConnectionFactory> mockedFactory = mockStatic(ConnectionFactory.class)) {

            mockedFactory.when(ConnectionFactory::getConnection).thenReturn(mockConnection);
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

            AccountDao accountDao = new AccountDao();
            LocalDate birthday = LocalDate.of(1990, 5, 15);
            String fullName = "Usuario Teste";
            String email = "teste@exemplo.com";

            accountDao.insertAccount(birthday, fullName, email);

            verify(mockConnection).prepareStatement("INSERT INTO account (email, full_name,day_of_birthday) values (?,?,?)");
            verify(mockPreparedStatement).setString(1, email);
            verify(mockPreparedStatement).setString(2, fullName);
            verify(mockPreparedStatement).setDate(3, Date.valueOf(birthday));
            verify(mockPreparedStatement).executeUpdate();
            verify(mockPreparedStatement).close();
            verify(mockConnection).close();
        }
    }
}