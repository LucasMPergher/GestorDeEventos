package com.mycompany.bdppeventos.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Entidad que representa una Película
 * Una película puede tener múltiples proyecciones
 */
@Entity
@Table(name = "pelicula_ciclo")
public class PeliculaCiclo {

    @Id
    @Column(name = "id_pelicula", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPelicula;

    @Column(name = "titulo_pelicula", length = 100, nullable = false)
    private String titulo;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @Column(name = "orden_proyeccion", nullable = false)
    private int ordenProyeccion;

    @Column(name = "duracion_minutos", nullable = false)
    private int duracionMinutos;

    @Column(name = "director", length = 500, nullable = true)
    private String director;

    // Relación uno a muchos con CicloCine
    // @ManyToOne
    // @JoinColumn(name = "id_ciclo_cine", nullable = false)
    // private CicloCine idCicloCine;

    public PeliculaCiclo() {
        this.activo = true; // Por defecto activo
    }

    // Constructor para crear una película nueva sin proyecciones
    public PeliculaCiclo(int idPelicula, String titulo, boolean activo) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.activo = activo;
    }

    // Getters y Setters

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
