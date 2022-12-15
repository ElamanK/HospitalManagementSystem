package com.hospital_management.users;
import com.hospital_management.exceptions.UserNotFoundException;
import com.hospital_management.staff.IStaff;
import com.hospital_management.utils.MyRandom;
import com.hospital_management.runner.AppRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Scanner;


public class Patient implements IStaff {
    private static final Logger LOGGER = LogManager.getLogger(Patient.class);
    Scanner scanner = new Scanner(System.in);

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
        LOGGER.info("Please enter patients email:");
        String patientEmail = scanner.nextLine();
        if (!patientEmail.endsWith("@gmail.com")) {
            LOGGER.info("Incorrect email, please use --@gmail.com");
            sendMessageToPatient();
        }
        LOGGER.info("Please type your message here and click enter to send");
        String message = scanner.next();
        if (!message.isEmpty()) {
            LOGGER.info("Your message sent");
            AppRunner.continueOperation();
        } else {
            LOGGER.info("Message field can not be empty");
            LOGGER.info("Please try again");
            sendMessageToPatient();
        }

    }


    @Override
    public String toString() {
        return "Patient first name__" + this.getFirstName()
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
        return Integer.parseInt(getPatientID());
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
        this.patientID = MyRandom.getRandomNumberAsString();
    }


    public void updatePatientDiagnose(String diagnose) {
        this.diagnosis = diagnose;
    }

    @Override
    public void createUser(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization) {

    }

    @Override
    public void updateUser(String userID) {
        boolean flag = false;
        for (int i = 0; i < Hospital.getPatientDir().size(); i++) {
            if (Hospital.getPatientDir().get(i).getPatientID().equals(userID)) {
                LOGGER.info("Please enter updated diagnose below:");
                String updatedDiagnose = scanner.nextLine();
                Hospital.getPatientDir().get(i).updatePatientDiagnose(updatedDiagnose);
                LOGGER.info("Patient diagnose is updated to " + updatedDiagnose + ".");
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            LOGGER.info("Patient is not found with given ID, please try again");

        }
    }

    @Override
    public void deleteUser(String userID) throws UserNotFoundException {
        for (int i = 0; i < Hospital.getPatientDir().size(); i++) {
            if (Hospital.getPatientDir().get(i).getPatientID().equals(userID)) {
                Hospital.getPatientDir().remove(i);
                break;
            }
        }
        throw new UserNotFoundException("Patient not found");
    }

    public void selectProvider(Patient patient, Doctor doctor){
            Hospital.getHealthProviders().put(patient,doctor);}

}
