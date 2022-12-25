package com.hospital_management.prescription;
import com.hospital_management.users.Doctor;
import com.hospital_management.users.Hospital;
import com.hospital_management.users.Patient;

public class Prescription implements IPrescription {
    private Doctor doctor;
    private Patient patient;
    private String medicine;
    private String date;

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public String getMedicine() {
        return medicine;
    }
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Doctor name__" + doctor.getFirstName()+" "+doctor.getLastName()
                + "\n" + "Patient name__" + patient.getFirstName()+" "+patient.getLastName()
                + "\n" + "+Medicine__" + medicine
                + "\n" + "Date__" + date;
    }


    @Override
    public void prescribe(Doctor doctor, Patient patient, String medicine, String date) {
        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setMedicine(medicine);
        prescription.setDate(date);
        Hospital.getPrescriptions().add(prescription);
        System.out.println("Medicine is prescribed");

    }
}
