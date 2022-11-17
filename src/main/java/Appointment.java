import java.util.ArrayList;
import java.util.Random;

public final class Appointment extends AppointmentDetails {
    Random random = new Random();
    public static ArrayList<Appointment> appointments = new ArrayList<>();

   private String patientName;
   private String doctorName;
   private String date;
   private String time;
   private String confirmationNum = "@"+random.nextInt(2000);

    public Appointment() {

    }

    @Override
    public Appointment makeAppointment(String patientName, String doctorName, String date, String time) {
        return new Appointment(patientName,doctorName,date,time);
    }

    public Appointment(String patientName, String doctorName, String date, String time) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }
    public  static boolean isAppointmentAlreadyBooked(String doctorName, String time,String appDate){
            for (int i=0;i<Appointment.appointments.size();i++){
                if(Appointment.appointments.get(i).getDoctorName().equals(doctorName)
                        &&Appointment.appointments.get(i).getDate().equals(appDate)
                        && Appointment.appointments.get(i).getTime().equals(time)){
                    return true;
                }
            }
        return false;
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
