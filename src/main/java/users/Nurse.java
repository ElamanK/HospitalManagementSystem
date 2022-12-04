package users;


import staff.IStaff;

import java.util.Scanner;


public class Nurse extends Person implements IStaff {

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
    public void updateUser(String userID) {
        boolean flag = false;
        for (int i = 0; i < Hospital.getNurseDir().size(); i++) {
            if (Hospital.getNurseDir().get(i).getPersonID().equals(userID)) {
                System.out.println("Please enter updated specialization below:");
                String updatedSpecialization = scanner.nextLine();
                Hospital.getNurseDir().get(i).setSpecialization(updatedSpecialization);
                System.out.println("Nurse specialization updated to " + updatedSpecialization + ".");
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Nurse is not found with given ID, please try again");

        }
    }

    @Override
    public void deleteUser(String userID) {
        for (int i = 0; i< Hospital.getNurseDir().size(); i++) {
            if(Hospital.getNurseDir().get(i).getPersonID().equals(userID)){
                Hospital.getNurseDir().remove(i);
                break;
            }
        }
    }
}
