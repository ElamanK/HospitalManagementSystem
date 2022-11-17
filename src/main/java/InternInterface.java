public interface InternInterface {
    void createIntern(String firstName, String lastName, String internID,
                    String phoneNumber, String gender, String age, String specialization);

    void updateIntern(String firstName,String lastName, String specialization);
    void deleteIntern(String internID);
}
