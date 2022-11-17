import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Patient implements PatientInterface {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public static ArrayList<Patient> patientDir = new ArrayList<>();

    public Patient() {
    }

    public final void sendMessageToPatient(){
        System.out.println("Please enter patients email:");
        String patientEmail = scanner.nextLine();
        if (!patientEmail.endsWith("@gmail.com")){
            System.out.println("Incorrect email, please use --@gmail.com");
            sendMessageToPatient();
        }
        System.out.println("Please type your message here and click enter to send");
        String message = scanner.next();
        if(!message.isEmpty()){
            System.out.println("Your message sent");
        }else{
            System.out.println("Message field can not be empty");
            System.out.println("Please try again");
        }

    }

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String age;
    private String bloodGroup;
    private String diagnosis;
    private String hospitalizationDate;
    private String patientID;


    @Override
    public boolean equals(Object obj) {
        return this == obj;
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


    @Override
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

    @Override
    public void updatePatientDiagnose(String diagnose) {
        this.diagnosis = diagnose;
    }

    @Override
    public void deletePatient(String userID) {
        for (int i = 0; i < Patient.patientDir.size(); i++) {
            if (Patient.patientDir.get(i).getPatientID().equals(userID)) {
                Patient.patientDir.remove(i);
                System.out.println("==============================");
                System.out.println("===== Patient is deleted =====");
                System.out.println("==============================");
                break;
            }
        }
    }
}
