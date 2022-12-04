package reception;


import exceptions.BillNotFoundException;
import exceptions.UserNotFoundException;

public interface IReception {
    void generateBill() throws  UserNotFoundException;
    void viewPatientBill() throws UserNotFoundException, BillNotFoundException;
}
