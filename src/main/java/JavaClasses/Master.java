//package JavaClasses;
//
//import javax.sql.DataSource;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.*;
//import java.time.LocalDate;
//import java.time.YearMonth;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.atomic.AtomicInteger;
//
///* MODULE 2 GO UNTIL I ADD THE SEARCH WITHOUT AN ID THAT LINK CARDS AND ACCOUNTS */
//public class Master {
//
//    private static final String URL = "jdbc:postgresql://localhost:3306/payment_card";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "vini240605";
//
//    public static void main(String[] args) throws IOException, SQLException {
//
//
//        /* Abrange
//         - laços de repetição
//         - condicionais
//         - java collections
//        */
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        while(true) {
//
//
//            String initialDescription = """
//               Digite o que deseja:
//                 1 - Register a card and account
//                 2 - Search your card
//                 3 - Make a purchase and update balance
//               """;
//            System.out.println(initialDescription);
//            String s = reader.readLine();
//
//            if(s.equalsIgnoreCase("1")) {
//                CreditCard2 creditCard = new CreditCard2();
//                Account account = new Account();
//                System.out.println("type the card number");
//                creditCard.setCardNumber(reader.readLine());
//                System.out.println("Card number is = " + creditCard.getCardNumber());
//
//                System.out.println("type the card holder name");
//                creditCard.setCardHoderName(reader.readLine());
//                System.out.println("Card holderName is = " + creditCard.getCardHoderName());
//
//                //2026-10
//                System.out.println("type the card expiry Date");
//                String expiryDate = reader.readLine();
//                creditCard.setExpiryDate(YearMonth.parse(expiryDate));
//                System.out.println("expiry Date = " + creditCard.getExpiryDate().toString());
//
//                System.out.println("limit");
//                creditCard.setLimit(Double.parseDouble(reader.readLine()));
//                System.out.println("limit is = " + creditCard.getLimit());
//
//                //2025-06-18
//                System.out.println("type the day of birth");
//                String dateOFBirth = reader.readLine();
//                account.setDayeOfBirthLocalDate(LocalDate.parse(dateOFBirth));
//                System.out.println("date of birthday is = " + account.getDateOfBirthLocalDate().toString());
//
//                System.out.println("type the fullName");
//                account.setFullName(reader.readLine());
//                System.out.println("fullName is = " + account.getFullName());
//
//                System.out.println("type the email");
//                account.setEmail(reader.readLine());
//                System.out.println("email is = " + account.getEmail());
//
//                insertCreditCard(creditCard.getCardNumber(),  creditCard.getCardHoderName(),
//                        creditCard.getExpiryDate(),  creditCard.getLimit(),  creditCard.getBalance());
//                insertAccount(account.getDateOfBirthLocalDate(), account.getFullName(),  account.getEmail());
//
//
//            } else if (s.equalsIgnoreCase("2")){
//
//                String findDescription = """
//               digite o que cartão numero do cartão ou nome do titular que deseja buscar os detalhes:
//               """;
//                System.out.println(findDescription);
//                //PESQUISAR POR QUE VARIAVEIS USADAS DENTRO DE UMA FUNÇÃO LAMBDA DEVEM SER ATOMICAS OU FINAL
//                String keySearch = reader.readLine();
//
//                /**
//                 * | Parte da regex   | Significado       | O que faz                                                                                                                |
//                 * | ---------------- | ----------------- | ------------------------------------------------------------------------------------------------------------------------ |
//                 * | .              | ponto             | Representa *qualquer caractere* (exceto quebra de linha). Ex: letra, número, símbolo.                                  |
//                 * | *              | asterisco         | Significa: “*zero ou mais vezes*” o que veio antes. No caso, .* = “qualquer caractere, repetido zero ou mais vezes”. |
//                 * | \d             | barra e d       | Representa um *dígito numérico, ou seja, **0 a 9*.                                                                   |
//                 * | .* (novamente) | ponto e asterisco | Igual ao primeiro: permite que **qualquer coisa venha depois do dígito**.                                                |
//                 *
//                 */
//                if (keySearch.matches(".\\d.")) {
//
//
//                    CreditCard2 creditCardByNumber = getCreditCardByNumber(keySearch);
//                    if(creditCardByNumber == null){
//                        System.out.println("Dados do cartão não encontrados");
//                        break;
//                    }
//
//                    System.out.println("Esses são os dados do cartão: ");
//                    System.out.println(creditCardByNumber.toString());
//
//
//                } else {
//                    //Associar um cartão com um ID e um usuário só depois de fazer os alunos pensarem
//                    //Aplicar a mudança na tabela para add chave estrangeira
//
//                    List<String> creditCardsByEmail = getCreditCardsByEmail(keySearch);
//
//                    if(creditCardsByEmail.isEmpty()){
//                        System.out.println("E-mail não tem associação com o cartão");
//                    } else {
//                        System.out.println("dados do cartão " + creditCardsByEmail.get(0).toString());
//                    }
//
//                }
//
//            } else if (s.equalsIgnoreCase("3")) {
//
//                AtomicBoolean cardNumberFounded = new AtomicBoolean(false);
//                String findDescription = """
//               digite o que cartão numero do cartão que recebera credito:
//               """;
//                System.out.println(findDescription);
//
//                String cardNumber = reader.readLine();
//
//                String value = """
//               Agora digite o valor a ser inserido:
//               """;
//
//                System.out.println(value);
//
//                double balanceValue = Double.parseDouble(reader.readLine());
//
//                CreditCard2 creditCard = getCreditCardByNumber(cardNumber);
//
//                if(creditCard == null){
//                    System.out.println("Cartao de credito não encontrado");
//                } else {
//
//                    if(balanceValue > creditCard.limit){
//                        System.out.println("Operação não pode ser concluída, valor maior que limite: ");
//                    } else {
//                        creditCard.setBalance(balanceValue);
//                        System.out.println("Esses são os dados do cartão: " + creditCard.toString());
//                    }
//
//                    updateCreditCardInDatabase(creditCard.getCardNumber(),creditCard.getBalance());
//
//                    System.out.println("saldo atualizado");
//                }
//
//
//
//
//            }
//        }
//
//    }
//
//    public static void insertAccount(LocalDate dateOfBirth, String fullName, String email) throws SQLException {
//        String sql = "INSERT INTO account (date_of_birth, full_name, email) VALUES (?, ?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setDate(1, java.sql.Date.valueOf(dateOfBirth));
//            stmt.setString(2, fullName);
//            stmt.setString(3, email);
//
//            stmt.executeUpdate();
//        }
//    }
//
//    public static void insertCreditCard(String cardNumber, String cardHolderName, YearMonth expiryDate, double limit, double balance) throws SQLException {
//        String sql = "INSERT INTO credit_card (card_number, card_holder_name, expiry_date, limit_amount, balance) VALUES (?, ?, ?, ?, ?)";
//
//        String expiry = expiryDate.toString(); // Format: "2025-12"
//
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, cardNumber);
//            stmt.setString(2, cardHolderName);
//            stmt.setString(3, expiry);
//            stmt.setDouble(4, limit);
//            stmt.setDouble(5, balance);
//
//            stmt.executeUpdate();
//        }
//    }
//
//    public static CreditCard2 getCreditCardByNumber(String cardNumber) throws SQLException {
//        String sql = "SELECT card_number, card_holder_name, expiry_date, limit_amount, balance FROM credit_card WHERE card_number = ?";
//
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, cardNumber);
//
//            try (ResultSet rs = stmt.executeQuery()) {
//
//                if (rs.next()) {
//                    System.out.println("search by  credit card result");
//                    System.out.println("Card Number: " + rs.getString("card_number"));
//                    System.out.println("Card Holder: " + rs.getString("card_holder_name"));
//                    System.out.println("Expiry Date: " + rs.getString("expiry_date"));
//                    System.out.println("Limit: " + rs.getDouble("limit_amount"));
//                    System.out.println("Balance: " + rs.getDouble("balance"));
//                    return new CreditCard2(rs.getString("card_number"),
//                            rs.getString("card_holder_name"),
//                            YearMonth.parse(rs.getString("expiry_date")),
//                            rs.getDouble("limit_amount"),
//                            rs.getDouble("balance"));
//
//                } else {
//                    System.out.println("Card not found.");
//                    return null;
//                }
//            }
//        }
//    }
//
//    public static List<String> getCreditCardsByEmail(String email) throws SQLException {
//        String sql = """
//            SELECT c.card_number, c.card_holder_name, c.expiry_date, c.limit_amount, c.balance
//            FROM credit_card c
//            JOIN account a ON c.card_holder_name = a.full_name
//            WHERE a.email = ?
//            """;
//
//        List<String> cards = new ArrayList<>();
//
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, email);
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    String cardInfo = String.format(
//                            "Card Number: %s | Holder: %s | Expiry: %s | Limit: %.2f | Balance: %.2f",
//                            rs.getString("card_number"),
//                            rs.getString("card_holder_name"),
//                            rs.getString("expiry_date"),
//                            rs.getDouble("limit_amount"),
//                            rs.getDouble("balance")
//                    );
//                    cards.add(cardInfo);
//                }
//            }
//        }
//
//        return cards;
//    }
//
//    private static void updateCreditCardInDatabase(String cardNumber, double limit) throws SQLException {
//        String sql = "update credit_card set balance = ? where card_number = ?";
//
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setDouble(1, limit);
//            stmt.setString(2, cardNumber);
//
//            stmt.executeUpdate();
//        }
//
//    }
//
//}