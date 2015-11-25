package no.northcode.java.homework.ATM;

import java.util.Date;

public class Account {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    
    public static final double defaultAnnualInterestRate = 0;
    
    public Account() {
	id = 0;
	balance = 0;
	annualInterestRate = defaultAnnualInterestRate;
	dateCreated = new Date();
    }
    
    public Account(int id, double balance) {
	this.id = id;
	this.balance = balance;
	this.annualInterestRate = Account.defaultAnnualInterestRate;
	this.dateCreated = new Date();
    }
    
    public int getId() { return id; }
    public double getBalance() { return balance; }
    public double getAnnualInterestRate() { return id; }
    
    public void setId(int id) { this.id = id; }
    public void setBalance(int balance) { this.balance = balance; }
    public void setAnnualInterestRate(int annualInterestRate) { this.annualInterestRate = annualInterestRate; }
    
    public Date getDateCreated() { return dateCreated; }
    
    public double getMonthlyInterestRate() { return this.annualInterestRate / 12; }
    public double getMonthlyInterest() { return balance * getMonthlyInterestRate(); }
    
    public void withdraw(double amount) { this.balance -= amount; }
    public void deposit(double amount)  { this.balance += amount; }
}

