module vallegrande.edu.pe.proyecto {
    requires javafx.controls;
    requires java.sql;

    opens vallegrande.edu.pe.proyecto to javafx.graphics;
    opens vallegrande.edu.pe.proyecto.view to javafx.graphics;
    opens vallegrande.edu.pe.proyecto.controller to javafx.graphics;
    opens vallegrande.edu.pe.proyecto.model to javafx.base;

    exports vallegrande.edu.pe.proyecto;
    exports vallegrande.edu.pe.proyecto.view;
    exports vallegrande.edu.pe.proyecto.controller;
    exports vallegrande.edu.pe.proyecto.model;
}