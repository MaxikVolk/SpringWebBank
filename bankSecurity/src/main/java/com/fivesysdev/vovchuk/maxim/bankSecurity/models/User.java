package com.fivesysdev.vovchuk.maxim.bankSecurity.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "name")
    @NotBlank(message = "this should not be empty")
    @Size(min = 2, max = 32, message = "name must be between 2 and 32 characters long")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "this should not be empty")
    @Size(min = 2, max = 32, message = "surname must be between 2 and 32 characters long")
    private String surname;
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @Column(name = "sex")
    @NotBlank(message = "this should not be empty")
    @Size(min = 1, max = 6, message = "sex must be between 1 and 6 characters long")
    private String sex;
    @Column(name = "email")
    @NotBlank(message = "this should not be empty")
    @Email(message = "email should be in valid format")
    private String email;
    @Column(name = "password")
    @NotBlank(message = "this should not be empty")
    @Length(min = 8, message = "password should be at least 8 characters")
    private String password;
    @OneToMany(mappedBy = "owner")
    private List<Loan> loans;
    @OneToMany(mappedBy = "owner")
    private List<DebitCard> debitCards;

    public User(String name, String surname, String birthdate,
                String sex, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthdate = Date.valueOf(birthdate);
        this.sex = sex;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = Date.valueOf(birthdate);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<DebitCard> getDebitCards() {
        return debitCards;
    }

    public void setDebitCards(List<DebitCard> debitCards) {
        this.debitCards = debitCards;
    }

    public void addDebitCard(DebitCard card) {
        debitCards.add(card);
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
