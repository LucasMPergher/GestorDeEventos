package com.mycompany.bdppeventos.model.entities;

import com.mycompany.bdppeventos.model.enums.EstadoEvento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Entidad que representa un Ciclo de Cine como especialización de Evento
 * Un ciclo de cine es un evento que agrupa múltiples proyecciones de películas
 */
@Entity
@Table(name = "ciclos_cine")

public class CicloDeCine extends Evento {

    @Column(name = "charlas_posteriores", nullable = false)
    private boolean charlasPosteriores;

    // Relación uno a muchos con PeliculaCiclo
    @OneToMany(mappedBy = "cicloDeCine")
    private List<PeliculaCiclo> peliculas;

    // Constructor por defecto
    public CicloDeCine() {
        super();
    }

    // Constructor completo para crear ciclos de cine existentes

    public CicloDeCine(boolean charlasPosteriores) {
        this.charlasPosteriores = charlasPosteriores;

    }

    public CicloDeCine(String nombre, LocalDate fechaInicio, int duracionEstimada, EstadoEvento estado,
            boolean requiereInscripcion, int cupoMaximo, boolean esAbierto, boolean charlasPosteriores) {
        super(nombre, fechaInicio, duracionEstimada, estado, null, requiereInscripcion, cupoMaximo, esAbierto);
        this.charlasPosteriores = charlasPosteriores;
    }

    // Constructor simplificado para crear ciclos de cine nuevos

    // Getters y Setters
    public boolean isCharlasPosteriores() {
        return charlasPosteriores;
    }

    public void setCharlasPosteriores(boolean charlasPosteriores) {
        this.charlasPosteriores = charlasPosteriores;
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
