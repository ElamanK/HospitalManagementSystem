package database.bankdb.models;

import database.patterns.builder.CustomerBuilder;

public class Customer {

    private int customerId;
    private int accountId;
    private String firstname;
    private String lastname;
    private String address;
    private String emailAddress;
    private String phone;
    private String ssn;

    public Customer(){};

    public Customer(int accountId, String firstname, String lastname, String address, String emailAddress, String phone, String ssn) {
        this.accountId = accountId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.ssn = ssn;
    }

    public Customer(int customerId, int accountId, String firstname, String lastname, String address, String emailAddress, String phone, String ssn) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.ssn = ssn;
    }

    public Customer(CustomerBuilder customerBuilder){
        this.customerId = customerBuilder.getCustomerId();
        this.accountId = customerBuilder.getAccountId();
        this.firstname = customerBuilder.getFirstname();
        this.lastname = customerBuilder.getLastname();
        this.address = customerBuilder.getAddress();
        this.emailAddress = customerBuilder.getEmailAddress();
        this.phone = customerBuilder.getPhone();
        this.ssn = customerBuilder.getSsn();
    }

    @Override
    public String toString() {
        return "id: "+this.customerId
                +"\n"+"account id: "+this.accountId
                +"\n"+"firstname: "+this.firstname
                +"\n"+"lastname: "+this.lastname
                +"\n"+"address: "+this.address
                +"\n"+"email address: "+this.emailAddress
                +"\n"+"phone: "+this.phone
                +"\n"+"ssn: "+this.ssn;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
