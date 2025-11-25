package JavaClasses;

//import JavaClasses.anotations.LogExecution;

import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.time.YearMonth;

@Entity
@Table(name = "credit_card")
public class CreditCard2 {

    @Id
    @Column (name = "card_number")
    String cardNumber;

    @Column(name = "card_holder_name")
    String cardHolderName;

    @Column (name = "expiry_date")
    String expiryDate;

    @Column (name = "limit_amount")
    double limit;

    @Column
    double balance;

    public CreditCard2() {
    }

    public CreditCard2(String cardNumber, String cardHolderName, String expiryDate, double limit) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.limit = limit;
        this.balance = 0;
    }


    public String getCardNumber() {
        return cardNumber;
    }
    //@LogExecution()
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHoderName) {
        this.cardHolderName = cardHoderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
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
                ", cardHoderName='" + cardHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", limit=" + limit +
                ", balance=" + balance +
                '}';
    }
}