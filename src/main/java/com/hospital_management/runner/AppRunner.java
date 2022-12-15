package com.hospital_management.runner;
import com.hospital_management.appointments.AppointmentUtils;
import com.hospital_management.exceptions.*;
import com.hospital_management.prescription.Prescription;
import com.hospital_management.reception.Receptionist;
import com.hospital_management.users.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.*;

public class AppRunner {
    private static final Logger LOGGER = LogManager.getLogger(AppRunner.class);
    private static boolean stopOperation = false;

    static {
        LOGGER.info("Entering application.");
        LOGGER.info("*** Welcome to the Hospital Management System ***.");
        Patient patient = new Patient();
        patient.createPatient("Jacey","Nichols","+1234567890",
                "male","25","2","flu","12.12.21");
        Hospital.getPatientDir().add(patient);
        Patient patient1 = new Patient();
        patient1.createPatient("Harry","Otter","+123545454",
                "male","56","2+","cold","12.12.22");
        Hospital.getPatientDir().add(patient1);
        Doctor doctor = new Doctor();
        doctor.createUser("Carson","Smith","123","+12312312312",
                "male","28","dentist");
        Hospital.getDoctorDir().add(doctor);
        Doctor doctor1 = new Doctor();
        doctor1.createUser("Matilda","Friedman","122","+13312345312",
                "female","25","surgeon");
        Hospital.getDoctorDir().add(doctor1);
    }

