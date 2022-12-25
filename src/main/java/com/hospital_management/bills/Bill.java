package com.hospital_management.bills;
import com.hospital_management.utils.MyRandom;
import com.hospital_management.users.Patient;
public class Bill {
    private String billNumber;
    private Patient patient;
    private String billAmount;

    public Bill(Patient patient, String billAmount) {
        this.patient = patient;
        this.billAmount = billAmount;
        this.billNumber = MyRandom.getRandomNumberAsString();
    }

    @Override
    public String toString() {
        return "-Bill-"+"\n"+
                "patientName= " + patient.getFirstName()+" "+patient.getLastName()+"\n"+
                "billAmount= " + billAmount + "\n"+
                "billNumber= " + billNumber;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public String getBillAmount() {
        return billAmount;
    }
    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }
    public String getBillNumber() {
        return billNumber;
    }
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }


}
