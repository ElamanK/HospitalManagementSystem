package interfaces;



public interface StaffInterface {
    void createUser(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization);

    void updateUserSpecialization(String userID);

    void deleteUser(String userID);

}
