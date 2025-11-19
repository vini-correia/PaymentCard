package JavaClasses.Model;

//import JavaClasses.anotations.LogExecution;
import org.springframework.stereotype.Component;

import java.time.YearMonth;

@Component

public class CreditCard {

    private String cardHoldName;
    private String cardHoldNumber;
    private YearMonth expiryDate;
    private double limit;
    private double balance;

    public CreditCard() {}

    public CreditCard(String cardHoldName, String cardHoldNumber, YearMonth expiryDate, double balance, double limit ) {
        this.cardHoldName = cardHoldName;
        this.cardHoldNumber = cardHoldNumber;
        this.expiryDate = expiryDate;
        this.limit = limit;
        this.balance = balance;
    }

    public String getCardHolNumber() {
        return cardHoldNumber;
    }

    //@LogExecution
    public void setCardHolNumber(int cardHolNumber) {
        this.cardHoldNumber = cardHoldNumber;
    }

    public String getCardHoldName() {
        return cardHoldName;
    }

    public void setCardHoldName(String cardHoldName) {
        this.cardHoldName = cardHoldName;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(YearMonth expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CredtCard {" +
                "Titular=" + cardHoldName + "\'" +
                ", Numero=" + cardHoldNumber +
                ", Validade=" + expiryDate +
                ", Limite=" + limit +
                ", Saldo=" + balance +
                "}";
    }

}
