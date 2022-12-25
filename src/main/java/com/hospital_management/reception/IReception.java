package com.hospital_management.reception;
import com.hospital_management.exceptions.BillNotFoundException;
import com.hospital_management.exceptions.UserNotFoundException;

public interface IReception {
    void generateBill() throws  UserNotFoundException;
    void viewPatientBill() throws UserNotFoundException, BillNotFoundException;
}
