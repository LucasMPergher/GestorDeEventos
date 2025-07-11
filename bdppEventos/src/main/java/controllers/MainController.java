package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class MainController {
    @FXML
    private StackPane contentArea;

    @FXML
    private void mostrarDashboard() throws IOException {
        loadView("/views/main.fxml");
    }

    @FXML
    private void mostrarEventos() throws IOException {
        loadView("/views/evento.fxml"); // Usa evento.fxml si listaEventos.fxml no existe
    }

    @FXML
    private void mostrarFeria() throws IOException {
        loadView("/views/feria.fxml");
    }

    @FXML
    private void mostrarExposicion() throws IOException {
        loadView("/views/exposicion.fxml");
    }

    @FXML
    private void mostrarTaller() throws IOException {
        loadView("/views/taller.fxml");
    }

    @FXML
    private void mostrarCicloCine() throws IOException {
        loadView("/views/cicloCine.fxml");
    }

    @FXML
    private void mostrarConcierto() throws IOException {
        loadView("/views/concierto.fxml");
    }

    @FXML
    private void mostrarPersonas() throws IOException {
        loadView("/views/persona.fxml");
    }

    @FXML
    private void mostrarInscripciones() throws IOException {
        loadView("/views/inscripcion.fxml");
    }

    @FXML
    private void mostrarArtistas() throws IOException {
        loadView("/views/artistas.fxml");
    }

    @FXML
    private void mostrarCalendario() throws IOException {
        loadView("/views/calendario.fxml");
    }

    @FXML
    private void mostrarReporteAsistencia() throws IOException {
        loadView("/views/reportes/asistencia.fxml");
    }

    @FXML
    private void mostrarReporteIngresos() throws IOException {
        loadView("/views/reportes/ingresos.fxml");
    }

    @FXML
    private void mostrarAjustes() throws IOException {
        loadView("/views/configuracion/ajustes.fxml");
    }

    @FXML
    private void mostrarUsuarios() throws IOException {
        loadView("/views/configuracion/usuarios.fxml");
    }

    private void loadView(String fxmlPath) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);
        } catch (IOException e) {
            showError("Error al cargar la vista: " + fxmlPath);
            e.printStackTrace();
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}