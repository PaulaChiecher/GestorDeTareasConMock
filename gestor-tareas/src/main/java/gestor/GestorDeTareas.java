package gestor;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas {
    private final Logger logger;
    private final List<Tarea> tareas = new ArrayList<>();

    public GestorDeTareas(Logger logger) {
        this.logger = logger;
    }

    public void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
        logger.log("Tarea agregada: " + descripcion);
    }

    /*public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).completar();
            logger.log("Tarea completada: " + tareas.get(indice).getDescripcion());
        }
    }*/
    public void completarTarea(int indice) {
    if (indice < 0 || indice >= tareas.size()) {
        throw new IllegalArgumentException("Índice de tarea inválido: " + indice);
    }
    tareas.get(indice).completar();
    logger.log("Tarea completada: " + tareas.get(indice).getDescripcion());
    }


    public List<Tarea> listarTareas() {
        return tareas;
    }
}