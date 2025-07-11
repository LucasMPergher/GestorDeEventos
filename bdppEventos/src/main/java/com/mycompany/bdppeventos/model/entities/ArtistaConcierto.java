package com.mycompany.bdppeventos.model.entities;

import com.mycompany.bdppeventos.model.interfaces.Activable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artistas_concierto")
// La clase ArtistaConcierto representa a un artista que participa en un
// concierto.
public class ArtistaConcierto implements Activable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "orden_actuacion", nullable = false)
    private Integer ordenActuacion;

    // constructor
    public ArtistaConcierto() {
    }

    // Constructor con parámetros
    public ArtistaConcierto(Long id, Integer ordenActuacion) {
        this.id = id;
        this.ordenActuacion = ordenActuacion;
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
