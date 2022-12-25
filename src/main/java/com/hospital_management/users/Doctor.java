package com.hospital_management.users;
import com.hospital_management.exceptions.InvalidUserIdException;
import com.hospital_management.prescription.Prescription;
import com.hospital_management.staff.IStaff;
import com.hospital_management.exceptions.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Doctor extends Person implements IStaff {
    private static final Logger LOGGER = LogManager.getLogger(Doctor.class);

    @Override
    public String toString() {
        return "Doctor first name__" + this.getFirstName()
                + "\n" + "Doctor last name__" + this.getLastName()
                + "\n" + "Doctor ID__" + this.getPersonID()
                + "\n" + "Doctors phone number__" + this.getPhoneNumber()
                + "\n" + "Doctors gender__" + this.getGender()
                + "\n" + "Doctors age__" + this.getAge()
                + "\n" + "Doctors specialization__" + this.getSpecialization();
    }
    @Override
    public int hashCode() {
        return Integer.parseInt(personID);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;
        if(!Objects.equals(this.firstName, ((Doctor) obj).firstName)) return false;
        return false;
    }
    @Override
    public void createUser(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personID = docID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.specialization = specialization;
    }
    @Override
    public void updateUser(String userID) throws UserNotFoundException {
        UnaryOperator<String> unaryStrUpperCase = s -> s.toUpperCase();
        Scanner scanner = new Scanner(System.in);
        boolean ifDoctorNotFound = true;
        for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
            if (Hospital.getDoctorDir().get(i).getPersonID().equals(userID)) {
                LOGGER.info("Please enter updated specialization below:");
                String updatedSpecialization = scanner.nextLine();
                Hospital.getDoctorDir().get(i).setSpecialization(updatedSpecialization);
                LOGGER.info("Doctors specialization is updated to " + unaryStrUpperCase.apply(updatedSpecialization) + ".");
                ifDoctorNotFound = false;
            }
        }
        if (ifDoctorNotFound){
            throw new UserNotFoundException("Doctor is not found");
        }
    }
    @Override
    public void deleteUser(String userID) throws InvalidUserIdException {
        boolean ifDoctorNotFound = true;
        for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
            if (Hospital.getDoctorDir().get(i).getPersonID().equals(userID)) {
                Hospital.getDoctorDir().remove(i);
                ifDoctorNotFound=false;
                LOGGER.info("===== Doctor is deleted ======");
                break;
            }
        }
        if (ifDoctorNotFound){
            throw new InvalidUserIdException("Incorrect doctor ID");
        }
    }
    public static void prescribeMedicine() throws UserNotFoundException {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Please enter doctor name_");
        String docName = scanner.nextLine();
        Doctor doctor = Hospital.getDoctorByName(docName);
        if (doctor==null){
            throw new UserNotFoundException("User does not exist");
        }
        LOGGER.info("Please enter patient name_");
        String patientName = scanner.nextLine();
        Patient patient = Hospital.getPatientByName(patientName);
        if(patient==null){
            throw new UserNotFoundException("Patient does not exist");
        }
        LOGGER.info("Type your prescription below:");
        String medicine = scanner.nextLine();
        LOGGER.info("Please enter date");
        String date = scanner.nextLine();
        Prescription prescription = new Prescription();
        prescription.prescribe(doctor, patient, medicine, date);
    }

}
