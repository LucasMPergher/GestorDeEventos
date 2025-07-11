package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class EventoController {
    // Campos básicos
    @FXML private TextField nombreField;
    @FXML private ComboBox<String> tipoEventoCombo;
    @FXML private DatePicker fechaInicioPicker;
    @FXML private TextField duracionField;
    @FXML private ComboBox<String> duracionUnidadCombo;
    @FXML private ComboBox<String> estadoCombo;
    @FXML private CheckBox requiereInscripcionCheck;
    @FXML private TextField cupoMaximoField;
    @FXML private CheckBox esAbiertoCheck;
    @FXML private TextField ubicacionField;
    @FXML private TextArea descripcionArea;
    
    // Contenedor para detalles específicos
    @FXML private VBox tipoEspecificoContainer;
    
    @FXML
    private void initialize() {
        // Inicializar comboboxes
        tipoEventoCombo.getItems().addAll(
            "FERIA", "EXPOSICION", "TALLER", "CICLO_CINE", "CONCIERTO"
        );
        
        duracionUnidadCombo.getItems().addAll("horas", "días", "semanas", "meses");
        duracionUnidadCombo.getSelectionModel().select(1); // días por defecto
        
        estadoCombo.getItems().addAll(
            "PLANIFICADO", "EN_CURSO", "FINALIZADO", "CANCELADO"
        );
        estadoCombo.getSelectionModel().select(0); // PLANIFICADO por defecto
        
        // Escuchar cambios en el tipo de evento
        tipoEventoCombo.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> cargarDetallesEspecificos(newVal)
        );
        
        // Habilitar/deshabilitar cupo máximo según requiere inscripción
        requiereInscripcionCheck.selectedProperty().addListener(
            (obs, oldVal, newVal) -> cupoMaximoField.setDisable(!newVal)
        );
    }
    
    private void cargarDetallesEspecificos(String tipoEvento) {
        tipoEspecificoContainer.getChildren().clear();
        
        if (tipoEvento == null) return;
        
        try {
            String fxmlPath = "";
            switch (tipoEvento) {
                case "FERIA":
                    fxmlPath = "/views/evento/componentes/feriaDetalles.fxml";
                    break;
                case "EXPOSICION":
                    fxmlPath = "/views/evento/componentes/exposicionDetalles.fxml";
                    break;
                case "TALLER":
                    fxmlPath = "/views/evento/componentes/tallerDetalles.fxml";
                    break;
                case "CICLO_CINE":
                    fxmlPath = "/views/evento/componentes/cicloCineDetalles.fxml";
                    break;
                case "CONCIERTO":
                    fxmlPath = "/views/evento/componentes/conciertoDetalles.fxml";
                    break;
            }
            
            if (!fxmlPath.isEmpty()) {
                Parent detalles = FXMLLoader.load(getClass().getResource(fxmlPath));
                tipoEspecificoContainer.getChildren().add(detalles);
            }
        } catch (IOException e) {
            e.printStackTrace();
            tipoEspecificoContainer.getChildren().add(
                new Label("Error al cargar detalles específicos")
            );
        }
    }
    
    @FXML
    private void guardarEvento(ActionEvent event) {
        // Validación de datos
        if (nombreField.getText().isEmpty()) {
            mostrarError("El nombre del evento es requerido");
            return;
        }
        
        if (fechaInicioPicker.getValue() == null) {
            mostrarError("La fecha de inicio es requerida");
            return;
        }
        
        // Lógica para guardar el evento
        System.out.println("Guardando evento...");
        
        // Mostrar confirmación
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Evento guardado");
        alert.setHeaderText(null);
        alert.setContentText("El evento se ha guardado correctamente");
        alert.showAndWait();
    }
    
    @FXML
    private void guardarYNuevo(ActionEvent event) {
        guardarEvento(event);
        limpiarFormulario();
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
        limpiarFormulario();
    }
    
    private void limpiarFormulario() {
        nombreField.clear();
        tipoEventoCombo.getSelectionModel().clearSelection();
        fechaInicioPicker.setValue(null);
        duracionField.clear();
        duracionUnidadCombo.getSelectionModel().select(1);
        estadoCombo.getSelectionModel().select(0);
        requiereInscripcionCheck.setSelected(false);
        cupoMaximoField.clear();
        esAbiertoCheck.setSelected(false);
        ubicacionField.clear();
        descripcionArea.clear();
        tipoEspecificoContainer.getChildren().clear();
    }
    
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}