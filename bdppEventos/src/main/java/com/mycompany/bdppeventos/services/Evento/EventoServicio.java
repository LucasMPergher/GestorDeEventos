package com.mycompany.bdppeventos.services.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mycompany.bdppeventos.model.entities.Evento;
import com.mycompany.bdppeventos.model.entities.Feria;
import com.mycompany.bdppeventos.model.enums.EstadoEvento;
import com.mycompany.bdppeventos.repository.Repositorio;
import com.mycompany.bdppeventos.services.CrudServicio;

public class EventoServicio extends CrudServicio<Evento> {

    public EventoServicio(Repositorio repositorio) {
        super(repositorio, Evento.class);

    }

    @Override
    public Evento validarEInsertar(Object... datos) {
        if (datos.length != 10) {
            throw new IllegalArgumentException("Número incorrecto de parámetros.");
        }

        String nombre = (String) datos[0];
        LocalDate fechaInicio = (LocalDate) datos[1];
        int duracionEstimada = (int) datos[2];
        boolean tieneCupo = (boolean) datos[3];
        EstadoEvento estado = (EstadoEvento) datos[7];
        String tipoEvento = (String) datos[4];
        boolean requiereInscripcion = (boolean) datos[5];
        int cupoMaximo = (int) datos[6];
        boolean esAbierto = (boolean) datos[8];

        int cantidadStands = (int) datos[9];
        boolean esAireLibre = (boolean) datos[10];

        List<String> errores = new ArrayList<>();

        Evento evento = null;

        try {
            // Crear el tipo específico de evento según tipoEvento
            switch (tipoEvento.toLowerCase()) {
                case "feria":
                    evento = new Feria(nombre, fechaInicio, duracionEstimada, tieneCupo,
                            estado, requiereInscripcion, cupoMaximo, esAbierto, cantidadStands,
                            esAireLibre);
                    break;
                // case "tipo2":
                // evento = new Tipo2Evento(nombre, fechaInicio, duracionEstimada, tieneCupo,
                // estado,
                // requiereInscripcion, cupoMaximo, esAbierto);
                // break;
                default:
                    throw new IllegalArgumentException("Tipo de evento desconocido: " + tipoEvento);
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        if (!errores.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errores));
        }

        insertar(evento);
        return evento;
    }

    @Override
    public void validarYModificar(Evento evento, Object... datos) {
        if (datos.length != 9) {
            throw new IllegalArgumentException("Número incorrecto de parámetros.");
        }

        String nombre = (String) datos[0];
        LocalDate fechaInicio = (LocalDate) datos[1];
        int duracionEstimada = (int) datos[2];
        boolean tieneCupo = (boolean) datos[3];
        EstadoEvento estado = (EstadoEvento) datos[7];
        String tipoEvento = (String) datos[4];
        boolean requiereInscripcion = (boolean) datos[5];
        int cupoMaximo = (int) datos[6];
        boolean esAbierto = (boolean) datos[8];

        List<String> errores = new ArrayList<>();

        try {
            evento.setNombre(nombre);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            evento.setFechaInicio(fechaInicio);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            evento.setDuracionEstimada(duracionEstimada);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        // try {
        // evento.setTieneCupo(tieneCupo);
        // } catch (IllegalArgumentException e) {
        // errores.add(e.getMessage());
        // }

        // try {
        // evento.setCapacidadMaxima(capacidadMaxima);
        // } catch (IllegalArgumentException e) {
        // errores.add(e.getMessage());
        // }

        // try {
        // evento.setTieneInscripcion(tieneInscripcion);
        // } catch (IllegalArgumentException e) {
        // errores.add(e.getMessage());
        // }

        // try {
        // evento.setUbicacion(ubicacion);
        // } catch (IllegalArgumentException e) {
        // errores.add(e.getMessage());
        // }

        try {
            evento.setEstado(estado);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        // try {
        // evento.setEsPago(esPago);
        // } catch (IllegalArgumentException e) {
        // errores.add(e.getMessage());
        // }

        // try {
        // evento.setMonto(monto);
        // } catch (IllegalArgumentException e) {
        // errores.add(e.getMessage());
        // }

        if (!errores.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errores));
        }

        modificar(evento);
    }

    @Override
    public void validarYBorrar(Evento evento) {
        // Implementa aquí la lógica de validación antes de borrar un evento, si es
        // necesario
        borrar(evento);
    }

    @Override
    protected boolean esInactivo(Evento entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esInactivo'");
    }

    @Override
    protected void marcarComoInactivo(Evento entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'marcarComoInactivo'");
    }

    // @Override
    // protected boolean esInactivo(Evento evento) {
    // // Suponiendo que Evento tiene un método isInactivo o similar
    // return evento.isInactivo();
    // }

    // @Override
    // protected void marcarComoInactivo(Evento evento) {
    // // Suponiendo que Evento tiene un método setInactivo o similar
    // evento.setInactivo();
    // }

    // public String verificarCopias(Libro libro) {
    // List<CopiaLibro> copias = new ArrayList<>(libro.getCopias());

    // if (copias.isEmpty()) {
    // throw new IllegalArgumentException("El libro seleccionado no tiene ninguna
    // copia disponible.");
    // } else {
    // String respuesta = "El libro: " + libro + " tiene las siguientes copias
    // disponibles: \n";
    // for (CopiaLibro copia : copias) {
    // respuesta += "Tipo: " + copia.getTipo() + " | Precio: " + copia.getPrecio() +
    // "\n";
    // }
    // return respuesta;
    // }
    // }

    // public void agregarQuitarCopia(Libro libroNuevo, CopiaLibro copia) {
    // try {
    // Libro libroViejo = copia.getLibro();
    // libroNuevo.agregarCopia(copia);
    // modificar(libroNuevo);
    // if (!libroNuevo.equals(libroViejo)) {
    // libroViejo.quitarCopia(copia);
    // modificar(libroViejo);
    // }
    // } catch (IllegalArgumentException e) {
    // throw e;
    // }
    // }

    // public void agregarAutor(Libro libro, Autor autor) {
    // try {
    // libro.agregarAutor(autor);
    // modificar(libro);
    // } catch (IllegalArgumentException e) {
    // throw e;
    // }
    // }

    // private void agregarLibroAEntidades(Libro libro, Set<Autor> autoresNuevos,
    // Categoria categoria,
    // Editorial editorial,
    // Idioma idioma) {
    // Set<Autor> autoresViejos = libro.getAutores();
    // for (Autor autor : autoresNuevos) {
    // servicioAutor.agregarLibro(autor, libro);
    // }
    // if (!autoresNuevos.equals(autoresViejos)) {
    // for (Autor autor : autoresViejos) {
    // if (!autoresNuevos.contains(autor)) {
    // servicioAutor.quitarLibro(autor, libro);
    // }
    // }
    // }
    // servicioCategoria.agregarQuitarLibro(categoria, libro);
    // servicioEditorial.agregarQuitarLibro(editorial, libro);
    // servicioIdioma.agregarQuitarLibro(idioma, libro);
    // }
}