package database.bankdb.models;

import database.patterns.builder.EmployeeBuilder;

public class Employee {

    private int id;
    private String firstname;
    private String lastname;

    public Employee(){}

    public Employee(EmployeeBuilder employeeBuilder) {
        this.id=employeeBuilder.getId();
        this.firstname = employeeBuilder.getFirstname();
        this.lastname = employeeBuilder.getLastname();
    }

    @Override
    public String toString() {
        return "id: "+this.id
                +"\nfirstname: "+this.firstname
                +"\nlastname: "+this.lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
