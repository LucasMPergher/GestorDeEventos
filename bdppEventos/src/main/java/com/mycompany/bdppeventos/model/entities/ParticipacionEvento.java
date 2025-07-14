package com.mycompany.bdppeventos.model.entities;

import com.mycompany.bdppeventos.model.enums.RolPersonaEvento;
import com.mycompany.bdppeventos.model.interfaces.Activable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "participaciones_evento")
public class ParticipacionEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RolPersonaEvento rol;

    // Relaciones

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Persona persona;

    // Constructores
    public ParticipacionEvento() {
        this.rol = RolPersonaEvento.RESPONSABLE;
    }

    public ParticipacionEvento(RolPersonaEvento rol, Evento evento, Persona persona) {
        this.rol = rol;
        this.evento = evento;
        this.persona = persona;
    }

    // Getters y Setters

}
