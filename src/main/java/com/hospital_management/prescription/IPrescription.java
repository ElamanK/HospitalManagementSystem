package com.hospital_management.prescription;


import com.hospital_management.users.Doctor;
import com.hospital_management.users.Patient;

public interface IPrescription {
     void prescribe(Doctor doctor, Patient patient, String medicine, String date);
}
