package com.example.dbapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static com.example.dbapp.VariousQueriesAndScanner.setupClosingDBConnection;

public class MainMenu {
    public static void main(String[] args) {
        Database.connect();
        setupClosingDBConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select one of the following options:");
            while(true) {
                System.out.println("1. Add new patient");
                System.out.println("2. Get doctor info based on ID");
                System.out.println("3. Delete Appointment");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            addCustomPatient();
                            break;
                        case 2:
                            getSpecificDoctor();
                            break;
                        case 3:
                            deleteAppointment();
                            break;
                        case 4:


                        default:
                            System.out.println("Invalid option");
                            break;
                    }

                }


    }

    public static void addCustomPatient() {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Enter Patient ID: ");
        int patientID = getInput.nextInt();
        System.out.println("Enter Patient Name: ");
        getInput.nextLine();
        String patientName = getInput.nextLine();
        System.out.println("Enter Patient Date of Birth: ");
        String dateOfBirth = getInput.nextLine();
        try{
            String query = "Insert INTO Patients VALUES (?,?,?)";
            PreparedStatement stm = Database.connection.prepareStatement(query);
            stm.setInt(1, patientID);
            stm.setString(2, patientName);
            stm.setString(3, dateOfBirth);
            stm.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getAllPatients() {
        try {
            String query = "SELECT * FROM Patients";
            PreparedStatement stm = Database.connection.prepareStatement(query);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                System.out.println("Patient ID: " + result.getInt("patient_id"));
                System.out.println("Patient Name: " + result.getString("patient_name"));
                System.out.println("Patient Date Of Birth: " + result.getString("date_of_birth"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void getSpecificPatient() {
        try {
            String query = "SELECT * FROM Patients WHERE patient_id = ?";
            PreparedStatement stm = Database.connection.prepareStatement(query);
            stm.setInt(1, 1);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                System.out.println("Patient ID: " + result.getInt("patient_id"));
                System.out.println("Patient Name: " + result.getString("patient_name"));
                System.out.println("Patient Date Of Birth: " + result.getString("date_of_birth"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void getAllDoctors() {
        try {
            String query = "SELECT * FROM Doctors";
            PreparedStatement stm = Database.connection.prepareStatement(query);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                System.out.println("Doctor ID: " + result.getInt("doctor_id"));
                System.out.println("Doctor Name: " + result.getString("doctor_name"));
                System.out.println("Doctor Date Of Birth: " + result.getString("doctor_focus"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void addPatient() {
        try{
            String query = "INSERT INTO Patients VALUES (?, ?, ?)";
            PreparedStatement stm = Database.connection.prepareStatement(query);

            stm.setInt(1,9);
            stm.setString(2, "Cosmo Patio");
            stm.setString(3, "05/22/2000");
            stm.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void getPatientName() {
        try {
            String query = "SELECT * FROM Patients WHERE patient_name = ?";
            PreparedStatement stm = Database.connection.prepareStatement(query);
            stm.setString(1, "Thomas Tank");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                System.out.println("Patient ID: " + result.getInt("patient_id"));
                System.out.println("Patient Name: " + result.getString("patient_name"));
                System.out.println("Patient Date Of Birth: " + result.getString("date_of_birth"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void addAppointment() {
        try{
            String query = "INSERT INTO Appointments VALUES (?, ?, ?, ?)";
            PreparedStatement stm = Database.connection.prepareStatement(query);

            stm.setInt(1, 1);
            stm.setString(2, "03/15/2023");
            stm.setInt(3, 1);
            stm.setInt(4, 5);
            stm.executeUpdate();

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public static void deleteAppointment() {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Enter Appointment ID: ");
        int appointmentID = getInput.nextInt();
        try {
            String query = "DELETE FROM Appointments WHERE appointment_id = ?";
            PreparedStatement stm = Database.connection.prepareStatement(query);
            stm.setInt(1, appointmentID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void getSpecificDoctor() {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Enter Doctor ID: ");
        int doctorID = getInput.nextInt();
        try {
            String query = "SELECT * FROM Doctors WHERE doctor_id = ?";
            PreparedStatement stm = Database.connection.prepareStatement(query);
            stm.setInt(1, doctorID);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                System.out.println("Doctor ID: " + result.getInt("doctor_id"));
                System.out.println("Doctor Name: " + result.getString("doctor_name"));
                System.out.println("Doctor Focus: " + result.getString("doctor_focus"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
