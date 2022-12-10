package com.hospital_management.users;

import com.hospital_management.exceptions.NegativeAgeException;

public class Person {
    public String firstName;
    public String lastName;
    public String personID;
    public String phoneNumber;
    public String gender;
    public String age;
    public String specialization;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPersonID() {
        return personID;
    }
    public void setPersonID(String personID) {
        this.personID = personID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public static void validateAgeOfPerson(String age) throws NegativeAgeException {
        if (Integer.parseInt(age)<0){
            throw new NegativeAgeException("Age cannot be less than 0 ");
        }
    }
}
