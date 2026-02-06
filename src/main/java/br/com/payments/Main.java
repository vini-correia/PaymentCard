package br.com.payments;

import br.com.payments.Model.Account;
import br.com.payments.Model.CreditCard;
import br.com.payments.dao.ConnectionFactory;

import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<CreditCard> cardHolderList = new ArrayList<>();
        List<Account> accountList = new ArrayList<>();

        while (true) {
            String description = """
                    
                    chose one option:
                    1- register a card and your dates
                    2- search your card number
                    3- Make a purchase and update balance
                    4- create only account with yours dates""";

            System.out.println(description);
            String option = reader.readLine();

            if (option.equals("1")) {
                System.out.println("Type the card holder name: ");
                String cardHolderName = reader.readLine();

                System.out.println("Type the card number: ");
                String cardNumber = reader.readLine();

                System.out.println("Type the card expiry date (YYYY-MM):");
                YearMonth expiryDateValue = YearMonth.parse(reader.readLine());

                System.out.println("escreva o limite do seu cartão: ");
                double limitValue = Double.parseDouble(reader.readLine());
//
//                System.out.println("Type the account email for this card: ");
//                String emailDoTitular = reader.readLine();

                try {
                    insertCredit_Card(cardHolderName, cardNumber, expiryDateValue, limitValue );
                    System.out.println("Card registered successfully in the database!");
                } catch (SQLException e) {
                    System.err.println("Error registering card: " + e.getMessage());
                }

            } else if (option.equals("4")) {
                System.out.println("When is your birthday? (YYYY-MM-DD): ");
                LocalDate birthday = LocalDate.parse(reader.readLine());

                System.out.println("Type the fullname: ");
                String fullName = reader.readLine();

                System.out.println("Type the email: ");
                String email = reader.readLine();

                try {
                    insertAccoount(birthday, fullName, email);
                    System.out.println("Account registered successfully in the database!");
                } catch (SQLException e) {
                    System.err.println("Error registering account: " + e.getMessage());
                }

            } else if (option.equals("2")) {
                System.out.println("Digite o número do seu cartão ou o nome do titular do cartão: ");
                String cartaoAtual = reader.readLine();

                if (cartaoAtual.matches("\\d+")) {
                    getCreditCardByNumber(cartaoAtual);
                    Long.parseLong(cartaoAtual);
                    System.out.println("O número do cartão é "  + cartaoAtual);

                }else {
                    List<String> creditCardList = getCreditCardsByFullName(cartaoAtual);

                    if(creditCardList.isEmpty()){
                        System.out.println("Cartão não encontrado");
                    } else{
                        System.out.println("dados do cartão: " + creditCardList.get(0).toString());
                    }
                }





            }
        }
    }

    private static void getCreditCardByNumber(String cartaoAtual) throws SQLException {
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

    public static void insertAccoount (LocalDate birthday, String fullName, String email) throws SQLException {
        String query = "INSERT INTO account (email, full_name,day_of_birthday) values (?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, fullName);
            preparedStatement.setDate(3, Date.valueOf(birthday));

            preparedStatement.executeUpdate();
        }
    }

    public static void insertCredit_Card (String cardHolderName, String cardNumber, YearMonth expiryDate, double limit) throws SQLException {
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

    public static List<String> getCreditCardsByFullName(String fullName) throws SQLException {

        String getCreditCardByEmail = """
                SELECT c.card_number , c.card_holder_name, c.expiry_date, c.limit_amount, c.balance
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
                                "Card Number: %s | Holder: %s | Expiry: %s | Limit: %.2f | Balance: %.2f",
                                rs.getString("card_number"),
                                rs.getString("card_holder_name"),
                                rs.getString("expiry_date"),
                                rs.getDouble("limit_amount"),
                                rs.getDouble("balance")
                        );
                        cards.add(cardInfo);
                    }
                }


            }
        return cards;
    }
}