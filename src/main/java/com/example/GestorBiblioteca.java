package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.conexiones.MySQLConnection;

public class GestorBiblioteca {
    private static final String URL="jdbc:mysql://localhost:3306";
    private static final String USER="root";
    private static final String PASSWORD="root";
    GestorBiblioteca(String nombre, boolean borrarSiExiste){
        crearBaseDatos(nombre, borrarSiExiste);
    }
    public void crearBaseDatos(String nombre, boolean borrar){
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conexion.createStatement()) {
            if (borrar==true) {
                statement.executeUpdate("DROP DATABASE IF EXISTS " + nombre);
            }
            String sql = "CREATE DATABASE IF NOT EXISTS " + nombre;

            statement.executeUpdate(sql);
            System.out.println("Base da datos creada");
            

        } catch (Exception e) {
            System.err.println("Error creando " + e.getMessage());
        }
    }
}
