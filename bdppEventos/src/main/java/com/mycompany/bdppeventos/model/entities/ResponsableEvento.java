package com.mycompany.bdppeventos.model.entities;

import com.mycompany.bdppeventos.model.interfaces.Activable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "responsables_evento")
// La clase ResponsableEvento representa a un responsable de un evento
// específico
// que puede ser una persona o una entidad organizadora.
// Esta clase implementa la interfaz Activable para manejar el estado
// activo/inactivo.
// No tiene atributos adicionales por el momento, pero puede ser extendida en el
// futuro.
// Se asume que la relación con Evento se maneja a través de la entidad Evento.
public class ResponsableEvento implements Activable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rol", length = 50, nullable = false)
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        if (rol == null || rol.trim().isEmpty()) {
            throw new IllegalArgumentException("Rol no puede estar vacío");
        }
        if (rol.trim().length() > 50) {
            throw new IllegalArgumentException("Rol no puede exceder 50 caracteres");
        }
        this.rol = rol.trim();
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
