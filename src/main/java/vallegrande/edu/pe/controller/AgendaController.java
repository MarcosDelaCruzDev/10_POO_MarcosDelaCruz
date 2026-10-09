package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;

public class AgendaController {

    //Lista Contactos ( Almacenar )
    private ArrayList<Contacto> contactos;

    //Constructor
    public AgendaController(){
        contactos = new ArrayList<>();
    }

    //Agregar Contacto
    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
    }

    //Obtener todos los contactos
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    //Listar Contactos
    public void listarContactos(){
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("--- LISTA DE CONTACTOS ---");
        for (Contacto contacto : contactos){
            contacto.mostrarContacto();
        }
    }

    //Buscar Contacto por Nombre o Apellido
    public ArrayList<Contacto> buscarContacto(String criterio) {
        ArrayList<Contacto> encontrados = new ArrayList<>();
        for (Contacto contacto : contactos) {
            if (contacto.getNombres().toLowerCase().contains(criterio.toLowerCase()) ||
                    contacto.getApellidos().toLowerCase().contains(criterio.toLowerCase())) {
                encontrados.add(contacto);
            }
        }
        return encontrados;
    }

    //Eliminar Contacto por ID
    public boolean eliminarContacto(int id) {
        return contactos.removeIf(contacto -> contacto.getId() == id);
    }
}