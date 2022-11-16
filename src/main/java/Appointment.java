import java.util.ArrayList;

public class Appointment {

    public static ArrayList<Appointment> appointments = new ArrayList<>();

    String patientName;
    String doctorName;
    String date;
    String time;
    String confirmationNumber;

    public Appointment(String patientName, String doctorName, String date, String time, String confirmationNumber) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
        this.confirmationNumber = confirmationNumber;
    }

}
