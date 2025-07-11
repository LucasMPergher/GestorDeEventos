package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PersonaController {
    @FXML private TextField dniField;
    @FXML private TextField nombreField;
    @FXML private TextField telefonoField;
    @FXML private TextField correoField;
    @FXML private ComboBox<String> tipoCombo;

    @FXML
    private void initialize() {
        tipoCombo.getItems().addAll("PARTICIPANTE", "ORGANIZADOR", "EXPOSITOR", "ARTISTA");
    }

    @FXML
    private void guardarPersona() {
        // Lógica para guardar persona
        System.out.println("Guardando persona...");
    }

    @FXML
    private void cancelar() {
        dniField.clear();
        nombreField.clear();
        telefonoField.clear();
        correoField.clear();
        tipoCombo.getSelectionModel().clearSelection();
    }
}
