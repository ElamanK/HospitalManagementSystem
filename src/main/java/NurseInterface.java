public interface NurseInterface {

    void createNurse(String firstName, String lastName, String docID, String phoneNumber, String gender, String age, String specialization);

    void updateNurseSpecialization(String specialization);

    void deleteNurse(String userID);


     /*
    Create a class hierarchy. Topic - Hospital
    Override	methods from class Object(toString, hashcode, equals) for at least 3 classes from the hierarchy.
    Create some kind of menu for interaction with your app: adding, editing, deleting data.
    Add 5 interfaces to the existing hierarchy.
    Use polymorphism with the abstract class and interface from the hierarchy.
    Use final class, method, variable.
    Use a static block, method, variable.
      */
}
