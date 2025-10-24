package com.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

public class GestorLibros {
    String nombreBD;
    private final String URL;
    private final String USER = "root";
    private final String PASSWORD = "root";
    GestorLibros(String nombre){
        this.nombreBD=nombre;
        this.URL = "jdbc:mysql://localhost:3306/" + nombreBD;
    }
    

    public void crearTabla(){
        String tabla = """
                CREATE TABLE IF NOT EXISTS Libro (
                    ISBN varchar(20) primary key,
                    titulo varchar(50),
                    autor varchar(50),
                    anho_publicacion int
                )
                """;
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            statement.execute(tabla);
            System.out.println("Tabla libro creada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void añadirLibro(String tabla, String ISBN, String titulo, String autor, String anho){
        String consulta = """
                INSERT INTO %s VALUES("%s", "%s", "%s", "%s");
                """.formatted(tabla, ISBN, titulo, autor, anho);
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate(consulta);
            System.out.println("Libro añadido");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarLibros(){
        String consulta = "SELECT * FROM Libro";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(consulta);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    public void listarLibrosAutor(String autor){
        String consulta = "SELECT * FROM Libro WHERE autor='" + autor + "'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(consulta);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    public void listarLibrosAño(int año){
        String consulta = "SELECT * FROM Libro WHERE anho_publicacion>'" + año + "'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(consulta);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    public void modificarTitulo(String titulo, String ISBN){
        String consulta = "UPDATE Libro SET titulo='" + titulo + "' WHERE ISBN='" + ISBN + "'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(consulta);
            System.out.println("Dato actualizado: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarAutor(String autor, String ISBN){
        String consulta = "UPDATE Libro SET autor='" + autor + "' WHERE ISBN='" + ISBN + "'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(consulta);
            System.out.println("Dato actualizado: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarAño(int año, String ISBN){
        String consulta = "UPDATE Libro SET anho_publicacion='" + año + "' WHERE ISBN='" + ISBN + "'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(consulta);
            System.out.println("Dato actualizado: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibro(String ISBN){
        String consulta = "DELETE FROM Libro WHERE ISBN='" + ISBN + "'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(consulta);
            System.out.println("Dato borrado: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibroAño(int año){
        String consulta = "DELETE FROM Libro WHERE ISBN<'" + año + "'";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(consulta);
            System.out.println("Dato borrado: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cleanLibros(){
        String consulta = "DELETE FROM Libro";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(consulta);
            System.out.println("Dato borrados: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }









    

}
