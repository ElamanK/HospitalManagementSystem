package com.hospital_management.users;
import com.hospital_management.appointments.Appointment;
import com.hospital_management.bills.Bill;
import com.hospital_management.prescription.Prescription;


import java.util.ArrayList;


public class Hospital {
    private static ArrayList<Doctor> doctorDir = new ArrayList<>();
    private static ArrayList<Patient> patientDir = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static ArrayList<Intern> internDir = new ArrayList<>();
    private static ArrayList<Nurse> nurseDir = new ArrayList<>();
    private static ArrayList<Prescription> prescriptions = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();

    public static ArrayList<Bill> getBills() {
        return bills;
    }

    public static void setBills(ArrayList<Bill> bills) {
        Hospital.bills = bills;
    }

    public static ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public static void setPrescriptions(ArrayList<Prescription> prescriptions) {
        Hospital.prescriptions = prescriptions;
    }

    public static Doctor getDoctorByName(String fullName){
        for (Doctor doctor : doctorDir) {
            if ((doctor.getFirstName() +" "+ doctor.getLastName()).equals(fullName)) {
                return doctor;
            }
        }
        return null;
    }

    public static Patient getPatientByName(String fullName){
        for (Patient patient : patientDir) {
            if ((patient.getFirstName() +" "+ patient.getLastName()).equals(fullName)) {
                return patient;
            }
        }
        return null;
    }

    public static ArrayList<Nurse> getNurseDir() {
        return nurseDir;
    }

    public static void setNurseDir(ArrayList<Nurse> nurseDir) {
        Hospital.nurseDir = nurseDir;
    }



    public static ArrayList<Intern> getInternDir() {
        return internDir;
    }

    public static ArrayList<Patient> getPatientDir() {
        return patientDir;
    }

    public static void setPatientDir(ArrayList<Patient> patientDir) {
        Hospital.patientDir = patientDir;
    }

    public static void setInternDir(ArrayList<Intern> internDir) {
        Hospital.internDir = internDir;
    }

    public static ArrayList<Doctor> getDoctorDir() {
        return doctorDir;
    }

    public static void setDoctorDir(ArrayList<Doctor> doctorDir) {
        Hospital.doctorDir = doctorDir;
    }

    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public static void setAppointments(ArrayList<Appointment> appointments) {
        Hospital.appointments = appointments;
    }
}
