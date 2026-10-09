package vallegrande.edu.pe.proyecto.controller;

import vallegrande.edu.pe.proyecto.model.Contacto;
import vallegrande.edu.pe.proyecto.model.ContactoDAO;
import vallegrande.edu.pe.proyecto.view.MainView;

import java.util.List;

public class MainController {

    private MainView view;
    private ContactoDAO contactoDAO;

    public MainController(MainView view) {
        this.view = view;
        this.contactoDAO = new ContactoDAO();
        configurarEventos();
    }

    private void configurarEventos() {
        // Eventos base
        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });

        view.getBtnContactos().setOnAction(e -> {
            view.mostrarContactos();
            cargarContactos();
        });


        // CRUD de contactos
        view.getBtnRegistrar().setOnAction(e -> {
            registrarContacto();
        });

        view.getBtnActualizar().setOnAction(e -> {
            actualizarContacto();
        });

        view.getBtnEliminar().setOnAction(e -> {
            eliminarContacto();
        });

        // 1. Seleccionar registro  ->  2. Cargar formulario
        view.getTablaContactos().getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        view.cargarContactoEnFormulario(seleccionado);
                    }
                }
        );
    }

    // 6. Refrescar vista: sincroniza la TableView con la BD
    private void cargarContactos() {
        List<Contacto> contactos = contactoDAO.listar();
        view.mostrarDatosContactos(contactos);
    }

    private void registrarContacto() {
        if (!view.formularioValido()) {
            view.mostrarMensaje("Completa todos los campos antes de registrar.");
            return;
        }
        Contacto contacto = new Contacto();
        contacto.setNombre(view.getNombre());
        contacto.setApellido(view.getApellido());
        contacto.setTelefono(view.getTelefono());
        contacto.setCorreo(view.getCorreo());
        contacto.setMensaje(view.getMensaje());

        contactoDAO.insertar(contacto);
        cargarContactos();
        view.limpiarFormulario();
    }

    // 3. Modificar datos (en el formulario)  ->  4. Ejecutar UPDATE
    private void actualizarContacto() {
        Contacto contacto = view.getContactoSeleccionado();
        if (contacto == null) {
            view.mostrarMensaje("Selecciona un contacto de la tabla para actualizar.");
            return;
        }
        if (!view.formularioValido()) {
            view.mostrarMensaje("Completa todos los campos antes de actualizar.");
            return;
        }
        contacto.setNombre(view.getNombre());
        contacto.setApellido(view.getApellido());
        contacto.setTelefono(view.getTelefono());
        contacto.setCorreo(view.getCorreo());
        contacto.setMensaje(view.getMensaje());

        contactoDAO.actualizar(contacto);
        cargarContactos();
        view.limpiarFormulario();
    }

    // 5. Ejecutar DELETE  ->  6. Refrescar vista
    private void eliminarContacto() {
        Contacto contacto = view.getContactoSeleccionado();
        if (contacto == null) {
            view.mostrarMensaje("Selecciona un contacto de la tabla para eliminar.");
            return;
        }
        contactoDAO.eliminar(contacto.getId());
        cargarContactos();
        view.limpiarFormulario();
    }
}