package com.mycompany.bdppeventos.model.entities;

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

    @Column(name = "cupo_maximo", nullable = false)
    private int cupoMaximo;

    @Enumerated(EnumType.STRING) // EnumType.STRING para guardar el nombre del enum en la base de datos
    private TipoModalidad modalidad;

    // Constructores

    public Taller() {
        super();
    }

    public Taller(int cupoMaximo, TipoModalidad modalidad) {
        this.cupoMaximo = cupoMaximo;
        this.modalidad = modalidad;
    }

    // Relacion 1 a 1 con Persona
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    // Getters y Setters

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

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
