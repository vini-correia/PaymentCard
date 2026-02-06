package br.com.payments.Model;

//import JavaClasses.anotations.LogExecution;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard{

    @Id
    @Column (name = "card_number")
    String cardNumber;

    @Column(name = "card_holder_name")
    String cardHolderName;

    @Column (name = "expiry_date")
    String expiryDate;

    @Column (name = "limit_amount")
    Double limit;

    @Column
    Double balance;

    @Column(name = "account_id")
    private Long accountId;

    public CreditCard() {
    }

    public CreditCard(String cardNumber, String cardHolderName, String expiryDate, double limit) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.limit = limit;
        this.balance = null;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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