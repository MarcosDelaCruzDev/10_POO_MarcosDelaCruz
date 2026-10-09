package vallegrande.edu.pe.proyecto.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vallegrande.edu.pe.proyecto.model.Contacto;

import java.util.List;

public class MainView extends BorderPane {

    private Button btnInicio;
    private Button btnContactos;

    // CRUD de contactos
    private TextField txtNombre;
    private TextField txtApellido;
    private TextField txtTelefono;
    private TextField txtCorreo;
    private TextField txtMensaje;
    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;
    private TableView<Contacto> tablaContactos;

    public MainView() {
        crearMenu();
        crearFormulario();
        crearTabla();
        mostrarInicio();
    }

    private void crearMenu() {
        VBox menu = new VBox(15);
        menu.setPadding(new Insets(25));
        menu.setPrefWidth(220);

        Label titulo = new Label("🖥️ MI SISTEMA");
        titulo.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        btnInicio = crearBoton("Inicio");
        btnContactos = crearBoton("Contactos");

        menu.getChildren().addAll(
                titulo,
                btnInicio,
                btnContactos
        );

        menu.setStyle("-fx-background-color: #2563EB;");
        setLeft(menu);
    }

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefWidth(170);
        boton.setPrefHeight(40);
        boton.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: #1E3A8A;" +
                        "-fx-font-size: 14px;" +
                        "-fx-background-radius: 8;"
        );
        return boton;
    }

    public void mostrarInicio() {
        VBox contenido = new VBox(10);
        contenido.setAlignment(Pos.CENTER);
        Label titulo = new Label("BIENVENIDO");
        titulo.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");
        Label texto = new Label("Panel principal de mi sistema");
        contenido.getChildren().addAll(titulo, texto);
        setCenter(contenido);
    }

    public void mostrarContactos() {
        VBox contenido = new VBox(15);
        contenido.setPadding(new Insets(30));
        Label titulo = new Label("CONTACTOS");
        titulo.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        HBox campos = new HBox(10, txtNombre, txtApellido, txtTelefono, txtCorreo, txtMensaje);
        HBox botones = new HBox(10, btnRegistrar, btnActualizar, btnEliminar);

        contenido.getChildren().addAll(titulo, campos, botones, tablaContactos);
        setCenter(contenido);
    }

    private void crearFormulario() {
        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");
        txtApellido = new TextField();
        txtApellido.setPromptText("Apellido");
        txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono");
        txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo");
        txtMensaje = new TextField();
        txtMensaje.setPromptText("Mensaje");

        btnRegistrar = crearBotonAccion("Registrar", "#2563EB");
        btnActualizar = crearBotonAccion("Actualizar", "#0D9488");
        btnEliminar = crearBotonAccion("Eliminar", "#EF4444");
    }

    private Button crearBotonAccion(String texto, String color) {
        Button boton = new Button(texto);
        boton.setPrefHeight(35);
        boton.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-background-radius: 8;"
        );
        return boton;
    }

    private void crearTabla() {
        tablaContactos = new TableView<>();

        TableColumn<Contacto, Integer> colId = new TableColumn<>("ID");
        TableColumn<Contacto, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Contacto, String> colApellido = new TableColumn<>("Apellido");
        TableColumn<Contacto, String> colTelefono = new TableColumn<>("Teléfono");
        TableColumn<Contacto, String> colCorreo = new TableColumn<>("Correo");
        TableColumn<Contacto, String> colMensaje = new TableColumn<>("Mensaje");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        tablaContactos.getColumns().addAll(colId, colNombre, colApellido, colTelefono, colCorreo, colMensaje);
        tablaContactos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void mostrarDatosContactos(List<Contacto> contactos) {
        tablaContactos.setItems(FXCollections.observableArrayList(contactos));
    }

    public Contacto getContactoSeleccionado() {
        return tablaContactos.getSelectionModel().getSelectedItem();
    }

    public void cargarContactoEnFormulario(Contacto contacto) {
        txtNombre.setText(contacto.getNombre());
        txtApellido.setText(contacto.getApellido());
        txtTelefono.setText(contacto.getTelefono());
        txtCorreo.setText(contacto.getCorreo());
        txtMensaje.setText(contacto.getMensaje());
    }

    public void limpiarFormulario() {
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtMensaje.clear();
        tablaContactos.getSelectionModel().clearSelection();
    }

    public boolean formularioValido() {
        return !getNombre().isBlank() && !getApellido().isBlank()
                && !getTelefono().isBlank() && !getCorreo().isBlank()
                && !getMensaje().isBlank();
    }

    public void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnContactos() { return btnContactos; }


    public String getNombre() { return txtNombre.getText().trim(); }
    public String getApellido() { return txtApellido.getText().trim(); }
    public String getTelefono() { return txtTelefono.getText().trim(); }
    public String getCorreo() { return txtCorreo.getText().trim(); }
    public String getMensaje() { return txtMensaje.getText().trim(); }

    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnActualizar() { return btnActualizar; }
    public Button getBtnEliminar() { return btnEliminar; }
    public TableView<Contacto> getTablaContactos() { return tablaContactos; }
}