package com.example;

import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.conexiones.DBConnection;
import com.conexiones.MySQLConnection;

public class Main {
    
    public static void main(String[] args) {
        new GestorBiblioteca("biblioanxoB", true);
    }


}