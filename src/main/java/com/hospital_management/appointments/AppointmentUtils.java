package com.hospital_management.appointments;


import com.hospital_management.users.Doctor;
import com.hospital_management.users.Hospital;
import com.hospital_management.users.Patient;

public abstract class AppointmentUtils {
    public static void makeAppointment(Doctor doctor, Patient patient, String appDate, String appTime){
        Appointment appointment = new Appointment(doctor,patient,appDate,appTime);
        Hospital.getAppointments().add(appointment);
    }

    public static void allScheduledAppointments(){
        for (int i = 0; i < Hospital.getAppointments().size(); i++) {
            System.out.println("--------------------------------------------");
            System.out.println(Hospital.getAppointments().get(i).toString());
            System.out.println("--------------------------------------------");
        }
    }
}
