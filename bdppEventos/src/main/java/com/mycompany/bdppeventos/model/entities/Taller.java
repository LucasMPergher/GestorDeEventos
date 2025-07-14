package com.mycompany.bdppeventos.model.entities;

import java.time.LocalDate;

import com.mycompany.bdppeventos.model.enums.EstadoEvento;
import com.mycompany.bdppeventos.model.enums.TipoEvento;
import com.mycompany.bdppeventos.model.enums.TipoModalidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "talleres")
public class Taller extends Evento {

    @Enumerated(EnumType.STRING) // EnumType.STRING para guardar el nombre del enum en la base de datos
    private TipoModalidad modalidad;

    // Constructores

    public Taller() {
        super();
    }

    public Taller(String nombre, LocalDate fechaInicio, int duracionEstimada,
            EstadoEvento estado, boolean requiereInscripcion, int cupoMaximo, boolean esAbierto,
            TipoModalidad modalidad) {
        super(nombre, fechaInicio, duracionEstimada, estado, TipoEvento.TALLER, requiereInscripcion, cupoMaximo,
                esAbierto);
        this.modalidad = modalidad;
    }

    // Relacion 1 a 1 con Persona
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    // Getters y Setters

    public TipoModalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(TipoModalidad modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public void activar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activar'");
    }

    @Override
    public void desactivar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactivar'");
    }

    @Override
    public Boolean getActivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivo'");
    }

    @Override
    public void setActivo(Boolean activo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActivo'");
    }

}
