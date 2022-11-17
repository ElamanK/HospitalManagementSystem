import java.util.ArrayList;

public class Intern implements InternInterface{

    public static ArrayList<Intern> internDir = new ArrayList<>();

    private String firstName;
    private String lastName;
    private String internID;
    private String phoneNumber;
    private String gender;
    private String age;
    private String specialization;

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

    public String getInternID() {
        return internID;
    }

    public void setInternID(String internID) {
        this.internID = internID;
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

    @Override
    public String toString() {
        return "Intern first name__"+this.getFirstName()
                +"\n"+"Intern last name__"+this.getLastName()
                +"\n"+"Intern ID__"+this.getInternID()
                +"\n"+"Intern phone number__"+this.getPhoneNumber()
                +"\n"+"Intern gender__"+this.getGender()
                +"\n"+"Intern age__"+this.getAge()
                +"\n"+"Intern specialization__"+this.getSpecialization();
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
    public void createIntern(String firstName, String lastName, String internID, String phoneNumber, String gender, String age, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.internID = internID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.specialization = specialization;
    }

    @Override
    public void updateIntern(String firstName, String lastName, String specialization) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSpecialization(specialization);
    }

    @Override
    public void deleteIntern(String internID) {
        for (int i=0;i<internDir.size();i++) {
            if(internDir.get(i).internID.equals(internID)){
                internDir.remove(i);
                break;
            }
        }
    }
}
