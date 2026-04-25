package controller;

import dao.LoginDAO;
import java.util.Scanner;

public class LoginMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginDAO dao = new LoginDAO();

        System.out.println("===== LOGIN CLIENTE =====");

        System.out.print("Usuario (Nombre): ");
        String usuario = sc.nextLine();

        System.out.print("Contraseña (ID): ");
        int password = sc.nextInt();

        boolean acceso = dao.login(usuario, password);

        if (acceso) {
            System.out.println("✔ Acceso permitido");
            System.out.println("Bienvenido " + usuario);
        } else {
            System.out.println("❌ Usuario o contraseña incorrectos");
        }
    }
}
