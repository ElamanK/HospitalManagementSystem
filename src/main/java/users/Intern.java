package users;
import staff.IStaff;
import java.util.Scanner;

public class Intern extends Person implements IStaff {
    Scanner scanner = new Scanner(System.in);

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
                System.out.println("Please enter updated specialization below:");
                String updatedSpecialization = scanner.nextLine();
                Hospital.getInternDir().get(i).setSpecialization(updatedSpecialization);
                System.out.println("Intern specialization updated to " + updatedSpecialization + ".");
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Intern is not found with given ID, please try again");
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
