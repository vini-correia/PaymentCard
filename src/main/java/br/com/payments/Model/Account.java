package br.com.payments.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_of_birthday")
    private LocalDate birthDay;

    @Column (name = "full_name")
    private String fullName;

    @Column
    private String email;

    @CreationTimestamp
    @Column (name = "creation_date")
    private LocalDateTime creationDate;

    public Account() {
    }

    public Account(String fullName, LocalDate birthDay, String email) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.email = email;
    }

    public LocalDate getDateOfBirthLocalDate() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Account(long id, LocalDate birthDay, String fullName, String email) {
        this.birthDay = birthDay;
        this.fullName = fullName;
        this.email = email;
        this.id = id;

    }

    public String getFullName() {
        return fullName;
    }

    public Long getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "dayeOfBirthLocalDate=" + birthDay +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
