package com.example.dbapp;

import static com.example.dbapp.VariousQueriesAndScanner.setupClosingDBConnection;

public class MainMenu {
    public static void main(String[] args) {
        Database.connect();
        setupClosingDBConnection();
    }
}