    public static void main(String[] args) {
        printOptions();
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            option = scanner.next();
            makeAChoice(option);
            if (stopOperation){
                option ="0";
            }
        } while (!option.equals("0"));
        LOGGER.info("User exits application.");
    }

    private static void printOptions() {
        LOGGER.info("Main menu printed.");
        LOGGER.info("Please choose on of the following options.");
        LOGGER.info("1 - For patient");
        LOGGER.info("2 - For doctor");
        LOGGER.info("3 - For appointments");
        LOGGER.info("4 - For nurse");
        LOGGER.info("5 - For intern");
        LOGGER.info("6 - For prescription");
        LOGGER.info("7 - For reception");
        LOGGER.info("0 - To exit");
    }

    private static void makeAChoice(String choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "0":
                LOGGER.info("Thank you for using our application.");
                stopOperation=true;
                break;
            case "1":
                printPatientOptions();
                makeAChoiceForPatient(scanner.next());
                continueOperation();
                break;
            case "2":
                printDoctorOptions();
                makeChoiceForDoctor(scanner.next());
                continueOperation();
                break;
            case "3":
                printAppointmentOptions();
                makeChoiceForAppointment(scanner.next());
                continueOperation();
                break;
            case "4":
                printNurseOptions();
                makeChoiceForNurse(scanner.next());
                continueOperation();
                break;
            case "5":
                printInternOptions();
                makeChoiceForIntern(scanner.next());
                continueOperation();
                break;
            case "6":
                printPrescriptions();
                makeChoiceForPrescription(scanner.next());
                continueOperation();
                break;
            case "7":
                printReceptionOptions();
                makeChoiceForReception(scanner.next());
                continueOperation();
                break;
            default:
                try {
                    throw new InvalidOptionException("Please choose valid option");
                } catch (InvalidOptionException e) {
                    LOGGER.error("Exception occurred ", e);
                }
                printOptions();

        }
    }

    private static void printReceptionOptions() {
        LOGGER.info("1 - To generate bill");
        LOGGER.info("2 - To view patient bills");
    }

    private static void makeChoiceForReception(String choice) {
        Receptionist receptionist = new Receptionist();
        switch (choice) {
            case "1":
                try {
                    receptionist.generateBill();
                } catch (UserNotFoundException e) {
                    LOGGER.error("Error occurred ", e);
                }
                break;
            case "2":
                try {
                    receptionist.viewPatientBill();
                } catch (UserNotFoundException | BillNotFoundException e) {
                    LOGGER.error("Error occurred ", e);
                }
                break;
            default:
                LOGGER.info("Incorrect option, please try again");
                break;

        }
    }

    private static void printPrescriptions() {
        LOGGER.info("1 - For new prescription");
        LOGGER.info("2 - View all patients prescriptions");
    }

    private static void makeChoiceForPrescription(String choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "1":
                try {
                    Doctor.prescribeMedicine();
                } catch (UserNotFoundException e) {
                    LOGGER.error("Error occurred ", e);
                }
                break;
            case "2":
                LOGGER.info("Please enter patient name");
                String patName = scanner.nextLine();
                if (patName.isEmpty()) {
                    LOGGER.error("Patient name cannot be blank");
                    break;
                }
                boolean ifPatientDoesNotExist = true;
                for (Prescription p : Hospital.getPrescriptions()) {
                    if ((p.getPatient().getFirstName() + " " + p.getPatient().getLastName()).equalsIgnoreCase(patName)) {
                        LOGGER.info("-------------------------");
                        LOGGER.info(p);
                        LOGGER.info("-------------------------");
                        ifPatientDoesNotExist = false;
                    }
                }
                if (ifPatientDoesNotExist) {
                    LOGGER.info("Patient is not found, please try again");
                }
                break;
            default:

        }
    }

    private static void printInternOptions() {
        LOGGER.info("1 - For new intern");
        LOGGER.info("2 - To update intern specialization with intern id");
        LOGGER.info("3 - To search for intern with intern id and print all other intern information");
        LOGGER.info("4 - To delete intern info with intern id");
        LOGGER.info("5 - To main page");
    }

    private static void makeChoiceForIntern(String choice) {
        Intern intern = new Intern();
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "1":
                LOGGER.info("Please enter firstName:");
                String internFirstName = scanner.nextLine();
                LOGGER.info("Please enter lastName:");
                String internLastName = scanner.nextLine();
                LOGGER.info("Please enter intern ID:");
                String internID = scanner.nextLine();
                LOGGER.info("Please enter phoneNumber:");
                String interPhone = scanner.nextLine();
                LOGGER.info("Please patients gender:");
                String internGender = scanner.nextLine();
                LOGGER.info("Please enter age:");
                String internAge = scanner.nextLine();
                LOGGER.info("Please enter specialization:");
                String internSpecialization = scanner.nextLine();
                intern.createUser(internFirstName, internLastName, internID, interPhone,
                        internGender, internAge, internSpecialization);
                Hospital.getInternDir().add(intern);
                LOGGER.info("===== Intern is created ======");
                break;
            case "2":
                if (isInternExist()) {
                    LOGGER.info("Please enter intern id:");
                    String internIDtoUpdate = scanner.nextLine();
                    intern.updateUser(internIDtoUpdate);
                } else {
                    LOGGER.info("There is no intern info in database");
                }
                break;
            case "3":
                if (isInternExist()) {
                    LOGGER.info("Please enter intern id:");
                    String internToSearch = scanner.nextLine();
                    boolean ifInternNotFound = true;
                    for (int i = 0; i < Hospital.getInternDir().size(); i++) {
                        if (Hospital.getInternDir().get(i).getPersonID().equals(internToSearch)) {
                            LOGGER.info("-----------------------------------");
                            LOGGER.info(Hospital.getInternDir().get(i).toString());
                            LOGGER.info("-----------------------------------");
                            ifInternNotFound = false;
                        }
                    }
                    if (ifInternNotFound) {
                        LOGGER.info("Intern not found with given ID, please try again");
                    }
                } else {
                    LOGGER.info("There is no intern in database, please try again");
                }
                break;
            case "4":
                if (isInternExist()) {
                    LOGGER.info("To delete intern information please enter internID:");
                    String internToDelete = scanner.nextLine();
                    intern.deleteUser(internToDelete);
                } else {
                    LOGGER.info("There is no intern in database, please create intern");
                }
                break;
            case "5":
                printOptions();
                do {
                    choice = scanner.next();
                    makeAChoice(choice);
                } while (!choice.equals("0"));
                break;
        }
    }

    private static void printNurseOptions() {
        LOGGER.info("1 - For new nurse");
        LOGGER.info("2 - To update nurse specialization with nurse id");
        LOGGER.info("3 - To search for nurse with nurse id and print all other nurse information");
        LOGGER.info("4 - To delete nurse info with nurse id");
        LOGGER.info("5 - To main page");
    }

    private static void makeChoiceForNurse(String option) {
        Nurse nurse = new Nurse();
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                LOGGER.info("Please enter firstName:");
                String nurseFirstName = scanner.nextLine();
                LOGGER.info("Please enter lastName:");
                String nurseLastName = scanner.nextLine();
                LOGGER.info("Please enter nurse ID:");
                String nurseID = scanner.nextLine();
                LOGGER.info("Please enter phoneNumber:");
                String nursePhone = scanner.nextLine();
                LOGGER.info("Please nurse gender:");
                String nurseGender = scanner.nextLine();
                LOGGER.info("Please enter age:");
                String nurseAge = scanner.nextLine();
                LOGGER.info("Please enter specialization:");
                String nurseSpecialization = scanner.nextLine();
                nurse.createUser(nurseFirstName, nurseLastName, nurseID, nursePhone,
                        nurseGender, nurseAge, nurseSpecialization);
                Hospital.getNurseDir().add(nurse);
                LOGGER.info("==============================");
                LOGGER.info("===== Nurse is created  ======");
                LOGGER.info("==============================");
                break;
            case "2":
                if (isNurseExist()) {
                    LOGGER.info("Please enter nurse id:");
                    String nurseToUpdate = scanner.nextLine();
                    for (int i = 0; i < Hospital.getNurseDir().size(); i++) {
                        if (Hospital.getNurseDir().get(i).getPersonID().equals(nurseToUpdate)) {
                            LOGGER.info("Please enter updated specialization below:");
                            String updatedSpecialization = scanner.nextLine();
                            Hospital.getNurseDir().get(i).setSpecialization(updatedSpecialization);
                            LOGGER.info("Nurse specialization is updated to " + updatedSpecialization + ".");
                        }
                    }
                } else {
                    LOGGER.info("There is no nurse in database, please try again");
                }
                break;
            case "3":
                if (isNurseExist()) {
                    LOGGER.info("Please enter nurse id:");
                    String nurseId = scanner.nextLine();
                    for (int i = 0; i < Hospital.getNurseDir().size(); i++) {
                        if (Hospital.getNurseDir().get(i).getPersonID().equals(nurseId)) {
                            LOGGER.info("-----------------------------------");
                            LOGGER.info(Hospital.getNurseDir().get(i).toString());
                            LOGGER.info("-----------------------------------");
                        }
                    }
                } else {
                    LOGGER.info("There is no nurse with given ID, please try again");
                }
                break;
            case "4":
                if (isNurseExist()) {
                    LOGGER.info("To delete nurse information please enter nurseID:");
                    String nurseToDelete = scanner.nextLine();
                    nurse.deleteUser(nurseToDelete);
                } else {
                    LOGGER.info("There is no nurse in database, please create nurse ");
                }
                break;
            case "5":
                printOptions();
                do {
                    option = scanner.next();
                    makeAChoice(option);
                } while (!option.equals("0"));
                break;
        }
    }

    private static void printAppointmentOptions() {
        LOGGER.info("1 - To make appointment with doctor");
        LOGGER.info("2 - To view all scheduled appointments");
        LOGGER.info("3 - To cancel appointment");
        LOGGER.info("4 - To main page");
    }

    private static void makeChoiceForAppointment(String option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                if (isDoctorExist() && isPatientExist()) {
                    LOGGER.info("To make an appointment please choose doctor from the list");
                    for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
                        LOGGER.info(i + 1 + ")" + Hospital.getDoctorDir().get(i).getFirstName() + " " + Hospital.getDoctorDir().get(i).getLastName());
                    }
                    String docNumberFromList = scanner.nextLine();
                    if (Integer.parseInt(docNumberFromList) > (Hospital.getDoctorDir().size())) {
                        LOGGER.error("Invalid number, please choose doctor by number");
                        break;
                    }
                    String docFullName = Hospital.getDoctorDir().get(Integer.parseInt(docNumberFromList) - 1).getFirstName()
                            + " " + Hospital.getDoctorDir().get(Integer.parseInt(docNumberFromList) - 1).getLastName();

                    LOGGER.info("Please enter patient full name");
                    String patientFullName = scanner.nextLine();
                    if (Hospital.getPatientByName(patientFullName) == null) {
                        LOGGER.info("Patient is not found, please try again");
                        break;
                    }
                    LOGGER.info("Enter date");
                    String appDate = scanner.nextLine();
                    LOGGER.info("Enter time");
                    String appTime = scanner.nextLine();
                    AppointmentUtils.makeAppointment(Hospital.getDoctorByName(docFullName),
                            Hospital.getPatientByName(patientFullName), appDate, appTime);
                    LOGGER.info("Appointment with doctor scheduled.");
//                    System.out.println("Your appointment with doctor " + docFullName + " scheduled successfully");
                } else {
                    LOGGER.info("Please create doctor/patient first and try again");
                }
                break;
            case "2":
                LOGGER.info("All scheduled appointments");
                if (isAppointmentExist1()) {
                    AppointmentUtils.allScheduledAppointments();
                    LOGGER.info("List of appointments printed.");
                } else {
                    LOGGER.info("There is no appointment scheduled yet, please try again");
                }
                break;
            case "3":
                if (isAppointmentExist()) {
                    LOGGER.info("To cancel appointment please enter patient name:");
                    String patientName = scanner.nextLine();
                    for (int i = 0; i < Hospital.getAppointments().size(); i++) {
                        if (Hospital.getAppointments().get(i).toString().contains(patientName)) {
                            Hospital.getAppointments().remove(i);
                            LOGGER.info("=== Appointment with doctor is canceled ===");
                            System.out.println();
                            break;
                        }
                    }
                } else {
                    LOGGER.info("There is no scheduled appointments in database");
                }
                break;
            case "4":
                printOptions();
                do {
                    option = scanner.next();
                    makeAChoice(option);
                } while (!option.equals("0"));
                break;
        }
    }

    private static void printDoctorOptions() {
        LOGGER.info("1 - For new doctor");
        LOGGER.info("2 - To update doctor specialization with doctor id");
        LOGGER.info("3 - To search for doctor with doctor id and print all other doctor information");
        LOGGER.info("4 - To delete doctor info with doctor id");
        LOGGER.info("5 - To main page");
    }

    private static void makeChoiceForDoctor(String option) {
        Doctor doctor = new Doctor();
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                LOGGER.info("Please enter doctors firstName:");
                String docFirstName = scanner.nextLine();
                if (docFirstName.isEmpty()) {
                    LOGGER.info("first name can't be empty, try again");
                }
                LOGGER.info("Please enter doctors lastName:");
                String docLastName = scanner.nextLine();
                if (docLastName.isEmpty()) {
                    LOGGER.info("last name can't be empty, try again");
                }
                LOGGER.info("Please enter doctors ID:");
                String docID = scanner.nextLine();
                LOGGER.info("Please enter doctor phoneNumber:");
                String docPhone = scanner.nextLine();
                LOGGER.info("Please enter doctors gender:");
                String docGender = scanner.nextLine();
                LOGGER.info("Please enter doctors age:");
                String docAge = scanner.nextLine();
                try {
                    Person.validateAgeOfPerson(docAge);
                } catch (NegativeAgeException e) {
                    LOGGER.info(e.getMessage());
                    break;
                }
                LOGGER.info("Please enter doctors specialization:");
                String specialization = scanner.nextLine();
                doctor.createUser(docFirstName, docLastName, docID, docPhone, docGender, docAge,
                        specialization);
                Hospital.getDoctorDir().add(doctor);
                LOGGER.info("Doctor is created");
                break;
            case "2":
                if (isDoctorExist()) {
                    LOGGER.info("Please enter doctor id:");
                    String doctorID = scanner.nextLine();
                    try {
                        doctor.updateUser(doctorID);
                        LOGGER.info("Doctor specialization is updated");
                    } catch (UserNotFoundException e) {
                        LOGGER.error("Error occurred ", e);
                    }
                } else {
                    LOGGER.info("There is no doctor in database, please try again");
                }
                break;
            case "3":
                if (isDoctorExist()) {
                    boolean ifDoctorNotFound = true;
                    LOGGER.info("Please enter doctor id:");
                    String doctorIDToSearch = scanner.nextLine();
                    for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
                        if (Hospital.getDoctorDir().get(i).getPersonID().equals(doctorIDToSearch)) {
                            LOGGER.info("-----------------------------------");
                            LOGGER.info(Hospital.getDoctorDir().get(i).toString());
                            LOGGER.info("-----------------------------------");
                            ifDoctorNotFound = false;
                        }
                    }
                    if (ifDoctorNotFound) {
                        LOGGER.info("No doctor that matches with given ID, please try again.");
                    } else {
                        LOGGER.info("Doctor information printed.");
                    }
                } else {
                    LOGGER.info("There is no doctor in database, please try again");
                }
                break;
            case "4":
                if (isDoctorExist()) {
                    LOGGER.info("To delete doctor information please enter docID:");
                    String doctorToDelete = scanner.nextLine();
                    try {
                        doctor.deleteUser(doctorToDelete);
                        LOGGER.info("=== Doctor is deleted. ===");
                    } catch (InvalidUserIdException e) {
                        LOGGER.info(e.getMessage());
                    }
                } else {
                    LOGGER.info("There is no doctor in database, please create doctor ");
                }
                break;
            case "5":
                printOptions();
                do {
                    option = scanner.next();
                    makeAChoice(option);
                } while (!option.equals("0"));
                break;
        }
    }

    private static void printPatientOptions() {
        LOGGER.info("Please choose on of the following options");
        LOGGER.info("1 - For new patient");
        LOGGER.info("2 - To update patient diagnosis");
        LOGGER.info("3 - To send message to patient");
        LOGGER.info("4 - To delete patient info with patient id");
        LOGGER.info("5 - To print all patients info");
        LOGGER.info("6 - To choose provider");
        LOGGER.info("7 - To view information about provider");
        LOGGER.info("8 - To main page");
    }

    private static void makeAChoiceForPatient(String option) {
        Patient patient = new Patient();
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                LOGGER.info("Please enter patients firstName:");
                String firstName = scanner.nextLine();
                if (firstName.isEmpty()) {
                    LOGGER.error("First name can't be blank, please try again");
                    break;
                }
                LOGGER.info("First name entered.");
                LOGGER.info("Please enter patients lastName:");
                String lastName = scanner.nextLine();
                if (lastName.isEmpty()) {
                    LOGGER.error("Last name can't be blank, please try again");
                    break;
                }
                LOGGER.info("Please enter patients phone number:");
                String phoneNumber = scanner.nextLine();
                LOGGER.info("Please enter patients gender:");
                String gender = scanner.nextLine();
                LOGGER.info("Please patients age:");
                String age = scanner.nextLine();
                try {
                    Person.validateAgeOfPerson(age);
                } catch (NegativeAgeException e) {
                    LOGGER.error("Negative age entered.", e);
                    break;
                }
                LOGGER.info("Please enter patients bloodGroup:");
                String bloodGroup = scanner.nextLine();
                LOGGER.info("Please enter patients diagnosis:");
                String diagnosis = scanner.nextLine();
                LOGGER.info("Please enter patients hospitalization date:");
                String hospitalizationDate = scanner.nextLine();
                patient.createPatient(firstName, lastName, phoneNumber, gender, age, bloodGroup,
                        diagnosis, hospitalizationDate);
                Hospital.getPatientDir().add(patient);
                LOGGER.info("=== Patient is created. ===");
                break;
            case "2":
                if (isPatientExist()) {
                    LOGGER.info("Please enter patients id:");
                    String patientID = scanner.nextLine();
                    patient.updateUser(patientID);
                    LOGGER.info("Patient diagnose is updated.");
                } else {
                    LOGGER.info("There is no patient in database, please create patient");
                }
                break;
            case "3":
                patient.sendMessageToPatient();
                LOGGER.info("Message sent to patient.");
                break;
            case "4":
                if (isPatientExist()) {
                    LOGGER.info("Please enter patients id:");
                    String patientToDelete = scanner.nextLine();
                    try {
                        patient.deleteUser(patientToDelete);
                    } catch (UserNotFoundException e) {
                        LOGGER.error("Exception occurred -> ",e);
                    }
                    LOGGER.info("Patient is deleted.");
                } else {
                    LOGGER.info("There is no patient in database, please create patient");
                }
                break;
            case "5":
                LOGGER.info("-- All patients information --");
                if (isPatientExist()) {
                    for (int i = 0; i < Hospital.getPatientDir().size(); i++) {
                        LOGGER.info("--------------------------------------------");
                        LOGGER.info(Hospital.getPatientDir().get(i).toString());
                        LOGGER.info("--------------------------------------------");
                    }
                    LOGGER.info("Patient information printed.");
                } else {
                    LOGGER.info("There is no patient in database, please try again");
                }
                break;
            case "6":
                LOGGER.info("Please enter patient name");
                String patName=scanner.nextLine();
                LOGGER.info("Please doctor name from list:");
                for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
                    LOGGER.info(i + 1 + ")" + Hospital.getDoctorDir().get(i).getFirstName() + " " + Hospital.getDoctorDir().get(i).getLastName());
                }
                String docNumberFromList = scanner.nextLine();
                String docFullName = Hospital.getDoctorDir().get(Integer.parseInt(docNumberFromList) - 1).getFirstName()
                        + " " + Hospital.getDoctorDir().get(Integer.parseInt(docNumberFromList) - 1).getLastName();

                Patient pat = Hospital.getPatientByName(patName);
                Doctor doc = Hospital.getDoctorByName(docFullName);
                patient.selectProvider(pat,doc);
                LOGGER.info("You have successfully set provider, your provider name "+ docFullName);
                break;
            case"7":
                LOGGER.info("Please enter patient name");
                String patientsName = scanner.nextLine();
                LOGGER.info(Hospital.getHealthProviders().get(Hospital.getPatientByName(patientsName)));
                LOGGER.info("Provider info printed");
                break;
            case "8":
                printOptions();
                do {
                    option = scanner.next();
                    makeAChoice(option);
                } while (!option.equals("0"));
                break;
        }
    }
    public static void continueOperation() {
        LOGGER.info("Click 1 to go main page");
        LOGGER.info("Click 0 to exit");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                printOptions();
                break;
            case "0":
                makeAChoice("0");
                break;
            default:
                continueOperation();
                break;
        }
    }

    public static boolean isDoctorExist() {
        return !Hospital.getDoctorDir().isEmpty();
    }

    public static boolean isPatientExist() {
        return !Hospital.getPatientDir().isEmpty();
    }

    public static boolean isNurseExist() {
        return !Hospital.getNurseDir().isEmpty();
    }

    public static boolean isInternExist() {
        return !Hospital.getInternDir().isEmpty();
    }

    public static boolean isAppointmentExist() {
        return !Hospital.getAppointments().isEmpty();
    }

    public static boolean isAppointmentExist1() {
        return !Hospital.getAppointments().isEmpty();
    }



}
