package vista;

import dao.ClienteDAO;
import dao.ServicioDAO;
import model.Cliente;
import model.Servicio;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClienteDAO clienteDAO = new ClienteDAO();
        ServicioDAO servicioDAO = new ServicioDAO();

        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. CRUD CLIENTE");
            System.out.println("2. CRUD SERVICIOS");
            System.out.println("0. SALIR");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                // ================= CLIENTE =================
                case 1:
                    menuCliente(sc, clienteDAO);
                    break;

                // ================= SERVICIOS =================
                case 2:
                    menuServicio(sc, servicioDAO);
                    break;
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado");
    }

    // ================= MENÚ CLIENTE =================
    public static void menuCliente(Scanner sc, ClienteDAO dao) {

        int op;

        do {
            System.out.println("\n--- CLIENTE ---");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    dao.insertar(new Cliente(id, nombre));
                    break;

                case 2:
                    dao.listar();
                    break;

                case 3:
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    nombre = sc.nextLine();

                    dao.actualizar(new Cliente(id, nombre));
                    break;

                case 4:
                    System.out.print("ID: ");
                    id = sc.nextInt();

                    dao.eliminar(id);
                    break;
            }

        } while (op != 0);
    }

    // ================= MENÚ SERVICIOS =================
    public static void menuServicio(Scanner sc, ServicioDAO dao) {

        int op;

        do {
            System.out.println("\n--- SERVICIOS ---");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    dao.insertar(new Servicio(id, nombre));
                    break;

                case 2:
                    dao.listar();
                    break;

                case 3:
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    nombre = sc.nextLine();

                    dao.actualizar(new Servicio(id, nombre));
                    break;

                case 4:
                    System.out.print("ID: ");
                    id = sc.nextInt();

                    dao.eliminar(id);
                    break;
            }

        } while (op != 0);
    }
}