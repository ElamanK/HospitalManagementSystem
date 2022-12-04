package staff;
import exceptions.InvalidUserIdException;
import exceptions.UserNotFoundException;

public interface IStaff {
    void createUser(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization);

    void updateUser(String userID) throws InvalidUserIdException, UserNotFoundException;

    void deleteUser(String userID) throws InvalidUserIdException;

}
