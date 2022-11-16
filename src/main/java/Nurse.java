import java.util.ArrayList;

public class Nurse implements User{

    public static ArrayList<Nurse> nurseDir = new ArrayList<>();

    public String firstName;
    public String lastName;
    public int nurseID;
    public long phoneNumber;
    public String gender;
    public int age;
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
