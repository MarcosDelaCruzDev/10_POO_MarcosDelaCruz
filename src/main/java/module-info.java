module vallegrande.edu.pe.sistemaproductores {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens vallegrande.edu.pe.sistemaproductores to javafx.fxml;
    opens vallegrande.edu.pe.sistemaproductores.controller to javafx.fxml;
    opens vallegrande.edu.pe.sistemaproductores.model to javafx.base;

    exports vallegrande.edu.pe.sistemaproductores;
}