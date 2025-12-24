package JavaClasses.dao;

import java.sql.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class CreditCardDao {

    public void insertCredit_Card (String cardHolderName, String cardNumber, YearMonth expiryDate, double limit) throws SQLException {
        String query = "INSERT INTO credit_Card (card_Holder_Name, card_Number, expiry_Date, limit_amount) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cardHolderName);
            preparedStatement.setString(2, cardNumber);
            //   preparedStatement.setDate(3, Date.valueOf(expiryDate.atDay(1)));
            preparedStatement.setString(3,expiryDate.toString());
            preparedStatement.setDouble(4, limit);

            preparedStatement.executeUpdate();
        }
    }

    public void getCreditCardByNumber(String cartaoAtual) throws SQLException {
        String selectCardNumber = "select * from credit_card where card_number = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectCardNumber)) {

            preparedStatement.setString(1, cartaoAtual);

            try (ResultSet rs = preparedStatement.executeQuery()) {

                if (rs.next()) {
                    String cardNumber = rs.getString("card_number");

                    System.out.println("Cartão encontrado!");

                } else {
                    System.out.println("Nenhum cartão encontrado com o número: " + cartaoAtual);
                }
            }
        }
    }

    public static List<String> getCreditCardsByFullName(String fullName) throws SQLException {

        String getCreditCardByEmail = """
                SELECT c.card_number
                from credit_card c
                JOIN account a ON c.card_holder_name = a.full_name
                where a.full_name = ?
                """;

        List<String> cards = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(getCreditCardByEmail)){

            stmt.setString(1, fullName);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String cardInfo = String.format(
                            "Card Number: %s ",
                            rs.getString("card_number")
                            //rs.getString("card_holder_name"),
//                                rs.getString("expiry_date"),
//                                rs.getDouble("limit_amount"),
//                                rs.getDouble("balance")
                    );
                    cards.add(cardInfo);
                }
            }


        }
        return cards;
    }
}
