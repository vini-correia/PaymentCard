package JavaClasses;

//import JavaClasses.anotations.LogExecution;

import java.time.YearMonth;

public class CreditCard2 {

    String cardNumber;
    String cardHoderName;
    YearMonth expiryDate;
    double limit;

    double balance;

    public CreditCard2() {
    }

    public CreditCard2(String cardNumber, String cardHoderName, YearMonth expiryDate, double limit) {
        this.cardNumber = cardNumber;
        this.cardHoderName = cardHoderName;
        this.expiryDate = expiryDate;
        this.limit = limit;
    }

    public CreditCard2(String cardNumber, String cardHoderName, YearMonth expiryDate, double limit, double balance) {
        this.cardNumber = cardNumber;
        this.cardHoderName = cardHoderName;
        this.expiryDate = expiryDate;
        this.limit = limit;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    //@LogExecution()
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHoderName() {
        return cardHoderName;
    }

    public void setCardHoderName(String cardHoderName) {
        this.cardHoderName = cardHoderName;
    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(YearMonth expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CreditCard2{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHoderName='" + cardHoderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", limit=" + limit +
                ", balance=" + balance +
                '}';
    }
}