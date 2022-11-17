public interface PatientInterface {

    void createPatient(String firstName, String lastName, String phoneNumber, String gender, String age, String bloodGroup, String diagnosis, String hospitalizationDate);

    void updatePatientDiagnose(String diagnose);

    void deletePatient(String userID);



}
