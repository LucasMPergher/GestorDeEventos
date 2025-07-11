package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class PanelEventosController {
    @FXML private TabPane tabPane;

    // Eventos
    @FXML private TextField buscarEventoField;
    @FXML private ComboBox<String> tipoEventoFiltro;
    @FXML private ComboBox<String> estadoEventoFiltro;
    @FXML private TableView<?> tablaEventos;

    // Personas
    @FXML private TextField dniField;
    @FXML private TextField nombreField;
    @FXML private TextField telefonoField;
    @FXML private TextField correoField;
    @FXML private ComboBox<String> tipoCombo;
    @FXML private TableView<?> tablaPersonas;

    // Inscripciones
    @FXML private DatePicker fechaInscripcionPicker;
    @FXML private CheckBox asistioCheck;
    @FXML private TableView<?> tablaInscripciones;

    // Ferias
    @FXML private TextField cantidadStandsField;
    @FXML private CheckBox esAireLibreCheck;
    @FXML private TableView<?> tablaFerias;

    // Talleres, Exposiciones, Ciclo de Cine, Conciertos, Reporte de Ingresos
    @FXML private TableView<?> tablaTalleres;
    @FXML private TableView<?> tablaExposiciones;
    @FXML private TableView<?> tablaCicloCine;
    @FXML private TableView<?> tablaConciertos;
    @FXML private TableView<?> tablaIngresos;

    @FXML
    private void initialize() {
        // Inicializar combos
        if (tipoEventoFiltro != null)
            tipoEventoFiltro.getItems().addAll("Todos", "Feria", "Exposición", "Taller", "Ciclo de Cine", "Concierto");
        if (estadoEventoFiltro != null)
            estadoEventoFiltro.getItems().addAll("Todos", "Planificado", "En curso", "Finalizado", "Cancelado");
        if (tipoCombo != null)
            tipoCombo.getItems().addAll("PARTICIPANTE", "ORGANIZADOR", "EXPOSITOR", "ARTISTA");
    }

    // Métodos de acción para botones
    @FXML
    private void nuevoEvento() {
        // Lógica para crear nuevo evento
        System.out.println("Nuevo evento");
    }

    @FXML
    private void guardarPersona() {
        System.out.println("Guardar persona");
    }

    @FXML
    private void cancelarPersona() {
        dniField.clear();
        nombreField.clear();
        telefonoField.clear();
        correoField.clear();
        tipoCombo.getSelectionModel().clearSelection();
    }

    @FXML
    private void guardarInscripcion() {
        System.out.println("Guardar inscripción");
    }

    @FXML
    private void cancelarInscripcion() {
        fechaInscripcionPicker.setValue(null);
        asistioCheck.setSelected(false);
    }

    @FXML
    private void guardarFeria() {
        System.out.println("Guardar feria");
    }

    @FXML
    private void cancelarFeria() {
        cantidadStandsField.clear();
        esAireLibreCheck.setSelected(false);
    }

    @FXML private void tabEventos() { tabPane.getSelectionModel().select(0); }
    @FXML private void tabPersonas() { tabPane.getSelectionModel().select(1); }
    @FXML private void tabInscripciones() { tabPane.getSelectionModel().select(2); }
    @FXML private void tabFerias() { tabPane.getSelectionModel().select(3); }
    @FXML private void tabTalleres() { tabPane.getSelectionModel().select(4); }
    @FXML private void tabExposiciones() { tabPane.getSelectionModel().select(5); }
    @FXML private void tabCicloCine() { tabPane.getSelectionModel().select(6); }
    @FXML private void tabConciertos() { tabPane.getSelectionModel().select(7); }
    @FXML private void tabIngresos() { tabPane.getSelectionModel().select(8); }
}
