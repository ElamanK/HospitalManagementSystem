import java.util.ArrayList;

public class Nurse implements User{

    public static ArrayList<Nurse> nurseDir = new ArrayList<>();

    public String firstName;
    public String lastName;
    public String nurseID;
    public String phoneNumber;
    public String gender;
    public String age;
    public String specialization;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        return "Nurse first name__"+this.getFirstName()
                +"\n"+"Nurse last name__"+this.getLastName()
                +"\n"+"Nurse ID__"+this.getNurseID()
                +"\n"+"Nurse phone number__"+this.getPhoneNumber()
                +"\n"+"Nurse gender__"+this.getGender()
                +"\n"+"Nurse age__"+this.getAge()
                +"\n"+"Nurse specialization__"+this.getSpecialization();
    }

    @Override
    public void createUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

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

    public String getNurseID() {
        return nurseID;
    }

    public void setNurseID(String nurseID) {
        this.nurseID = nurseID;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
