package com.fivesysdev.vovchuk.maxim.bankSecurity.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Table(name = "debit_cards")
public class DebitCard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "balance")
    @Min(value = 0)
    private double balance;
    @Column(name = "number")
    @Min(value = 1000000000000000L, message = "number should be 16 characters long")
    @Max(value = 9999999999999999L, message = "number should be 16 characters long")
    @NotNull(message = "number should not be empty")
    private long number;

    @Column(name = "end_date")
    @NotNull(message = "date should not be empty")
    private Date endDate;
    @Column(name = "cvv")
    @NotNull(message = "this should not be empty")
    @Min(value = 100)
    @Max(value = 999)
    private short cvv;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    public DebitCard(
            double balance, long number, String endDate, short cvv) {
        this.balance = balance;
        this.number = number;
        this.endDate = Date.valueOf(endDate);
        this.cvv = cvv;
    }

    public DebitCard(long number, String endDate, short cvv) {
        this.number = number;
        this.endDate = Date.valueOf(endDate);
        this.cvv = cvv;
        balance = 0;
    }

    public DebitCard() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = Date.valueOf(endDate);
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "id=" + id +
                ", balance=" + balance +
                ", number=" + number +
                ", endDate='" + endDate + '\'' +
                ", cvv=" + cvv +
                ", owner=" + owner +
                '}';
    }
}
