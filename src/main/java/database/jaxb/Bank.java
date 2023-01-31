package database.jaxb;
import database.bankdb.models.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="bank")
@XmlType(propOrder = {"customersList","employeesList","transactionsList","accountTypeList","accountStatusTypeList","transactionTypeList"})
public class Bank {

    private List<Customer> customerList;
    private List<Employee> employeeList;
    private List<Transaction> transactionsList;
    private List<AccountType> accountTypeList;
    private List<AccountStatusType> accountStatusTypeList;
    private List<TransactionType> transactionTypeList;

    public Bank(){}

    public Bank(List<Customer> customerList, List<Employee> employeeList, List<Transaction> transactionsList, List<AccountType> accountTypeList, List<AccountStatusType> accountStatusTypeList, List<TransactionType> transactionTypeList) {
        this.customerList = customerList;
        this.employeeList = employeeList;
        this.transactionsList = transactionsList;
        this.accountTypeList = accountTypeList;
        this.accountStatusTypeList = accountStatusTypeList;
        this.transactionTypeList = transactionTypeList;
    }

    public List<Customer> getCustomersList() {
        return customerList;
    }

    public List<AccountStatusType> getAccountStatusTypeList() {
        return accountStatusTypeList;
    }

    public void setAccountStatusTypeList(List<AccountStatusType> accountStatusTypeList) {
        this.accountStatusTypeList = accountStatusTypeList;
    }

    public List<TransactionType> getTransactionTypeList() {
        return transactionTypeList;
    }

    public void setTransactionTypeList(List<TransactionType> transactionTypeList) {
        this.transactionTypeList = transactionTypeList;
    }

    @XmlElementWrapper(name="customers")
    @XmlElement(name="customer",type = Customer.class)
    public void setCustomersList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Employee> getEmployeesList() {
        return employeeList;
    }
    @XmlElementWrapper(name="employees")
    @XmlElement(name="employee",type = Employee.class)
    public void setEmployeesList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }

    @XmlElementWrapper(name="transactions")
    @XmlElement(name="transaction",type = Transaction.class)
    public void setTransactionsList(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public List<AccountType> getAccountTypeList() {
        return accountTypeList;
    }

    @XmlElementWrapper(name="account-types")
    @XmlElement(name="account-type",type = AccountType.class)
    public void setAccountTypeList(List<AccountType> accountTypeList) {
        this.accountTypeList = accountTypeList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "customersList=" + customerList +
                ", employeesList=" + employeeList +
                ", transactionsList=" + transactionsList +
                ", accountTypeList=" + accountTypeList +
                ", accountStatusTypeList=" + accountStatusTypeList +
                ", transactionTypeList=" + transactionTypeList +
                '}';
    }
}
