package com.hospital_management.staff;
import com.hospital_management.exceptions.InvalidUserIdException;
import com.hospital_management.exceptions.UserNotFoundException;

public interface IStaff {
    void createUser(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization);

    void updateUser(String userID) throws InvalidUserIdException, UserNotFoundException;

    void deleteUser(String userID) throws InvalidUserIdException, UserNotFoundException;

}
