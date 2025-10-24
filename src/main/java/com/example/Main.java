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
        
        while (opcion!=11) {
            System.out.println("1. Crear tabla libro");
            System.out.println("2. Añade un libro");
            System.out.println("3. Listar libros");
            System.out.println("4. Lista los libros de un autor");
            System.out.println("5. Listar los libros posteriores de un año determinado");
            System.out.println("6. Modificar un titulo");
            System.out.println("7. Modifica un autor");
            System.out.println("8. Elimina un libro");
            System.out.println("9. Elimina un libro anterior a un año");
            System.out.println("10. Elimina todos los registros");
            System.out.println("11. Salir");
            System.out.print("Introduce una opción: ");
            opcion = sc.nextInt();
            System.out.println();
            int año;
            String autor;
            String ISBN;
            sc.nextLine();
            switch (opcion) {
                case 1:
                    gestor.crearTabla();
                    System.out.println();
                    break;
                case 2:
                    gestor.añadirLibro("Libro", "12345", "Harry Potter", "JK Rowling", "2000");
                    gestor.añadirLibro("Libro", "12346", "Señor de los anillos", "Tolkien", "1954");
                    System.out.println();
                    break;
                case 3:
                    gestor.listarLibros();
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Introduce el autor: ");
                    autor=sc.nextLine();
                    gestor.listarLibrosAutor(autor);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Introduce el año: ");
                    año = sc.nextInt();
                    sc.nextLine();
                    gestor.listarLibrosAño(año);
                    System.out.println();
                    break;
                case 6:
                    gestor.modificarTitulo("Harry Potter 2", "12345");
                    System.out.println();
                    break;
                case 7:
                    gestor.modificarAutor("Rowling", "12345");
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Introduce el ISBN del libro: ");
                    ISBN=sc.nextLine();
                    gestor.eliminarLibro(ISBN);
                    System.out.println();
                    break;
                case 9:
                    System.out.print("Introduce el año: ");
                    año = sc.nextInt();
                    gestor.eliminarLibroAño(año);
                    System.out.println();
                    break;
                case 10:
                    gestor.cleanLibros();
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
        System.out.println("Saliendo...");
    }
}