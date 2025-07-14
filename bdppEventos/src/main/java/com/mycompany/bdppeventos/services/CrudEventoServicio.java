package com.mycompany.bdppeventos.services;

import java.time.LocalDate;
import java.util.Map;

import com.mycompany.bdppeventos.model.entities.CicloDeCine;
import com.mycompany.bdppeventos.model.entities.Concierto;
import com.mycompany.bdppeventos.model.entities.Evento;
import com.mycompany.bdppeventos.model.entities.Exposicion;
import com.mycompany.bdppeventos.model.entities.Feria;
import com.mycompany.bdppeventos.model.entities.Taller;
import com.mycompany.bdppeventos.model.entities.TipoDeArte;
import com.mycompany.bdppeventos.model.enums.EstadoEvento;
import com.mycompany.bdppeventos.model.enums.TipoEntrada;
import com.mycompany.bdppeventos.model.enums.TipoEvento;
import com.mycompany.bdppeventos.model.enums.TipoModalidad;

public class CrudEventoServicio {
    /**
     * Crea un evento según el tipo especificado
     * 
     * @param tipoEvento Tipo de evento a crear
     * @param datos      Mapa con los datos necesarios para crear el evento
     * @return Evento creado
     */

    public Evento crearEvento(TipoEvento tipoEvento, Map<String, Object> datos) {
        switch (tipoEvento) {
            case FERIA:
                return crearFeria(datos);
            case TALLER:
                return crearTaller(datos);
            case CONCIERTO:
                return crearConcierto(datos);
            case EXPOSICION:
                return crearExposicion(datos);
            case CICLOCINE:
                return crearCicloDeCine(datos);
            default:
                throw new IllegalArgumentException("Tipo de evento desconocido: " + tipoEvento);
        }
    }

    /**
     * Crea una Feria con los datos proporcionados
     */
    private Feria crearFeria(Map<String, Object> datos) {
        return new Feria(
                (String) datos.get("nombre"),
                (LocalDate) datos.get("fechaInicio"),
                (Integer) datos.get("duracionEstimada"),
                (EstadoEvento) datos.get("estado"),
                (Boolean) datos.get("requiereInscripcion"),
                (Integer) datos.get("cupoMaximo"),
                (Boolean) datos.get("esAbierto"),
                (Integer) datos.get("cantidadStands"),
                (Boolean) datos.get("esAireLibre"));
    }

    /**
     * Crea un Taller con los datos proporcionados
     */
    private Taller crearTaller(Map<String, Object> datos) {
        return new Taller(
                (String) datos.get("nombre"),
                (LocalDate) datos.get("fechaInicio"),
                (Integer) datos.get("duracionEstimada"),
                (EstadoEvento) datos.get("estado"),
                (Boolean) datos.get("requiereInscripcion"),
                (Integer) datos.get("cupoMaximo"),
                (Boolean) datos.get("esAbierto"),
                (TipoModalidad) datos.get("modalidad"));
    }

    /**
     * Crea un Concierto con los datos proporcionados
     */
    private Concierto crearConcierto(Map<String, Object> datos) {
        return new Concierto(
                (String) datos.get("nombre"),
                (LocalDate) datos.get("fechaInicio"),
                (Integer) datos.get("duracionEstimada"),
                (EstadoEvento) datos.get("estado"),
                (Boolean) datos.get("requiereInscripcion"),
                (Integer) datos.get("cupoMaximo"),
                (Boolean) datos.get("esAbierto"),
                (Integer) datos.get("cantidadStands"),
                (Boolean) datos.get("esAireLibre"),
                (TipoEntrada) datos.get("tipoEntrada"));
    }

    /**
     * Crea una Exposición con los datos proporcionados
     */
    private Exposicion crearExposicion(Map<String, Object> datos) {
        return new Exposicion(
                (String) datos.get("nombre"),
                (LocalDate) datos.get("fechaInicio"),
                (Integer) datos.get("duracionEstimada"),
                (EstadoEvento) datos.get("estado"),
                (TipoEvento) datos.get("tipoEvento"),
                (Boolean) datos.get("requiereInscripcion"),
                (Integer) datos.get("cupoMaximo"),
                (Boolean) datos.get("esAbierto"),
                (TipoDeArte) datos.get("tipoArte"));
    }

    /**
     * Crea un Ciclo de Cine con los datos proporcionados
     */
    private CicloDeCine crearCicloDeCine(Map<String, Object> datos) {
        return new CicloDeCine(
                (String) datos.get("nombre"),
                (LocalDate) datos.get("fechaInicio"),
                (Integer) datos.get("duracionEstimada"),
                (EstadoEvento) datos.get("estado"),
                (Boolean) datos.get("requiereInscripcion"),
                (Integer) datos.get("cupoMaximo"),
                (Boolean) datos.get("esAbierto"),
                (Boolean) datos.get("charlasPosteriores"));
    }
}
