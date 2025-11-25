package JavaClasses;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "account")
public class Account2 {

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

    public Account2() {
    }

    public LocalDate getDateOfBirthLocalDate() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Account2(long id, LocalDate birthDay, String fullName, String email) {
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
