import dao.ClienteDAO;
import model.Cliente;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
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
                    System.out.print("ID a actualizar: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    nombre = sc.nextLine();
                    dao.actualizar(new Cliente(id, nombre));
                    break;

                case 4:
                    System.out.print("ID a eliminar: ");
                    id = sc.nextInt();
                    dao.eliminar(id);
                    break;
            }

        } while (opcion != 0);
    }
}