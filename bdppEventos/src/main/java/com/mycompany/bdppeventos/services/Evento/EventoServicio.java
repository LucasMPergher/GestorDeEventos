package com.mycompany.bdppeventos.services.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.mycompany.bdppeventos.repository.Repositorio;
import com.mycompany.bdppeventos.services.CrudEventoServicio;
import com.mycompany.bdppeventos.services.CrudServicio;

public class EventoServicio extends CrudServicio<Evento> {

    private final CrudEventoServicio crudEventoServicio; // Servicio para manejar la creación y validación de eventos
    // final porque no queremos que se reasigne una nueva instancia de
    // CrudEventoServicio

    /**
     * Constructor de EventoServicio
     * 
     * @param repositorio Repositorio de eventos
     */

    public EventoServicio(Repositorio repositorio, CrudEventoServicio crudEventoServicio) {
        super(repositorio, Evento.class);
        this.crudEventoServicio = crudEventoServicio;
    }

    @Override
    public Evento validarEInsertar(Object... datos) {
        if (datos.length < 9 || datos.length > 14) {
            throw new IllegalArgumentException("Número incorrecto de parámetros.");
        }

        String nombre = (String) datos[0];
        LocalDate fechaInicio = (LocalDate) datos[1];
        int duracionEstimada = (int) datos[2];
        EstadoEvento estado = (EstadoEvento) datos[3];
        TipoEvento tipoEvento = (TipoEvento) datos[4];
        boolean requiereInscripcion = (boolean) datos[5];
        int cupoMaximo = (int) datos[6];
        boolean esAbierto = (boolean) datos[7];

        // Datos específicos para Feria
        int cantidadStands = (int) datos[8];
        boolean esAireLibre = (boolean) datos[9];

        // Datos específicos para Taller
        TipoModalidad modalidad = (TipoModalidad) datos[10];

        // Datos específicos para Concierto
        TipoEntrada tipoEntrada = (TipoEntrada) datos[11];

        // Datos específicos para Exposición
        TipoDeArte tipoArte = (TipoDeArte) datos[12];

        // Datos específicos para Ciclo de Cine
        boolean charlasPosteriores = (boolean) datos[13];

        // Listas para almacenar errores de validación
        List<String> errores = new ArrayList<>();

        Evento evento = null;

        try {
            // Crear el tipo específico de evento según tipoEvento
            switch (tipoEvento) {
                case FERIA:
                    evento = new Feria(nombre, fechaInicio, duracionEstimada,
                            estado, requiereInscripcion, cupoMaximo, esAbierto, cantidadStands,
                            esAireLibre);
                    break;

                case TALLER:
                    evento = new Taller(nombre, fechaInicio, duracionEstimada,
                            estado, requiereInscripcion, cupoMaximo, esAbierto, modalidad);
                    break;

                case CONCIERTO:
                    evento = new Concierto(nombre, fechaInicio, duracionEstimada,
                            estado, requiereInscripcion, cupoMaximo,
                            esAbierto, cantidadStands, esAireLibre, tipoEntrada);
                    break;

                case EXPOSICION:
                    evento = new Exposicion(nombre, fechaInicio, duracionEstimada, estado,
                            tipoEvento, requiereInscripcion, cupoMaximo, esAbierto,
                            tipoArte);
                    break;

                case CICLOCINE:
                    evento = new CicloDeCine(nombre, fechaInicio, duracionEstimada, estado,
                            requiereInscripcion, cupoMaximo, esAbierto, charlasPosteriores);
                    break;

                default:
                    throw new IllegalArgumentException("Tipo de evento desconocido: " + tipoEvento);
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        if (!errores.isEmpty(z)) { // si hay errores, lanzamos una excepción
            throw new IllegalArgumentException(String.join("\n", errores)); // combina todos los mensajes de error en un
                                                                            // solo string
        } // throw new IllegalArgumentException tambien detiene la ejecución del método

        // Si no hay errores, insertamos el evento en el repositorio
        insertar(evento);
        return evento;
    }

    @Override
    public void validarYModificar(Evento evento, Object... datos) {
        if (datos.length < 9 || datos.length > 15) {
            throw new IllegalArgumentException("Número incorrecto de parámetros.");
        }

        String nombre = (String) datos[0];
        LocalDate fechaInicio = (LocalDate) datos[1];
        int duracionEstimada = (int) datos[2];
        EstadoEvento estado = (EstadoEvento) datos[3];
        TipoEvento tipoEvento = (TipoEvento) datos[4];
        boolean requiereInscripcion = (boolean) datos[5];
        int cupoMaximo = (int) datos[6];
        boolean esAbierto = (boolean) datos[7];

        // Datos específicos para Feria
        int cantidadStands = (int) datos[8];
        boolean esAireLibre = (boolean) datos[9];

        // Datos específicos para Taller
        TipoModalidad modalidad = (TipoModalidad) datos[10];

        // Datos específicos para Concierto
        TipoEntrada tipoEntrada = (TipoEntrada) datos[11];

        // Datos específicos para Exposición
        TipoDeArte tipoArte = (TipoDeArte) datos[12];

        // Datos específicos para Ciclo de Cine
        boolean charlasPosteriores = (boolean) datos[13];

        List<String> errores = new ArrayList<>();

        // Validaciones getters y setters

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

        try {
            evento.setEstado(estado);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        try {
            evento.setTipoEvento(tipoEvento);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }
        try {
            evento.setRequiereInscripcion(requiereInscripcion);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }
        try {
            evento.setCupoMaximo(cupoMaximo);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }
        try {
            evento.setEsAbierto(esAbierto);
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        // Validaciones específicas de cada tipo de evento
        try {
            if (evento instanceof Feria) { // si evento es una instancia de feria
                ((Feria) evento).setCantidadStands(cantidadStands); // convierte el objeto de tipo Evento a Feria
                ((Feria) evento).setEsAireLibre(esAireLibre);
            } else if (evento instanceof Taller) {
                ((Taller) evento).setModalidad(modalidad);
            } else if (evento instanceof Concierto) {
                ((Concierto) evento).setTipoEntrada(tipoEntrada);
            } else if (evento instanceof Exposicion) {
                ((Exposicion) evento).setTipoArte(tipoArte);
            } else if (evento instanceof CicloDeCine) {
                ((CicloDeCine) evento).setCharlasPosteriores(charlasPosteriores);
            }
        } catch (IllegalArgumentException e) {
            errores.add(e.getMessage());
        }

        if (!errores.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errores));
        }

        modificar(evento);
    }

    @Override
    public void validarYBorrar(Evento evento) {
        List<String> errores = new ArrayList<>();

        // Validación 1: Verificar que el evento no sea null
        if (evento == null) {
            throw new IllegalArgumentException("El evento no puede ser null");
        }

        // Validación 2: Verificar que el evento exista en la base de datos
        Evento eventoExistente = buscar(evento.getId());
        if (eventoExistente == null) {
            errores.add("El evento con ID " + evento.getId() + " no existe en la base de datos");
        }

        // Validación 3: Verificar el estado del evento
        try {
            if (evento.getEstado() == EstadoEvento.EN_CURSO) {
                errores.add("No se puede eliminar un evento que está en curso");
            }

            if (evento.getEstado() == EstadoEvento.FINALIZADO) {
                errores.add("No se puede eliminar un evento que ya ha finalizado");
            }
        } catch (Exception e) {
            errores.add("Error al verificar el estado del evento: " + e.getMessage());
        }

        // Validación 4: Verificar si el evento tiene inscripciones
        try {
            if (evento.getRequiereInscripcion()) {
                // Verificar si hay inscripciones asociadas
                // Esto dependería de tu modelo de datos
                /*
                 * List<Inscripcion> inscripciones =
                 * inscripcionServicio.buscarPorEvento(evento);
                 * if (!inscripciones.isEmpty()) {
                 * errores.
                 * add("No se puede eliminar un evento que tiene inscripciones asociadas (" +
                 * inscripciones.size() + " inscripciones)");
                 * }
                 */
            }
        } catch (Exception e) {
            errores.add("Error al verificar las inscripciones del evento: " + e.getMessage());
        }

        // Validación 5: Verificar fechas
        try {
            LocalDate fechaActual = LocalDate.now();
            if (evento.getFechaInicio().isBefore(fechaActual.plusDays(1))) {
                errores.add("No se puede eliminar un evento que comienza en menos de 24 horas");
            }
        } catch (Exception e) {
            errores.add("Error al verificar las fechas del evento: " + e.getMessage());
        }

        // Validación 6: Verificar dependencias específicas por tipo de evento
        try {
            if (evento instanceof Feria) {
                // Verificar si hay stands reservados
                Feria feria = (Feria) evento;
                if (feria.getCantidadStands() > 0) {
                    // Aquí podrías verificar si hay stands ya reservados
                    // errores.add("No se puede eliminar una feria con stands reservados");
                }
            } else if (evento instanceof Taller) {
                // Verificar si hay recursos asociados al taller
                Taller taller = (Taller) evento;
                // Validaciones específicas para taller
            } else if (evento instanceof Concierto) {
                // Verificar si hay entradas vendidas
                Concierto concierto = (Concierto) evento;
                // Validaciones específicas para concierto
            }
            // Agregar más validaciones específicas según el tipo
        } catch (Exception e) {
            errores.add("Error al verificar dependencias específicas: " + e.getMessage());
        }

        // Validación 7: Verificar si el evento está activo
        try {
            if (evento.getActivo() != null && !evento.getActivo()) {
                errores.add("El evento ya está marcado como inactivo");
            }
        } catch (Exception e) {
            errores.add("Error al verificar el estado activo del evento: " + e.getMessage());
        }

        // Si hay errores, lanzar excepción con todos los mensajes
        if (!errores.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errores));
        }

        // Si no hay errores, proceder con el borrado
        try {
            // Opcional: Marcar como inactivo en lugar de borrar físicamente
            // marcarComoInactivo(evento);
            // modificar(evento);

            // O borrar físicamente si es necesario
            borrar(evento);

        } catch (Exception e) {
            throw new IllegalArgumentException("Error al eliminar el evento: " + e.getMessage());
        }
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