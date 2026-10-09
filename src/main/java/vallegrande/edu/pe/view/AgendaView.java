package vallegrande.edu.pe.view;

import vallegrande.edu.pe.model.Contacto;
import java.util.Scanner;

public class AgendaView {

    private Scanner scanner;

    public AgendaView() {
        scanner = new Scanner(System.in);
    }

    //Mostrar Titulo
    public void mostrarTitulo() {
        System.out.println("================ AGENDA DE CONTACTOS ================");
    }

    //Mostrar Mensaje
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    //Menú de consola exacto solicitado en la guía
    public int mostrarMenuYObtenerOpcion() {
        System.out.println("\n1. Registrar contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            return opcion;
        } else {
            scanner.nextLine();
            return -1;
        }
    }

    //Lectura de datos para un nuevo contacto
    public Contacto solicitarDatosContacto() {
        System.out.println("\n--- REGISTRO DE NUEVO CONTACTO ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        return new Contacto(id, nombres, apellidos, direccion, telefono, correo);
    }

    //Solicitar criterio de búsqueda
    public String solicitarCriterioBusqueda() {
        System.out.print("\nIngrese el nombre o apellido a buscar: ");
        return scanner.nextLine();
    }

    //Solicitar ID para eliminar
    public int solicitarIdEliminar() {
        System.out.print("\nIngrese el ID del contacto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}