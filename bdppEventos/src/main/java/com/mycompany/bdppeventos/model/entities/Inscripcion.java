package com.mycompany.bdppeventos.model.entities;

import java.time.LocalDate;

import com.mycompany.bdppeventos.model.interfaces.Activable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscripciones")
public class Inscripcion implements Activable {

    @Id
    @Column(name = "id_inscripcion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInscripcion;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    @Column(name = "asistio", nullable = false)
    private boolean asistio;

    // Relaciones

    // Relacion muchos a uno con Persona
    @ManyToOne
    @JoinColumn(name = "dni_persona")
    private Persona unaPersona;

    // Relacion muchos a uno con Evento
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento unEvento;

    // Relacion muchos a uno con TipoRol
    @ManyToOne
    @JoinColumn(name = "tipo_rol_id")
    private TipoRol unTipoRol;

    // Constructores
    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, Persona unaPersona, Evento unEvento, TipoRol unTipoRol) {
        this.idInscripcion = idInscripcion;
        this.unaPersona = unaPersona;
        this.unEvento = unEvento;
        this.unTipoRol = unTipoRol;
    }

    // Getters and Setters
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public Persona getUnaPersona() {
        return unaPersona;
    }

    public void setUnaPersona(Persona unaPersona) {
        if (unaPersona == null) {
            throw new IllegalArgumentException("La persona no puede ser nulo");
        }
        this.unaPersona = unaPersona;
    }

    public TipoRol getUnTipoRol() {
        return unTipoRol;
    }

    public void setUnTipoRol(TipoRol unTipoRol) {
        if (unTipoRol == null) {
            throw new IllegalArgumentException("Tipo de rol no puede ser nulo");
        }
        this.unTipoRol = unTipoRol;
    }

    // TODO: Falta validaciones
    public Evento getUnEvento() {
        return unEvento;
    }

    public void setUnEvento(Evento unEvento) {
        // Metodos Interfaz Activable

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
