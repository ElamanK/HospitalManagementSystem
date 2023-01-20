package data_base.bank_db.models;

import java.sql.Date;

public class Transactions {

    private int transactionId;
    private Date transactionDate;
    private double transactionAmount;
    private double newBalance;
    private int accountId;
    private int employeeId;
    private int transactionTypeId;

    public Transactions(){};

    public Transactions(Date transactionDate, double transactionAmount, double newBalance, int accountId, int employeeId, int transactionTypeId) {
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.newBalance = newBalance;
        this.accountId = accountId;
        this.employeeId = employeeId;
        this.transactionTypeId = transactionTypeId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Override
    public String toString() {
        return "transaction id: "+transactionId
                +"\ntransaction date: "+transactionDate
                +"\ntransaction amount: "+transactionAmount
                +"\nnew balance: "+newBalance
                +"\naccount id: "+accountId
                +"\nemployee id: "+employeeId
                +"\ntransaction type id: "+transactionTypeId;
    }
}
