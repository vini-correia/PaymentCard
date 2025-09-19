package JavaClasses.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;

public class AccountDao {

    public void insertAccount (LocalDate birthday, String fullName, String email) throws SQLException {
        String query = "INSERT INTO account (email, full_name,day_of_birthday) values (?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, fullName);
            preparedStatement.setDate(3, Date.valueOf(birthday));

            preparedStatement.executeUpdate();
        }
    }

}
