//package Org.exemple.service;
//
//import JavaClasses.Model.CreditCard;
//import JavaClasses.Service.AccountService;
//import JavaClasses.Service.CreditCardService;
//import JavaClasses.dao.AccountDao;
//import JavaClasses.dao.CreditCardDao;
//import org.junit.jupiter.api.Test;
//
//import javax.accessibility.AccessibleContext;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.time.YearMonth;
//
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//public class CreditCardServiceTest {
//
//    private BufferedReader reader;
//    private CreditCardDao creditCardDao;
//    private CreditCardService creditCardService;
//
//    @Test
//    void testCreateCreditCard() throws IOException, SQLException {
//
//        BufferedReader reader1 = mock(BufferedReader.class);
//        CreditCardDao creditCardDao = mock(CreditCardDao.class);
//
//        CreditCardService creditCardService = new CreditCardService(reader1, creditCardDao);
//
//        when(reader1.readLine())
//                .thenReturn("Vinicius correia")
//                .thenReturn(("112233"))
//                .thenReturn("2028-12")
//                .thenReturn("3000");
//
//        creditCardService.CreateCreditCard();
//
//        verify(creditCardDao).insertCredit_Card(
//                eq("Vinicius correia"),
//                eq("112233"),
//                eq(YearMonth.of(2028, 12)),
//                eq(3000.0)
//        );
//    }
//}