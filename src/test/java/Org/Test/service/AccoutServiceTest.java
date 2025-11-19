//package Org.exemple.service;
//
//import JavaClasses.Service.AccountService;
//import JavaClasses.dao.AccountDao;
//import org.junit.jupiter.api.Test;
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.time.LocalDate;
//
//import static org.mockito.Mockito.*;
//
//@Service
//
//public class AccoutServiceTest {
//
//
//    private BufferedReader reader;
//
//    private AccountDao accountDao;
//
//    private AccountService accountService;
//
//    @Test
//    void testCreateAccountWithSuccess() throws IOException, SQLException {
//
//        BufferedReader reader = mock(BufferedReader.class);
//        AccountDao accountDao = mock(AccountDao.class);
//
//        AccountService accountService = new AccountService(reader, accountDao);
//
//        when(reader.readLine())
//                .thenReturn("2005-06-24")
//            .thenReturn("Vinicius")
//            .thenReturn("vinicius@gmail.com");
//
//        accountService.createAccount();
//
//        verify(accountDao).insertAccount(
//                eq(LocalDate.of(2005, 06, 24)),
//                eq("Vinicius"),
//                eq("vinicius@gmail.com")
//        );
//
//    }
//}
