package com.hospital_management.reception;
import com.hospital_management.bills.Bill;
import com.hospital_management.exceptions.BillNotFoundException;
import com.hospital_management.exceptions.UserNotFoundException;
import enums.Procedure;
import com.hospital_management.users.Hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Receptionist implements IReception {
    private static final Logger LOGGER = LogManager.getLogger(Receptionist.class);
    Scanner scanner = new Scanner(System.in);
    Bill bill;
    Procedure procedure;

    public void generateBill() throws UserNotFoundException {
        LOGGER.info("Please type patient name");
        String patientName = scanner.nextLine();
        if (Hospital.getPatientByName(patientName) == null) {
            throw new UserNotFoundException("Patient is not found");
        }
        LOGGER.info("Please choose procedure from list");
        for (Procedure procedure : Procedure.values()) {
            LOGGER.info(procedure);
        }
        String option = scanner.nextLine().toLowerCase();
        procedure = Procedure.getProcedureByName(option);
        if (procedure != null) {
            switch (procedure) {
                case CT_SCAN:
                    bill = new Bill(Hospital.getPatientByName(patientName), Procedure.CT_SCAN.getCost());
                    Hospital.getBills().add(bill);
                    LOGGER.info("Bill is generated");
                    break;
                case XRAY:
                    bill = new Bill(Hospital.getPatientByName(patientName), Procedure.XRAY.getCost());
                    Hospital.getBills().add(bill);
                    LOGGER.info("Bill is generated");
                    break;
                case ULTRASOUND:
                    bill = new Bill(Hospital.getPatientByName(patientName), Procedure.ULTRASOUND.getCost());
                    Hospital.getBills().add(bill);
                    LOGGER.info("Bill is generated");
                    break;
            }
        } else {
            LOGGER.error("Procedure not found");
        }

    }

    @Override
    public void viewPatientBill() throws UserNotFoundException, BillNotFoundException {
        LOGGER.info("Please enter patient name");
        String patientName = scanner.nextLine();
        if (Hospital.getPatientByName(patientName) == null) {
            throw new UserNotFoundException("Patient is not found");
        }
        boolean ifBillNotFound = true;
        for (int i = 0; i < Hospital.getBills().size(); i++) {
            if ((Hospital.getBills().get(i).getPatient().getFirstName() + " " + Hospital.getBills().get(i).getPatient().getLastName()).equals(patientName)) {
                LOGGER.info(Hospital.getBills().get(i));
                ifBillNotFound = false;
            }
        }
        if (ifBillNotFound) {
            throw new BillNotFoundException("Bills not found");
        }
    }
}
