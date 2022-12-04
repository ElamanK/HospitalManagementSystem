package users;
import exceptions.InvalidUserIdException;
import exceptions.UserNotFoundException;
import prescription.Prescription;
import staff.IStaff;
import java.util.Objects;
import java.util.Scanner;

public class Doctor extends Person implements IStaff {


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
        Scanner scanner = new Scanner(System.in);
        boolean ifDoctorNotFound = true;
        for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
            if (Hospital.getDoctorDir().get(i).getPersonID().equals(userID)) {
                System.out.println("Please enter updated specialization below:");
                String updatedSpecialization = scanner.nextLine();
                Hospital.getDoctorDir().get(i).setSpecialization(updatedSpecialization);
                System.out.println("Doctors specialization is updated to " + updatedSpecialization + ".");
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
                System.out.println("==============================");
                System.out.println("===== Doctor is deleted ======");
                System.out.println("==============================");
                break;
            }
        }
        if (ifDoctorNotFound){
            throw new InvalidUserIdException("Incorrect doctor ID, please try again");
        }
    }

    public static void prescribeMedicine() throws UserNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter doctor name_");
        String docName = scanner.nextLine();
        Doctor doctor = Hospital.getDoctorByName(docName);
        if (doctor==null){
            throw new UserNotFoundException("User does not exist");
        }
        System.out.println("Please enter patient name_");
        String patientName = scanner.nextLine();
        Patient patient = Hospital.getPatientByName(patientName);
        if(patient==null){
            throw new UserNotFoundException("Patient does not exist");
        }
        System.out.println("Type your prescription below:");
        String medicine = scanner.nextLine();
        System.out.println("Please enter date");
        String date = scanner.nextLine();

        Prescription prescription = new Prescription();
        prescription.prescribe(doctor, patient, medicine, date);
    }

}
