package com.mycompany.bdppeventos.model.entities;

import java.time.LocalDate;
import java.util.List;

import com.mycompany.bdppeventos.model.enums.EstadoEvento;
import com.mycompany.bdppeventos.model.enums.TipoEvento;
import com.mycompany.bdppeventos.model.interfaces.Activable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
public abstract class Evento implements Activable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 35, nullable = false)
    private String nombre;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "duracion_estimada", nullable = false)
    private int duracionEstimada;

    @Column(name = "estado", nullable = false)
    private EstadoEvento estado;

    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(name = "requiere_inscripcion", nullable = false)
    private boolean requiereInscripcion;

    @Column(name = "cupo_maximo", nullable = false)
    private int cupoMaximo;

    @Column(name = "es_abierto", nullable = false)
    private boolean esAbierto;

    // Relacion uno muchos evento con inscripcion
    @OneToMany(mappedBy = "evento")
    private List<Inscripcion> unaListaInscripcion;

    // Relacion uno muchos evento con responsable
    @OneToMany(mappedBy = "evento")
    private List<ResponsableEvento> unaListaResponsables;

    // Constructores

    public Evento() {
    }

    public Evento(String nombre, LocalDate fechaInicio, int duracionEstimada, EstadoEvento estado,
            TipoEvento tipoEvento, boolean requiereInscripcion, int cupoMaximo, boolean esAbierto) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.duracionEstimada = duracionEstimada;
        this.estado = estado;
        this.tipoEvento = tipoEvento;
        this.requiereInscripcion = requiereInscripcion;
        this.cupoMaximo = cupoMaximo;
        this.esAbierto = esAbierto;
    }

    // Getters Y setters

    // TODO: Falta validaciones IMPORTANTE
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public boolean isRequiereInscripcion() {
        return requiereInscripcion;
    }

    public void setRequiereInscripcion(boolean requiereInscripcion) {
        this.requiereInscripcion = requiereInscripcion;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public boolean isEsAbierto() {
        return esAbierto;
    }

    public void setEsAbierto(boolean esAbierto) {
        this.esAbierto = esAbierto;
    }

    // Metodos interfaz Activable

}
