package com.mycompany.bdppeventos.model.entities;

import com.mycompany.bdppeventos.model.enums.EstadoEvento;
import com.mycompany.bdppeventos.model.enums.TipoEntrada;
import com.mycompany.bdppeventos.model.enums.TipoEvento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * Entidad que representa un Concierto como especialización de Evento
 * Un concierto es un evento musical que puede tener entrada gratuita o paga
 */
@Entity
@Table(name = "conciertos")
public class Concierto extends Evento {

    @Enumerated(EnumType.STRING) // Se usa STRING para almacenar el nombre del enum en la base de datos
    @Column(name = "tipo_entrada", nullable = false, length = 20) // length debe ser suficiente para el nombre del enum
    private TipoEntrada tipoEntrada;

    // Constructores

    public Concierto() {
        super();
    }

    public Concierto(String nombre, LocalDate fechaInicio, int duracionEstimada,
            EstadoEvento estado, boolean requiereInscripcion, int cupoMaximo,
            boolean esAbierto, int cantidadStands, boolean esAireLibre, TipoEntrada tipoEntrada) {
        super(nombre, fechaInicio, duracionEstimada, estado, TipoEvento.CONCIERTO, requiereInscripcion, cupoMaximo,
                esAbierto);
        this.tipoEntrada = tipoEntrada;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        if (tipoEntrada == null) {
            throw new IllegalArgumentException("El tipo de entrada no puede ser nulo");
        }
        this.tipoEntrada = tipoEntrada;
    }

    // Implementación de métodos abstractos de Activable
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