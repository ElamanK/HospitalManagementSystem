import java.util.ArrayList;
import java.util.Random;

public class Patient implements User{

    Random random=new Random();
    public static ArrayList<Patient> patientDir = new ArrayList<>();

    public Patient(String firstName, String lastName, String phoneNumber, String gender, String age, String bloodGroup, String diagnosis, String hospitalizationDate) {
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

    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String gender;
    public String age;
    public String bloodGroup;
    public String diagnosis;
    public String hospitalizationDate;
    public String patientID;


    @Override
    public void createUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
