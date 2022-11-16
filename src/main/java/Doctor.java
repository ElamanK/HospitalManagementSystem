import java.util.ArrayList;

public class Doctor implements User {

    public static ArrayList<Doctor> doctorDir = new ArrayList<>();

    public Doctor(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.docID = docID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.specialization = specialization;
    }

    public String firstName;
    public String lastName;
    public String docID;
    public String phoneNumber;
    public String gender;
    public String age;
    public String specialization;

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
