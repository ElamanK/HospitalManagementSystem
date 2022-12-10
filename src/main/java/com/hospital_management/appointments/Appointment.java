package com.hospital_management.appointments;
import com.hospital_management.users.Doctor;
import com.hospital_management.users.Patient;
import com.hospital_management.utils.MyRandom;


public final class Appointment{
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private final String confirmationNum = "CN" + MyRandom.getRandomNumberAsString();

    public Appointment(Doctor doctor, Patient patient, String date, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

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
        return "Patient name__" + patient.getFirstName()+" "+patient.getLastName()
                + "\n" + "Doctor name__" + doctor.getFirstName()+" "+doctor.getLastName()
                + "\n" + "Date__" + this.getDate() + " || " + "Time__" + getTime()
                + "\n" + "Appointment confirmation number__ " + getConfirmationNum();
    }
}
