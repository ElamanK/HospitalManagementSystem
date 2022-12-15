package com.hospital_management.users;
import com.hospital_management.staff.IStaff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Intern extends Person implements IStaff {
    Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(Nurse.class);
    @Override
    public String toString() {
        return "Intern first name__"+this.getFirstName()
                +"\n"+"Intern last name__"+this.getLastName()
                +"\n"+"Intern ID__"+this.getPersonID()
                +"\n"+"Intern phone number__"+this.getPhoneNumber()
                +"\n"+"Intern gender__"+this.getGender()
                +"\n"+"Intern age__"+this.getAge()
                +"\n"+"Intern specialization__"+this.getSpecialization();
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(personID);
    }
    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
    @Override
    public void createUser(String firstName, String lastName, String internID, String phoneNumber, String gender, String age, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personID = internID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.specialization = specialization;
    }
    @Override
    public void updateUser(String userID)  {
        boolean flag = false;
        for (int i = 0; i < Hospital.getInternDir().size(); i++) {
            if (Hospital.getInternDir().get(i).getPersonID().equals(userID)) {
                LOGGER.info("Please enter updated specialization below:");
                String updatedSpecialization = scanner.nextLine();
                Hospital.getInternDir().get(i).setSpecialization(updatedSpecialization);
                LOGGER.info("Intern specialization updated to " + updatedSpecialization + ".");
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            LOGGER.info("Intern is not found with given ID, please try again");
        }
    }

    @Override
    public void deleteUser(String internID) {
        for (int i = 0; i< Hospital.getInternDir().size(); i++) {
            if(Hospital.getInternDir().get(i).personID.equals(internID)){
                Hospital.getInternDir().remove(i);
                break;
            }
        }
    }

}
