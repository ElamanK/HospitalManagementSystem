package appointments;

import users.Doctor;
import users.Hospital;
import users.Patient;


import java.util.Random;

public final class Appointment{
    Random random = new Random();
    private String doctorName;
    private String patientName;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private String confirmationNum = "CN" + random.nextInt(2000);

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Appointment() {

    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Appointment(Doctor doctor, Patient patient, String date, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    public static boolean isAppointmentAlreadyBooked(String doctorName, String time, String appDate) {
        for (int i = 0; i < Hospital.getAppointments().size(); i++) {
            if (Hospital.getAppointments().get(i).getDoctorName().equals(doctorName)
                    && Hospital.getAppointments().get(i).getDate().equals(appDate)
                    && Hospital.getAppointments().get(i).getTime().equals(time)) {
                return true;
            }
        }
        return false;
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
        return "Patient name__" + this.getPatientName()
                + "\n" + "Doctor name__" + this.getDoctorName()
                + "\n" + "Date__" + this.getDate() + " || " + "Time__" + getTime()
                + "\n" + "Appointment confirmation number__ " + getConfirmationNum();
    }
}
