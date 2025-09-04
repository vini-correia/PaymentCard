package JavaClasses;

import java.time.LocalDate;

public class Account2 {
    LocalDate dayeOfBirthLocalDate;
    String fullName;
    String email;

    public Account2() {
    }

    public Account2(LocalDate dayeOfBirthLocalDate, String fullName, String email) {
        this.dayeOfBirthLocalDate = dayeOfBirthLocalDate;
        this.fullName = fullName;
        this.email = email;
    }

    public LocalDate getDateOfBirthLocalDate() {
        return dayeOfBirthLocalDate;
    }

    public void setDayeOfBirthLocalDate(LocalDate dayeOfBirthLocalDate) {
        this.dayeOfBirthLocalDate = dayeOfBirthLocalDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "dayeOfBirthLocalDate=" + dayeOfBirthLocalDate +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
