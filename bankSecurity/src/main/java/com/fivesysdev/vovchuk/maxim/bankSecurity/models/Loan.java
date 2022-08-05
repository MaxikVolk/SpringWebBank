package com.fivesysdev.vovchuk.maxim.bankSecurity.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    @NotNull(message = "date should not be empty")
    private Date date;
    @Column(name = "sum")
    @NotNull(message = "sum should not be empty")
    private double sum;
    @Column(name = "percent")
    @NotNull(message = "percent should not be empty")
    @Min(value = 0, message = "percent should be more than 0")
    @Max(value = 100, message = "percent should be less than 100")
    private double perc;
    @Column(name = "period")
    @NotNull(message = "this should not be empty")
    private int period;
    @Column(name = "monthly_payment")
    @NotNull(message = "this should not be empty")
    private double monthlyPayment;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    public Loan(String date, double sum, double perc,
                int period, double monthlyPayment) {
        this.date = Date.valueOf(date);
        this.sum = sum;
        this.perc = perc;
        this.period = period;
        this.monthlyPayment = monthlyPayment;
    }

    public Loan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Date.valueOf(date);
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getPerc() {
        return perc;
    }

    public void setPerc(double perc) {
        this.perc = perc;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Date: " + date + '\n' +
                "Sum: " + sum + '\n' +
                "Percent: " + perc + '\n' +
                "Period: " + period + '\n' +
                "Monthly payment: " + monthlyPayment;
    }
}
