package com.hospital_management.reception;
import com.hospital_management.bills.Bill;
import com.hospital_management.exceptions.BillNotFoundException;
import com.hospital_management.exceptions.UserNotFoundException;
import com.hospital_management.procedures.CTScan;
import com.hospital_management.procedures.XRay;
import com.hospital_management.users.Hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Receptionist implements IReception{
    private static final Logger LOGGER = LogManager.getLogger(Receptionist.class);
    Scanner scanner =new Scanner(System.in);
    Bill bill;


    public void generateBill() throws UserNotFoundException {
        LOGGER.info("Please type patient name");
        String patientName = scanner.nextLine();
        if (Hospital.getPatientByName(patientName)==null){
            throw new UserNotFoundException("Patient is not found");
        }
        LOGGER.info("Please choose procedure from list");
        LOGGER.info("1 - CT Scan");
        LOGGER.info("2 - X-Ray");
        String option = scanner.next();
        switch (option){
            case "1":
                CTScan ctScan = new CTScan();
                bill = new Bill(Hospital.getPatientByName(patientName), ctScan.getCost());
                Hospital.getBills().add(bill);
                LOGGER.info("Bill is generated");
                break;
            case "2":
                XRay xRay = new XRay();
                bill = new Bill(Hospital.getPatientByName(patientName), xRay.getCost());
                Hospital.getBills().add(bill);
                LOGGER.info("Bill is generated");
                break;
        }


    }

    @Override
    public void viewPatientBill() throws UserNotFoundException, BillNotFoundException {
        LOGGER.info("Please enter patient name");
        String patientName = scanner.nextLine();
        if (Hospital.getPatientByName(patientName)==null){
            throw new UserNotFoundException("Patient is not found");
        }
        boolean ifBillNotFound = true;
        for (int i = 0; i < Hospital.getBills().size(); i++) {
            if((Hospital.getBills().get(i).getPatient().getFirstName()+" "+
                    Hospital.getBills().get(i).getPatient().getLastName()).equals(patientName)){
                LOGGER.info(Hospital.getBills().get(i));
                ifBillNotFound=false;
            }
        }
        if (ifBillNotFound){
           throw new BillNotFoundException("Bills not found");
        }
    }

}
