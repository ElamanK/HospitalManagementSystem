package com.hospital_management.appointments;
import com.hospital_management.users.Doctor;
import com.hospital_management.users.Hospital;
import com.hospital_management.users.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AppointmentUtils {
    private static final Logger LOGGER = LogManager.getLogger(AppointmentUtils.class);
    public static void makeAppointment(Doctor doctor, Patient patient, String appDate, String appTime){
        Appointment appointment = new Appointment(doctor,patient,appDate,appTime);
        Hospital.getAppointments().add(appointment);
    }

    public static void allScheduledAppointments(){
        for (int i = 0; i < Hospital.getAppointments().size(); i++) {
            LOGGER.info("--------------------------------------------");
            LOGGER.info(Hospital.getAppointments().get(i).toString());
            LOGGER.info("--------------------------------------------");
        }
    }
}
