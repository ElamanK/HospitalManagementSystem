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
    public String toString() {
        return "Doctor first name__"+this.getFirstName()
                +"\n"+"Doctor last name__"+this.getLastName()
                +"\n"+"Doctor ID__"+this.getDocID()
                +"\n"+"Doctors phone number__"+this.getPhoneNumber()
                +"\n"+"Doctors gender__"+this.getGender()
                +"\n"+"Doctors age__"+this.getAge()
                +"\n"+"Doctors specialization__"+this.getSpecialization();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
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

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
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
