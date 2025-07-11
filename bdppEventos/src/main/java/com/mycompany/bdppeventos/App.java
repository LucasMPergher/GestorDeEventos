package com.mycompany.bdppeventos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/panelEventos.fxml"));
        Scene scene = new Scene(root, 1900, 1000);
        // Asegura que el CSS se carga desde el classpath
        java.net.URL cssUrl = getClass().getResource("/css/application.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.err.println("ERROR: No se encontró el archivo CSS en /css/application.css");
        }
        primaryStage.setTitle("Sistema de Gestión de Eventos Culturales");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}