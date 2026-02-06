package br.com.payments;

//import JavaClasses.Model.CreditCard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;

@SpringBootApplication

public class MainClone {
    private static BufferedReader rd;

//    private static final String URL = "jdbc:postgresql://localhost:3306/payment_card";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "vini240605";

    public static void main(String[] args) throws IOException, SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(MainClone.class, args);
//        CreditCard creditCard = context.getBean(CreditCard.class);
//        creditCard.setCardHolNumber(123);
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        AccountDao accountDao = new AccountDao();
//
//        CreditCardDao creditCardDao = new CreditCardDao();
//
//
//        while (true) {
//            String description = """
//
//                    chose one option:
//                    1- register a card and your dates
//                    2- search your card number
//                    3- Make a purchase and update balance
//                    4- create only account with yours dates""";
//
//            System.out.println(description);
//            String option = reader.readLine();
//
//            if (option.equals("1")) {
//                CreditCardService creditCardService = new CreditCardService(reader, creditCardDao);
//                creditCardService.CreateCreditCard();
//
//
//            } else if (option.equals("2")) {
//                System.out.println("Digite o número do seu cartão ou o nome do titular do cartão: ");
//                String cartaoAtual = reader.readLine();
//
//                if (cartaoAtual.matches("\\d+")) {
//                    creditCardDao.getCreditCardByNumber(cartaoAtual);
//                    Long.parseLong(cartaoAtual);
//                    System.out.println("O número do cartão é "  + cartaoAtual);
//
//                }else {
//                    List<String> creditCardList = creditCardDao.getCreditCardsByFullName(cartaoAtual);
//
//                    if(creditCardList.isEmpty()){
//                        System.out.println("Cartão não encontrado");
//                    } else{
//                        System.out.println("dados do cartão: " + creditCardList.get(0).toString());
//                    }
//
//                }
//
//            } else if (option.equals("4")) {
//                AccountService accountService = new AccountService(reader, accountDao);
//                accountService.createAccount();
//
//
//
//
//            }
//        }
    }

}