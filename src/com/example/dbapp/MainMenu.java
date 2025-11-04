package com.example.dbapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.dbapp.VariousQueriesAndScanner.setupClosingDBConnection;

public class MainMenu {
    public static void main(String[] args) {
        Database.connect();
        getAllDoctors();
        setupClosingDBConnection();

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
}
