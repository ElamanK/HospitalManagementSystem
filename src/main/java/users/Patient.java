package users;


import interfaces.StaffInterface;
import runner.AppRunner;

import java.util.Random;
import java.util.Scanner;


public class Patient implements StaffInterface {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String age;
    private String bloodGroup;
    private String diagnosis;
    private String hospitalizationDate;
    private String patientID;

    public Patient() {
    }

    public final void sendMessageToPatient() {
        System.out.println("Please enter patients email:");
        String patientEmail = scanner.nextLine();
        if (!patientEmail.endsWith("@gmail.com")) {
            System.out.println("Incorrect email, please use --@gmail.com");
            sendMessageToPatient();
        }
        System.out.println("Please type your message here and click enter to send");
        String message = scanner.next();
        if (!message.isEmpty()) {
            System.out.println("Your message sent");
            AppRunner.continueOperation();
        } else {
            System.out.println("Message field can not be empty");
            System.out.println("Please try again");
            sendMessageToPatient();
        }

    }




    @Override
    public String toString() {
        return "Patient first name__" + this.getFirstName()
                + "\n" + "Patient last name__" + this.getLastName()
                + "\n" + "Patient last name__" + this.getLastName()
                + "\n" + "Patient phone number__" + this.getPhoneNumber()
                + "\n" + "Patient gender__" + this.getGender()
                + "\n" + "Patient age__" + this.getAge()
                + "\n" + "Patient blood group__" + this.getBloodGroup()
                + "\n" + "Patient diagnosis__" + this.getDiagnosis()
                + "\n" + "Patient hospitalizationDate__" + this.getHospitalizationDate()
                + "\n" + "Patient  ID__ " + this.getPatientID();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(String hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }



    public void createPatient(String firstName, String lastName, String phoneNumber, String gender, String age, String bloodGroup, String diagnosis, String hospitalizationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.diagnosis = diagnosis;
        this.hospitalizationDate = hospitalizationDate;
        this.patientID = String.valueOf(random.nextInt(5000));
    }


    public void updatePatientDiagnose(String diagnose) {
        this.diagnosis = diagnose;
    }

    @Override
    public void createUser(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization) {

    }

    @Override
    public void updateUserSpecialization(String userID) {
        boolean flag = false;
        for (int i = 0; i < Hospital.getPatientDir().size(); i++) {
            if (Hospital.getPatientDir().get(i).getPatientID().equals(userID)) {
                System.out.println("Please enter updated diagnose below:");
                String updatedDiagnose = scanner.nextLine();
                Hospital.getPatientDir().get(i).updatePatientDiagnose(updatedDiagnose);
                System.out.println("Patient diagnose is updated to " + updatedDiagnose + ".");
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Patient is not found with given ID, please try again");

        }
    }

    @Override
    public void deleteUser(String userID) {
        for (int i = 0; i < Hospital.getPatientDir().size(); i++) {
            if (Hospital.getPatientDir().get(i).getPatientID().equals(userID)) {
                Hospital.getPatientDir().remove(i);
                System.out.println("==============================");
                System.out.println("===== Patient is deleted =====");
                System.out.println("==============================");
                break;
            }
        }
        System.out.println("Patient is not found");
    }
}
