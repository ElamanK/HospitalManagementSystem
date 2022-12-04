package prescription;


import users.Doctor;
import users.Patient;

public interface IPrescription {
     void prescribe(Doctor doctor, Patient patient, String medicine, String date);
}
