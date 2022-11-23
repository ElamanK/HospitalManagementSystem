package appointments;


import users.Doctor;
import users.Hospital;
import users.Patient;

public class AppointmentUtils {
    public static void makeAppointment(Doctor doctor, Patient patient, String appDate, String appTime){
        Appointment appointment = new Appointment(doctor,patient,appDate,appTime);
        Hospital.getAppointments().add(appointment);
    }

    public static void allScheduledAppointments(){
        for (int i = 0; i < Hospital.getAppointments().size(); i++) {
            System.out.println(Hospital.getAppointments().get(i).toString());
        }
    }
}
