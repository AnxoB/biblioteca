package com.example;

import java.sql.Statement;
import java.util.Scanner;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.conexiones.DBConnection;
import com.conexiones.MySQLConnection;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quieres borrar la base de datos si existe?(s/n)");
        String borrar = sc.nextLine();
        if (borrar.toLowerCase()=="s") {
            new GestorBiblioteca("biblioanxoB", true);
        } else {
            new GestorBiblioteca("biblioanxoB", false);
        }
        GestorLibros gestor = new GestorLibros("biblioanxoB");
        
        
        
        
        
        

        int opcion = 0;
        
        while (opcion!=10) {
            System.out.println("1. Crear tabla libro");
            System.out.println("2. Añade un libro");
            System.out.println("3. Listar libros");
            System.out.println("4. Lista los libros de un autor");
            System.out.println("5. Listar los libros de un año determinado");
            System.out.println("6. Modificar un titulo");
            System.out.println("Introduce una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    gestor.crearTabla();
                    break;
                case 2:
                    gestor.añadirLibro("Libro", "12345", "Harry Potter", "JK Rowling", "2000");
                    break;
                case 3:
                    gestor.listarLibros();
                    break;
                case 4:
                    gestor.listarLibrosAutor("JK Rowling");
                    break;
                case 5:
                    System.out.println("Introduce el año: ");
                    int año = sc.nextInt();
                    sc.nextLine();
                    gestor.listarLibrosAño(año);
                    break;
                case 6:
                    gestor.modificarTitulo("Harry Potter 2", "12345");
                    break;
                case 7:
                    gestor.modificarAutor("Rowling", "12345");
                    break;
                default:
                    break;
            }
        }
        
    }
}