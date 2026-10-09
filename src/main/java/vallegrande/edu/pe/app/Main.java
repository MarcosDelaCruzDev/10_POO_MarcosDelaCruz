package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import vallegrande.edu.pe.view.AgendaView;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Crear los componentes
        AgendaController controller = new AgendaController();
        AgendaView view = new AgendaView();

        //Carga Mínima de Pruebas: 5 contactos precargados
        controller.agregarContacto(new Contacto(1, "Ana", "Torres", "Cañete", "983745656", "ana@gmail.com"));
        controller.agregarContacto(new Contacto(2, "Carlos", "Perez", "Imperial", "951264456", "carlos@gmail.com"));
        controller.agregarContacto(new Contacto(3, "Marcos", "De la Cruz", "Mala", "987654321", "marcos@gmail.com"));
        controller.agregarContacto(new Contacto(4, "Luis", "Mendoza", "Mala", "987654321", "luis@gmail.com"));
        controller.agregarContacto(new Contacto(5, "Maria", "Rojas", "San Vicente", "912345678", "maria@gmail.com"));

        int opcion;

        view.mostrarTitulo();

        do {
            opcion = view.mostrarMenuYObtenerOpcion();

            switch (opcion) {
                case 1:
                    Contacto nuevo = view.solicitarDatosContacto();
                    controller.agregarContacto(nuevo);
                    view.mostrarMensaje("Contacto agregado correctamente.");
                    break;

                case 2:
                    controller.listarContactos();
                    break;

                case 3:
                    String criterio = view.solicitarCriterioBusqueda();
                    ArrayList<Contacto> resultados = controller.buscarContacto(criterio);
                    if (resultados.isEmpty()) {
                        view.mostrarMensaje("No se encontraron contactos que coincidan con: " + criterio);
                    } else {
                        view.mostrarMensaje("\n--- RESULTADOS DE LA BÚSQUEDA ---");
                        for (Contacto c : resultados) {
                            c.mostrarContacto();
                        }
                    }
                    break;

                case 4:
                    int idEliminar = view.solicitarIdEliminar();
                    boolean eliminado = controller.eliminarContacto(idEliminar);
                    if (eliminado) {
                        view.mostrarMensaje("Contacto con ID " + idEliminar + " eliminado correctamente.");
                    } else {
                        view.mostrarMensaje("No se encontró ningún contacto con el ID " + idEliminar);
                    }
                    break;

                case 5:
                    view.mostrarMensaje("¡Saliendo del programa!");
                    break;

                default:
                    view.mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 5);
    }
}