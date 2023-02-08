package database.patterns.builder;

import database.bankdb.models.Employee;

public class EmployeeBuilder {

    private int id;
    private String firstname;
    private String lastname;


    public EmployeeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public EmployeeBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Employee build() {
        return new Employee(this);
    }
}


