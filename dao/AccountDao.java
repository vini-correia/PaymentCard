package JavaClasses.dao;

import JavaClasses.Account2;
import JavaClasses.Model.Account;

import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;

public class AccountDao {

    public Account2 insertAccount (LocalDate birthday, String fullName, String email) throws SQLException {
        String query = "INSERT INTO account (email, full_name,day_of_birthday) values (?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, fullName);
            preparedStatement.setDate(3, Date.valueOf(birthday));

            preparedStatement.executeUpdate();

            Long id = null;
            try(ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys()) {
                if (getGeneratedKeys.next()) {
                    id = getGeneratedKeys.getLong(1);
                }

                return new Account2(
                        id,
                        birthday,
                        fullName,
                        email
                );

            }
        }
    }

}
