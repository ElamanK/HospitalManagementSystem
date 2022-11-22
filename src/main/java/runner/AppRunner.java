package runner;

import appointments.Appointment;

import appointments.AppointmentUtils;
import users.*;


import java.util.*;

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


    private static void printOptions() {
        System.out.println("Please choose on of the following options");
        System.out.println("1 - For new patient");
        System.out.println("2 - To update patient diagnosis");
        System.out.println("3 - To send message to patient");
        System.out.println("4 - To delete patient info with patient id");
        System.out.println("5 - To print all patients info");
        System.out.println("6 - For new Doctor");
        System.out.println("7 - To update Doctor specialization with doctor id");
        System.out.println("8 - To search the Doctor with doctor id and print all other doctor information");
        System.out.println("9 - To delete doctor info with doctor id");
        System.out.println("10 - To make appointment with doctor");
        System.out.println("11 - To view all scheduled appointments");
        System.out.println("12 - To cancel appointment");
        System.out.println("13 - For new Nurse");
        System.out.println("14 - To search the Nurse with nurse id and print all other nurse information");
        System.out.println("15 - For new Intern");
        System.out.println("16 - To update Intern specialization");
        System.out.println("17 - To search for Intern with intern id and print all other intern information");
        System.out.println("0 - To exit");
    }


    private static void makeAChoice(String choice) {
        Patient patient = new Patient();
        Doctor doctor = new Doctor();
        Nurse nurse = new Nurse();
        Intern intern = new Intern();
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "0":
                System.out.println("Thank you for using our application");
                break;
            case "1":
                System.out.println("Please enter patients firstName:");
                String firstName = scanner.nextLine();
                System.out.println("Please enter patients lastName:");
                String lastName = scanner.nextLine();
                System.out.println("Please enter patients phone number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Please enter patients gender:");
                String gender = scanner.nextLine();
                System.out.println("Please patients age:");
                String age = scanner.nextLine();
                System.out.println("Please enter patients bloodGroup:");
                String bloodGroup = scanner.nextLine();
                System.out.println("Please enter patients diagnosis:");
                String diagnosis = scanner.nextLine();
                System.out.println("Please enter patients hospitalization date:");
                String hospitalizationDate = scanner.nextLine();
                patient.createPatient(firstName, lastName, phoneNumber, gender, age, bloodGroup,
                        diagnosis, hospitalizationDate);
                Hospital.getPatientDir().add(patient);
                System.out.println("==============================");
                System.out.println("===== Patient is created =====");
                System.out.println("==============================");
                continueOperation();
                break;
            case "2":
                if (isPatientExist()) {
                    System.out.println("Please enter patients id:");
                    String patientID = scanner.nextLine();
                    patient.updateUserSpecialization(patientID);
                } else {
                    System.out.println("There is no patient in database, please create patient");
                }
                continueOperation();
                break;
            case "3":
                patient.sendMessageToPatient();
                continueOperation();
                break;
            case "4":
                if (isPatientExist()) {
                    System.out.println("Please enter patients id:");
                    String patientToDelete = scanner.nextLine();
                    patient.deleteUser(patientToDelete);
                } else {
                    System.out.println("There is no patient in database, please create patient");
                }
                continueOperation();
                break;
            case "5":
                System.out.println("-- All patients information --");
                if (isPatientExist()) {
                    for (int i = 0; i < Hospital.getPatientDir().size(); i++) {
                        System.out.println("--------------------------------------------");
                        System.out.println(Hospital.getPatientDir().get(i).toString());
                        System.out.println("--------------------------------------------");
                    }
                } else {
                    System.out.println("There is no patient in database, please try again");
                }
                continueOperation();
                break;
            case "6":
                System.out.println("Please enter doctors firstName:");
                String docFirstName = scanner.nextLine();
                System.out.println("Please enter doctors lastName:");
                String docLastName = scanner.nextLine();
                System.out.println("Please enter doctors ID:");
                String docID = scanner.nextLine();
                System.out.println("Please enter doctor phoneNumber:");
                String docPhone = scanner.nextLine();
                System.out.println("Please enter doctors gender:");
                String docGender = scanner.nextLine();
                System.out.println("Please enter doctors age:");
                String docAge = scanner.nextLine();
                System.out.println("Please enter doctors specialization:");
                String specialization = scanner.nextLine();
                doctor.createUser(docFirstName, docLastName, docID, docPhone, docGender, docAge,
                        specialization);
                Hospital.getDoctorDir().add(doctor);
                System.out.println("==============================");
                System.out.println("===== Doctor is created ======");
                System.out.println("==============================");
                continueOperation();
                break;
            case "7":
                if (isDoctorExist()) {
                    System.out.println("Please enter doctor id:");
                    String doctorID = scanner.nextLine();
                    for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
                        if (Hospital.getDoctorDir().get(i).getDocID().equals(doctorID)) {
                            System.out.println("Please enter updated specialization below:");
                            String updatedSpecialization = scanner.nextLine();
                            Hospital.getDoctorDir().get(i).setSpecialization(updatedSpecialization);
                            System.out.println("Doctors specialization is updated to " + updatedSpecialization + ".");
                        }
                    }
                } else {
                    System.out.println("There is no doctor in database, please try again");
                }
                continueOperation();
                break;
            case "8":
                if (isDoctorExist()) {
                    System.out.println("Please enter doctor id:");
                    String doctorIDToSearch = scanner.nextLine();
                    for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
                        if (Hospital.getDoctorDir().get(i).getDocID().equals(doctorIDToSearch)) {
                            System.out.println("-----------------------------------");
                            System.out.println(Hospital.getDoctorDir().get(i).toString());
                            System.out.println("-----------------------------------");
                        } else {
                            System.out.println("There is no doctor with ID " + doctorIDToSearch + " please try again");
                        }
                    }
                } else {
                    System.out.println("There is no doctor in database, please try again");
                }
                continueOperation();
                break;
            case "9":
                if (isDoctorExist()) {
                    System.out.println("To delete doctor information please enter docID:");
                    String doctorToDelete = scanner.nextLine();
                    doctor.deleteUser(doctorToDelete);
                } else {
                    System.out.println("There is no doctor in database, please create doctor ");
                }
                continueOperation();
                break;
            case "10":
                if (isDoctorExist()&&isPatientExist()) {
                    System.out.println("Please enter doctors full name to make an appointment");
                    String docFullName = scanner.nextLine();
                    for (int i = 0; i < Hospital.getDoctorDir().size(); i++) {
                        if ((Hospital.getDoctorDir().get(i).getFirstName() + " " + Hospital.getDoctorDir().get(i).getLastName().trim()).equals(docFullName)) {
                            System.out.println("Please enter patient full name");
                            String patientFullName = scanner.nextLine();
                            System.out.println("Enter date");
                            String appDate = scanner.nextLine();
                            System.out.println("Enter time");
                            String appTime = scanner.nextLine();
                            if (Appointment.isAppointmentAlreadyBooked(docFullName, appTime, appDate)) {
                                System.out.println("Doctor " + docFullName + " is not available at " + appTime + " please try to choose different time");
                                break;
                            }
                            AppointmentUtils.makeAppointment(docFullName,patientFullName,appDate,appTime);

                            System.out.println("Your appointment with doctor " + docFullName + " scheduled successfully");
                        } else {
                            System.out.println("There is no doctor with given name, please try again");
                            break;
                        }
                    }
                } else {
                    System.out.println("There is no doctor or patient in database, please try again");
                }
                continueOperation();
                break;
            case "11":
                System.out.println("All scheduled appointments");
                if (isAppointmentExist1()) {
                    AppointmentUtils.allScheduledAppointments();
                } else {
                    System.out.println("There is no appointment scheduled yet, please try again");
                }

                continueOperation();
                break;
            case "12":
                if (isAppointmentExist()) {
                    System.out.println("To cancel appointment please enter patient first name:");
                    String patientName = scanner.nextLine();
                    for (int i = 0; i < Hospital.getAppointmentListOfMap().size(); i++) {
                        if (Hospital.getAppointmentListOfMap().get(i).get("Patient").toString().contains(patientName)) {
                            Hospital.getAppointmentListOfMap().remove(i);
                            System.out.println("-----------------------------------------");
                            System.out.println("Your appointment with doctor is canceled");
                            System.out.println("-----------------------------------------");
                            System.out.println();
                            break;
                        }
                    }
                } else {
                    System.out.println("There is no scheduled appointments in database");
                }
                continueOperation();
                break;
            case "13":
                System.out.println("Please enter firstName:");
                String nurseFirstName = scanner.nextLine();
                System.out.println("Please enter lastName:");
                String nurseLastName = scanner.nextLine();
                System.out.println("Please enter nurse ID:");
                String nurseID = scanner.nextLine();
                System.out.println("Please enter phoneNumber:");
                String nursePhone = scanner.nextLine();
                System.out.println("Please nurse gender:");
                String nurseGender = scanner.nextLine();
                System.out.println("Please enter age:");
                String nurseAge = scanner.nextLine();
                System.out.println("Please enter specialization:");
                String nurseSpecialization = scanner.nextLine();
                nurse.createUser(nurseFirstName, nurseLastName, nurseID, nursePhone,
                        nurseGender, nurseAge, nurseSpecialization);
                Hospital.nurseDir.add(nurse);
                System.out.println("==============================");
                System.out.println("===== Nurse is created  ======");
                System.out.println("==============================");
                continueOperation();
                break;
            case "14":
                if (isNurseExist()) {
                    System.out.println("Please enter nurse id:");
                    String nurseId = scanner.nextLine();
                    for (int i = 0; i < Hospital.nurseDir.size(); i++) {
                        if (Hospital.nurseDir.get(i).getNurseID().equals(nurseId)) {
                            System.out.println("-----------------------------------");
                            System.out.println(Hospital.nurseDir.get(i).toString());
                            System.out.println("-----------------------------------");
                        }
                    }
                } else {
                    System.out.println("There is no nurse with given ID, please try again");
                }
                continueOperation();
                break;

            case "15":
                System.out.println("Please enter firstName:");
                String internFirstName = scanner.nextLine();
                System.out.println("Please enter lastName:");
                String internLastName = scanner.nextLine();
                System.out.println("Please enter intern ID:");
                String internID = scanner.nextLine();
                System.out.println("Please enter phoneNumber:");
                String interPhone = scanner.nextLine();
                System.out.println("Please patients gender:");
                String internGender = scanner.nextLine();
                System.out.println("Please enter age:");
                String internAge = scanner.nextLine();
                System.out.println("Please enter specialization:");
                String internSpecialization = scanner.nextLine();
                intern.createUser(internFirstName, internLastName, internID, interPhone,
                        internGender, internAge, internSpecialization);
                Hospital.getInternDir().add(intern);
                System.out.println("==============================");
                System.out.println("===== Intern is created ======");
                System.out.println("==============================");
                continueOperation();
                break;
            case "16":
                if (isInternExist()) {
                    System.out.println("Please enter intern id:");
                    String internIDtoUpdate = scanner.nextLine();
                    intern.updateUserSpecialization(internIDtoUpdate);
//                    for (int i = 0; i < Hospital.getInternDir().size(); i++) {
//                        if (Hospital.getInternDir().get(i).getInternID().equals(internIDtoUpdate)) {
//                            System.out.println("Please enter updated specialization below:");
//                            String updatedSpecialization = scanner.nextLine();
//                            Hospital.getInternDir().get(i).setSpecialization(updatedSpecialization);
//                            System.out.println("Intern specialization is updated to " + updatedSpecialization + ".");
//                        } else {
//                            System.out.println("There is no intern with given ID, please try again");
//                        }
//                    }
                } else {
                    System.out.println("There is no intern info in database");
                }
                continueOperation();
                break;
            case "17":
                if (isInternExist()) {
                    System.out.println("Please enter intern id:");
                    String internToSearch = scanner.nextLine();
                    boolean ifInternNotFound = true;
                    for (int i = 0; i < Hospital.getInternDir().size(); i++) {
                        if (Hospital.getInternDir().get(i).getInternID().equals(internToSearch)) {
                            System.out.println("-----------------------------------");
                            System.out.println(Hospital.getInternDir().get(i).toString());
                            System.out.println("-----------------------------------");
                            ifInternNotFound = false;
                        }
                    }
                    if(ifInternNotFound){
                        System.out.println("Intern not found with given ID, please try again");
                    }
                } else {
                    System.out.println("There is no intern in database, please try again");
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
                System.out.println("Thank you for using our application");
                break;
            default:
                System.out.println("Please chose one of these options");
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
        return !Hospital.nurseDir.isEmpty();
    }

    public static boolean isInternExist() {
        return !Hospital.getInternDir().isEmpty();
    }

    public static boolean isAppointmentExist() {
        return !Hospital.getAppointmentListOfMap().isEmpty();
    }

    public static boolean isAppointmentExist1() {
        return !Hospital.getAppointmentListOfMap().isEmpty();
    }

}
