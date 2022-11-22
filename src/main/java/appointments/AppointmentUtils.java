package appointments;


import users.Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentUtils {

    public static void makeAppointment(String docFullName,String patientFullName,String appDate,String appTime){
        List<Map<String,Object>> appointmentListOfMap = new ArrayList<>();
        Map<String,Object> appointmentsMap = new HashMap<>();
        appointmentsMap.put("Doctor", Hospital.getDoctorByName(docFullName));
        appointmentsMap.put("Patient",Hospital.getPatientByName(patientFullName));
        appointmentsMap.put("Date",appDate);
        appointmentsMap.put("Time",appTime);
        appointmentListOfMap.add(appointmentsMap);
        Hospital.setAppointmentListOfMap(appointmentListOfMap);
    }

    public static void allScheduledAppointments(){
        for (Map<String,Object> appointment : Hospital.getAppointmentListOfMap()) {
            System.out.println("======================================");
            System.out.println("-------Doctor info ------");
            System.out.println(appointment.get("Doctor").toString());
            System.out.println("-------Patient info ------");
            System.out.println(appointment.get("Patient").toString());
            System.out.println("======================================");
        }

    }
}
