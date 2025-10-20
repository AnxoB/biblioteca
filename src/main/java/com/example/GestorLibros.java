package com.example;

import java.util.Properties;

public class GestorLibros {
    String nombreBD;
    GestorLibros(String nombre){
        nombreBD=nombre;
    }
    String url = "jdbc:mysql://localhost:3306/" + nombreBD;
    String user = "root";
    String password = "root";

    

}
