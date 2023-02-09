package database.patterns.builder;

import database.bankdb.models.Customer;

public class CustomerBuilder{

    private int customerId;
    private int accountId;
    private String firstname;
    private String lastname;
    private String address;
    private String emailAddress;
    private String phone;
    private String ssn;

    public CustomerBuilder(int customerId, int accountId, String firstname, String lastname, String address, String emailAddress, String phone, String ssn) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.ssn = ssn;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getSsn() {
        return ssn;
    }

    public Customer build(){
        return new Customer(this);
    }
}