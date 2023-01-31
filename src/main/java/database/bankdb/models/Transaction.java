package database.bankdb.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import database.jaxb.TimeStampAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;

@XmlRootElement(name = "transaction")
@XmlType(propOrder = {"transactionId","transactionDate","transactionAmount", "newBalance", "accountId", "employeeId", "transactionTypeId"})
public class Transaction {
    @JsonProperty
    private int transactionId;
    @JsonProperty
    private Timestamp transactionDate;
    @JsonProperty
    private double transactionAmount;
    @JsonProperty
    private double newBalance;
    @JsonProperty
    private int accountId;
    @JsonProperty
    private int employeeId;
    @JsonProperty
    private int transactionTypeId;

    public Transaction() {
    }

    public Transaction(int transactionId, Timestamp transactionDate, double transactionAmount, double newBalance, int accountId, int employeeId, int transactionTypeId) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.newBalance = newBalance;
        this.accountId = accountId;
        this.employeeId = employeeId;
        this.transactionTypeId = transactionTypeId;
    }

    public Transaction(Timestamp transactionDate, double transactionAmount, double newBalance, int accountId, int employeeId, int transactionTypeId) {
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

    @XmlAttribute(name = "id")
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    @XmlJavaTypeAdapter(TimeStampAdapter.class)
    @XmlElement(name = "date")
    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    @XmlElement(name = "transaction-amount")
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getNewBalance() {
        return newBalance;
    }

    @XmlElement(name = "new-balance")
    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }


    public int getAccountId() {
        return accountId;
    }

    @XmlElement(name = "account-id")
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @XmlElement(name = "employee-id")
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    @XmlElement(name = "transaction-type-id")
    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Override
    public String toString() {
        return "transaction id: " + transactionId
                + "\ntransaction date: " + transactionDate
                + "\ntransaction amount: " + transactionAmount
                + "\nnew balance: " + newBalance
                + "\naccount id: " + accountId
                + "\nemployee id: " + employeeId
                + "\ntransaction type id: " + transactionTypeId;
    }
}
