package JavaClasses.Service;

import JavaClasses.Model.Account;
import JavaClasses.dao.AccountDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AccountService {

    AccountDao accountDao;

    BufferedReader reader;

    public AccountService(BufferedReader reader, AccountDao accountDao){
        this.reader = reader;
        this.accountDao = accountDao;
    }


    public void createAccount () throws IOException {


        Account account = new Account();

        System.out.println("When is your birthday? (YYYY-MM-DD): ");
        LocalDate birthday = LocalDate.parse(reader.readLine());

        System.out.println("Type the fullname: ");
        String fullName = reader.readLine();

        System.out.println("Type the email: ");
        String email = reader.readLine();

        try {
            accountDao.insertAccount(birthday, fullName, email);
            System.out.println("Account registered successfully in the database!");
        } catch (SQLException e) {
            System.err.println("Error registering account: " + e.getMessage());
        }

    }

}
