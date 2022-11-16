import java.util.ArrayList;
import java.util.Random;

public class Appointment {
    Random random = new Random();
    public static ArrayList<Appointment> appointments = new ArrayList<>();

    String patientName;
    String doctorName;
    String date;
    String time;
    String confirmationNum = patientName+"@"+random.nextInt(2000);

    public Appointment(String patientName, String doctorName, String date, String time) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getConfirmationNum() {
        return confirmationNum;
    }

    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Patient name__"+this.getPatientName()
                +"\n"+"Doctor name__"+this.getDoctorName()
                +"\n"+"Date__"+this.getDate()+" || "+"Time__"+getTime()
                +"\n"+"Appointment confirmation number__ "+getConfirmationNum();
    }
}
