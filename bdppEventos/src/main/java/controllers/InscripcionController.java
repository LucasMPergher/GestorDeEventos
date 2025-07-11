package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;

public class InscripcionController {
    @FXML private DatePicker fechaInscripcionPicker;
    @FXML private CheckBox asistioCheck;

    @FXML
    private void guardarInscripcion() {
        // Lógica para guardar inscripción
        System.out.println("Guardando inscripción...");
    }

    @FXML
    private void cancelar() {
        fechaInscripcionPicker.setValue(null);
        asistioCheck.setSelected(false);
    }
}