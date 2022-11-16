import java.util.Scanner;

public class AppRunner {
    static {
        System.out.println("*** Welcome to the Hospital Management System ***");
    }

    public static void main(String[] args) {
        printOptions();
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            option = scanner.next();
            makeAChoice(option);
        } while (!option.equals("0"));
    }




    public static void printOptions() {
        System.out.println("Please choose on of the following options");
        System.out.println("1 - For new patient");
        System.out.println("2 - To update patient diagnosis");
        System.out.println("3 - To delete patient info with patient id");
        System.out.println("4 - To print all patients info");
        System.out.println("5 - For new Doctor");
        System.out.println("6 - To update Doctor specialization with doctor id");
        System.out.println("7 - To search the Doctor with doctor id and print all other doctor information");
        System.out.println("8 - To make appointment with doctor");
        System.out.println("9 - To view all scheduled appointments");
        System.out.println("10 - To cancel appointment");
        System.out.println("11 - For new Nurse");
        System.out.println("12 - To search the Nurse with nurse id and print all other nurse information");
        System.out.println("0 - To exit");
    }




    private static void makeAChoice(String choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "0":
                System.out.println("Thank you for using our application");
                break;
            case "1":
                System.out.println("Please enter firstName:");
                String firstName = scanner.nextLine();
                System.out.println("Please enter lastName:");
                String lastName = scanner.nextLine();
                System.out.println("Please enter patients phone number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Please enter gender:");
                String gender = scanner.nextLine();
                System.out.println("Please patients age:");
                String age = scanner.nextLine();
                System.out.println("Please enter bloodGroup:");
                String bloodGroup = scanner.nextLine();
                System.out.println("Please enter patients diagnosis:");
                String diagnosis = scanner.nextLine();
                System.out.println("Please enter patients hospitalization date:");
                String hospitalizationDate = scanner.nextLine();

                Patient patient = new Patient(firstName, lastName, phoneNumber, gender, age, bloodGroup,
                        diagnosis, hospitalizationDate);

                Patient.patientDir.add(patient);
                System.out.println("==============================");
                System.out.println("===== Patient is created =====");
                System.out.println("==============================");
                continueOperation();
                break;
            case "2":
                if (isPatientExist()) {
                    System.out.println("Please enter patients id:");
                    String patientID = scanner.nextLine();

                    for (int i = 0; i < Patient.patientDir.size(); i++) {
                        if (Patient.patientDir.get(i).getPatientID().equals(patientID)) {
                            System.out.println("Please enter updated diagnose below:");
                            String updatedDiagnose = scanner.nextLine();
                            Patient.patientDir.get(i).setDiagnosis(updatedDiagnose);
                            System.out.println("Patient diagnose is updated to " + updatedDiagnose + ".");
                            break;
                        }
                    }
                }else {
                    System.out.println("There is no patient with given ID, please try again");
                }

                continueOperation();
                break;
            case "3":
                if (isPatientExist()){
                    System.out.println("Please enter patients id:");
                    String patientToDelete = scanner.nextLine();
                    for (int i = 0; i < Patient.patientDir.size(); i++) {
                        if (Patient.patientDir.get(i).getPatientID().equals(patientToDelete)) {
                            Patient.patientDir.remove(i);
                            System.out.println("==============================");
                            System.out.println("===== Patient is deleted =====");
                            System.out.println("==============================");
                            break;
                        }
                    }

                }else {
                    System.out.println("There is no patient with given ID, please try again");
                }
                continueOperation();
                break;
            case "4":
                System.out.println("-- All patients information --");
                if (isPatientExist()){
                    for (int i = 0; i < Patient.patientDir.size(); i++) {
                        System.out.println("--------------------------------------------");
                        System.out.println(Patient.patientDir.get(i).toString());
                        System.out.println("--------------------------------------------");
                    }
                }else {
                    System.out.println("There is no patient with given ID, please try again");
                }
                continueOperation();
                break;
            case "5":
                System.out.println("Please enter firstName:");
                String docFirstName = scanner.nextLine();
                System.out.println("Please enter lastName:");
                String docLastName = scanner.nextLine();
                System.out.println("Please enter doctors ID:");
                String docID = scanner.nextLine();
                System.out.println("Please enter phoneNumber:");
                String docPhone = scanner.nextLine();
                System.out.println("Please patients gender:");
                String docGender = scanner.nextLine();
                System.out.println("Please enter age:");
                String docAge = scanner.nextLine();
                System.out.println("Please enter specialization:");
                String specialization = scanner.nextLine();
                Doctor doctor = new Doctor(docFirstName, docLastName, docID, docPhone, docGender, docAge,
                        specialization);
                Doctor.doctorDir.add(doctor);
                System.out.println("==============================");
                System.out.println("===== Doctor is created ======");
                System.out.println("==============================");
                continueOperation();
                break;
            case "6":
                if (isDoctorExist()){
                    System.out.println("Please enter doctor id:");
                    String doctorID = scanner.nextLine();
                    for (int i = 0; i < Doctor.doctorDir.size(); i++) {
                        if (Doctor.doctorDir.get(i).docID.equals(doctorID)) {
                            System.out.println("Please enter updated specialization below:");
                            String updatedSpecialization = scanner.nextLine();
                            Doctor.doctorDir.get(i).setSpecialization(updatedSpecialization);
                            System.out.println("Doctors specialization is updated to " + updatedSpecialization + ".");
                        }
                }
                }else {
                    System.out.println("There is no doctor with given ID, please try again");
                }
                continueOperation();
                break;
            case "7":
                if (isDoctorExist()){
                    System.out.println("Please enter doctor id:");
                    String doctorIDToSearch = scanner.nextLine();
                    for (int i = 0; i < Doctor.doctorDir.size(); i++) {
                        if (Doctor.doctorDir.get(i).getDocID().equals(doctorIDToSearch)) {
                            System.out.println("-----------------------------------");
                            System.out.println(Doctor.doctorDir.get(i).toString());
                            System.out.println("-----------------------------------");
                        }
                    }
                } else {
                    System.out.println("There is no doctor with given ID, please try again");
                }
                continueOperation();
                break;
            case "8":
                if (isDoctorExist()&&isPatientExist()){
                    System.out.println("Please enter doctors full name to make an appointment");
                    String docName = scanner.nextLine();
                    for (int i=0;i<Doctor.doctorDir.size();i++){
                        if((Doctor.doctorDir.get(i).getFirstName()+" "+Doctor.doctorDir.get(i).getLastName().trim()).equals(docName)){
                            System.out.println("Please enter patient full name");
                            String patientFullName = scanner.nextLine();
                            System.out.println("Enter date");
                            String appDate = scanner.nextLine();
                            System.out.println("Enter time");
                            String appTime = scanner.nextLine();
                            Appointment appointment = new Appointment(patientFullName,docName,appDate,appTime);
                            Appointment.appointments.add(appointment);
                            System.out.println("Your appointment with doctor "+docName+" scheduled successfully");
                        }else{
                            System.out.println("There is no data in database, please try again");
                            break;
                        }
                    }
                }
                continueOperation();
                break;
            case "9":
                System.out.println("All scheduled appointments");
                if (isAppointmentExist()){
                    for (int i = 0; i < Appointment.appointments.size(); i++) {
                        System.out.println("-----------------------------------------");
                        System.out.println(Appointment.appointments.get(i).toString());
                        System.out.println("-----------------------------------------");
                    }
                }else {
                    System.out.println("There is no appointment scheduled yet, please schedule first");
                }

                continueOperation();
                break;
            case "10":
                if (isAppointmentExist()){
                    System.out.println("To cancel appointment please enter appointment confirmation number:");
                    String cancelNumber = scanner.nextLine();
                    for (int i = 0; i < Appointment.appointments.size(); i++) {
                        if(Appointment.appointments.get(i).getConfirmationNum().equals(cancelNumber)){
                            Appointment.appointments.remove(i);
                            System.out.println("-----------------------------------------");
                            System.out.println("Your appointment with doctor "+Appointment.appointments.get(i).getDoctorName()+" is canceled");
                            System.out.println("-----------------------------------------");
                            System.out.println();
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Incorrect confirmation number, please try again");
                }
                continueOperation();
                break;
            case "11":
                System.out.println("Please enter firstName:");
                String nurseFirstName = scanner.nextLine();
                System.out.println("Please enter lastName:");
                String nurseLastName = scanner.nextLine();
                System.out.println("Please enter doctors ID:");
                String nurseID = scanner.nextLine();
                System.out.println("Please enter phoneNumber:");
                String nursePhone = scanner.nextLine();
                System.out.println("Please patients gender:");
                String nurseGender = scanner.nextLine();
                System.out.println("Please enter age:");
                String nurseAge = scanner.nextLine();
                System.out.println("Please enter specialization:");
                String nurseSpecialization = scanner.nextLine();

                Nurse newNurse = new Nurse(nurseFirstName,nurseLastName,
                        nurseID,nursePhone,nurseGender,nurseAge,nurseSpecialization);
                Nurse.nurseDir.add(newNurse);
                System.out.println("==============================");
                System.out.println("===== Nurse is created  ======");
                System.out.println("==============================");
                continueOperation();
                break;
            case "12":
                if (isNurseExist()){
                    System.out.println("Please enter nurse id:");
                    String nurseId = scanner.nextLine();
                    for (int i = 0; i < Nurse.nurseDir.size(); i++) {
                        if (Nurse.nurseDir.get(i).nurseID.equals(nurseId)) {
                            System.out.println("-----------------------------------");
                            System.out.println(Nurse.nurseDir.get(i).toString());
                            System.out.println("-----------------------------------");
                        }
                }
                } else {
                    System.out.println("There is no nurse with given ID, please try again");
                }
                continueOperation();
                break;
            default:
                printOptions();

        }
    }



    public static void continueOperation() {
        System.out.println("-----------------------");
        System.out.println("Click 1 to go main page");
        System.out.println("   Click 0 to exit     ");
        System.out.println("-----------------------");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                printOptions();
                break;
            case "0":
                break;
            default:
                System.out.println("Please chose one of these options");
                continueOperation();
                break;
        }
    }
    public static boolean isDoctorExist() {
        return !Doctor.doctorDir.isEmpty();
    }

    public static boolean isPatientExist() {
        return !Patient.patientDir.isEmpty();
    }

    public static boolean isNurseExist() {
        return !Nurse.nurseDir.isEmpty();
    }

    public static boolean isAppointmentExist() {
        return !Appointment.appointments.isEmpty();
    }

}
