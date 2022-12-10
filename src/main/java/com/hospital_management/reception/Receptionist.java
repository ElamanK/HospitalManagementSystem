package com.hospital_management.reception;
import com.hospital_management.bills.Bill;
import com.hospital_management.exceptions.BillNotFoundException;
import com.hospital_management.exceptions.UserNotFoundException;
import com.hospital_management.procedures.CTScan;
import com.hospital_management.procedures.XRay;
import com.hospital_management.users.Hospital;
import java.util.Scanner;

public class Receptionist implements IReception{
    Scanner scanner =new Scanner(System.in);
    Bill bill;


    public void generateBill() throws UserNotFoundException {
        System.out.println("Please type patient name");
        String patientName = scanner.nextLine();
        if (Hospital.getPatientByName(patientName)==null){
            throw new UserNotFoundException("Patient is not found");
        }
        System.out.println("Please choose procedure from list");
        System.out.println("1 - CT Scan");
        System.out.println("2 - X-Ray");
        String option = scanner.next();
        switch (option){
            case "1":
                CTScan ctScan = new CTScan();
                bill = new Bill(Hospital.getPatientByName(patientName), ctScan.getCost());
                Hospital.getBills().add(bill);
                System.out.println("Bill is generated");
                break;
            case "2":
                XRay xRay = new XRay();
                bill = new Bill(Hospital.getPatientByName(patientName), xRay.getCost());
                Hospital.getBills().add(bill);
                System.out.println("Bill is generated");
                break;
        }


    }

    @Override
    public void viewPatientBill() throws UserNotFoundException, BillNotFoundException {
        System.out.println("Please enter patient name");
        String patientName = scanner.nextLine();
        if (Hospital.getPatientByName(patientName)==null){
            throw new UserNotFoundException("Patient is not found");
        }
        boolean ifBillNotFound = true;
        for (int i = 0; i < Hospital.getBills().size(); i++) {
            if((Hospital.getBills().get(i).getPatient().getFirstName()+" "+
                    Hospital.getBills().get(i).getPatient().getLastName()).equals(patientName)){
                System.out.println(Hospital.getBills().get(i));
                ifBillNotFound=false;
            }
        }
        if (ifBillNotFound){
           throw new BillNotFoundException("Bills not found");
        }
    }

}
