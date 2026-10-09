package vallegrande.edu.pe.misistema.controller;

import vallegrande.edu.pe.misistema.view.MainView;

public class MainController {

    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        configurarEventos();
    }

    private void configurarEventos() {
        // Eventos base
        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });

        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
        });

        view.getBtnProductos().setOnAction(e -> {
            view.mostrarProductos();
        });

        // Eventos de las 3 nuevas opciones
        view.getBtnReportes().setOnAction(e -> {
            view.mostrarReportes();
        });

        view.getBtnVentas().setOnAction(e -> {
            view.mostrarVentas();
        });

        view.getBtnConfiguracion().setOnAction(e -> {
            view.mostrarConfiguracion();
        });
    }
}