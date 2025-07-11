package com.mycompany.bdppeventos.model.entities;

import com.mycompany.bdppeventos.model.enums.TipoCobertura;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ferias")
public class Feria extends Evento {

    // Atributos
    @Column(name = "cantidad_stand", nullable = false)
    private int cantidadStands;

    @Column(name = "es_aire_libre", nullable = false)
    private boolean esAireLibre;

    // Constructores

    public Feria() {
        super(); // Me comunico con el Contructor sin parametros de la clase padre para poder
                 // crear la instancia
    }

    public Feria(int cantidadStands, boolean esAireLibre) {
        super(); // Me comunico con el Contructor sin parametros de la clase padre para poder
                 // crear la instancia
        this.cantidadStands = cantidadStands;
        this.esAireLibre = esAireLibre;
    }

    // Getters y Setters

    // TODO: Falta validaciones

    public int getCantidadStands() {
        return cantidadStands;
    }

    public void setCantidadStands(int cantidadStands) {
        this.cantidadStands = cantidadStands;
    }

    public boolean isEsAireLibre() {
        return esAireLibre;
    }

    public void setEsAireLibre(boolean esAireLibre) {
        this.esAireLibre = esAireLibre;
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
