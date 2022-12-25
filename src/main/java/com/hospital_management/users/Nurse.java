package com.hospital_management.users;
import com.hospital_management.exceptions.UserNotFoundException;
import com.hospital_management.staff.IStaff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;


public class Nurse extends Person implements IStaff {
    private static final Logger LOGGER = LogManager.getLogger(Nurse.class);
    Scanner scanner = new Scanner(System.in);

    @Override
    public int hashCode() {
        return Integer.parseInt(getPersonID());
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        return "Nurse first name__" + this.getFirstName()
                + "\n" + "Nurse last name__" + this.getLastName()
                + "\n" + "Nurse ID__" + this.getPersonID()
                + "\n" + "Nurse phone number__" + this.getPhoneNumber()
                + "\n" + "Nurse gender__" + this.getGender()
                + "\n" + "Nurse age__" + this.getAge()
                + "\n" + "Nurse specialization__" + this.getSpecialization();
    }

    @Override
    public void createUser(String firstName, String lastName, String nurseID, String phoneNumber, String gender, String age, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personID = nurseID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.specialization = specialization;
    }

    @Override
    public void updateUser(String userID) throws UserNotFoundException {
        boolean flag = false;
        for (int i = 0; i < Hospital.getNurseDir().size(); i++) {
            if (Hospital.getNurseDir().get(i).getPersonID().equals(userID)) {
                LOGGER.info("Please enter updated specialization below:");
                String updatedSpecialization = scanner.nextLine();
                Hospital.getNurseDir().get(i).setSpecialization(updatedSpecialization);
                LOGGER.info("Nurse specialization updated to " + updatedSpecialization + ".");
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            throw new UserNotFoundException("Nurse is not found with given ID, please try again");

        }
    }

    @Override
    public void deleteUser(String userID) {
        for (int i = 0; i < Hospital.getNurseDir().size(); i++) {
            if (Hospital.getNurseDir().get(i).getPersonID().equals(userID)) {
                Hospital.getNurseDir().remove(i);
                break;
            }
        }
    }
}
