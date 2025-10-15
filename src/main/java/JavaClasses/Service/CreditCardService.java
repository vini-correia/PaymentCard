package JavaClasses.Service;

import JavaClasses.dao.CreditCardDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.YearMonth;

public class CreditCardService {

    CreditCardDao creditCardDao;

    BufferedReader reader;

    public CreditCardService(BufferedReader reader,  CreditCardDao creditCardDao) {
        this.reader = reader;
        this.creditCardDao = creditCardDao;
    }

    public void CreateCreditCard() throws SQLException, IOException {


        System.out.println("Type the card holder name: ");
        String cardHolderName = reader.readLine();

        System.out.println("Type the card number: ");
        String cardNumber = reader.readLine();

        System.out.println("Type the card expiry date (YYYY-MM):");
        YearMonth expiryDateValue = YearMonth.parse(reader.readLine());

        System.out.println("escreva o limite do seu cartão: ");
        double limitValue = Double.parseDouble(reader.readLine());

        try {
            creditCardDao.insertCredit_Card(cardHolderName, cardNumber, expiryDateValue, limitValue );
            System.out.println("Card registered successfully in the database!");
        } catch (SQLException e) {
            System.err.println("Error registering card: " + e.getMessage());
        }
    }
}
