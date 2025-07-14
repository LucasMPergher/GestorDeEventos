package com.mycompany.bdppeventos.model.entities;

import java.time.LocalDate;

import com.mycompany.bdppeventos.model.enums.EstadoEvento;
import com.mycompany.bdppeventos.model.enums.TipoEvento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exposiciones")
public class Exposicion extends Evento {

    // Atributos
    @Column(name = "tipo_arte", nullable = false)
    private TipoDeArte tipoArte;

    // Relaciones uno a uno con persona
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    // Constructores
    public Exposicion() {
        super();
    }

    public Exposicion(String nombre, LocalDate fechaInicio, int duracionEstimada, EstadoEvento estado,
            TipoEvento tipoEvento, boolean requiereInscripcion, int cupoMaximo, boolean esAbierto,
            TipoDeArte tipoArte) {
        super(nombre, fechaInicio, duracionEstimada, estado, tipoEvento, requiereInscripcion, cupoMaximo, esAbierto);
        this.tipoArte = tipoArte;
    }

    // getters y Setters
    // TODO: Falta validaciones

    public TipoDeArte getTipoArte() {
        return tipoArte;
    }

    public void setTipoArte(TipoDeArte tipoArte) {
        this.tipoArte = tipoArte;
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
