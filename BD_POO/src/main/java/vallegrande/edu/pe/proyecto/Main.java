package vallegrande.edu.pe.proyecto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.proyecto.controller.MainController;
import vallegrande.edu.pe.proyecto.view.MainView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        MainView view = new MainView();
        new MainController(view);

        Scene scene = new Scene(view, 900, 600);
        stage.setTitle("AGROFRUTOS LAMBAYEQUE");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}