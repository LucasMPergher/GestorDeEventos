package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

public class FeriaController {
    @FXML private TextField cantidadStandsField;
    @FXML private CheckBox esAireLibreCheck;

    @FXML
    private void guardarFeria() {
        // Lógica para guardar la feria
        System.out.println("Guardando feria...");
    }

    @FXML
    private void cancelar() {
        cantidadStandsField.clear();
        esAireLibreCheck.setSelected(false);
    }
}