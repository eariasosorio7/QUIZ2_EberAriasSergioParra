/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.254.215:1521:orcl",
                "QUIZ2PROGII",
                "QUIZ2"
            );
            System.out.println("Conectado correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }
}

