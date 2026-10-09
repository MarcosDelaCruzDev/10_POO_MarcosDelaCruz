package com.grandsuite.controller;

import com.grandsuite.model.Habitacion;
import com.grandsuite.model.Promocion;
import com.grandsuite.repository.HabitacionRepository;
import com.grandsuite.repository.PromocionRepository;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PrincipalController {

    @FXML
    private HBox habitacionesContainer;

    @FXML
    private VBox promocionesContainer;

    private final HabitacionRepository habitacionRepository = new HabitacionRepository();
    private final PromocionRepository promocionRepository = new PromocionRepository();

    @FXML
    public void initialize() {
        cargarHabitaciones();
        cargarPromociones();
    }

    private void cargarHabitaciones() {
        for (Habitacion h : habitacionRepository.obtenerTodas()) {
            VBox card = new VBox();
            card.getStyleClass().add("habitacion-card");
            card.setAlignment(Pos.TOP_LEFT);

            // Imagen de la habitacion
            StackPane imgContainer = new StackPane();
            imgContainer.getStyleClass().add("habitacion-imagen");

            ImageView imgView = new ImageView();
            imgView.setFitWidth(350);
            imgView.setFitHeight(300);
            imgView.setPreserveRatio(false);
            imgView.setSmooth(true);

            String rutaImagen = h.getImagenUrl();
            try {
                Image img = new Image(getClass().getResourceAsStream(rutaImagen));
                imgView.setImage(img);
            } catch (Exception e) {
                Label fallback = new Label("\uD83C\uDFE8");
                fallback.setStyle("-fx-font-size: 80px;");
                imgContainer.getChildren().add(fallback);
            }

            imgContainer.getChildren().add(imgView);

            // Info de la habitacion
            VBox infoBox = new VBox();
            infoBox.getStyleClass().add("habitacion-info");

            Label nombre = new Label(h.getNombre());
            nombre.getStyleClass().add("habitacion-nombre");

            Label precio = new Label("S/" + String.format("%.2f", h.getPrecioPorNoche()) + " por noche");
            precio.getStyleClass().add("habitacion-precio");

            infoBox.getChildren().addAll(nombre, precio);

            // Boton de reservar
            Button btnReservar = new Button("RESERVA\nAHORA");
            btnReservar.getStyleClass().add("btn-reservar");
            btnReservar.setOnAction(e -> onReservar(h));

            // Contenedor del boton alineado a la derecha
            HBox btnContainer = new HBox();
            btnContainer.setAlignment(Pos.CENTER_RIGHT);
            btnContainer.setPadding(new Insets(5, 20, 10, 0));
            btnContainer.getChildren().add(btnReservar);

            card.getChildren().addAll(imgContainer, infoBox, btnContainer);
            habitacionesContainer.getChildren().add(card);
        }
    }

    private void cargarPromociones() {
        for (Promocion p : promocionRepository.obtenerTodas()) {
            VBox item = new VBox();
            item.getStyleClass().add("promo-item");

            Label titulo = new Label(p.getTitulo());
            titulo.getStyleClass().add("promo-item-titulo");

            Label desc = new Label(p.getDescripcion());
            desc.getStyleClass().add("promo-item-descuento");

            item.getChildren().addAll(titulo, desc);
            promocionesContainer.getChildren().add(item);
        }
    }

    private void onReservar(Habitacion habitacion) {
        System.out.println("Reservando: " + habitacion.getNombre() + " - S/" + habitacion.getPrecioPorNoche());
    }
}
