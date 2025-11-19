package JavaClasses.Model;

import java.time.LocalDate;

public class Account {

    private LocalDate dayOfBrithdat;
    private String fullName;
    private String email;
    private Long id;


    public Account() {

    }


    public LocalDate getDayOfBrithdat() {
        return dayOfBrithdat;
    }

    public void setDayOfBrithdat(LocalDate dayOfBrithdat) {
        this.dayOfBrithdat = dayOfBrithdat;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
        "data of birthday: " + dayOfBrithdat +
        "}";


    }
}
