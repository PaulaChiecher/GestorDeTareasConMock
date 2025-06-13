package gestor;

/**
 * Clase para probar el GestorDeTareas con un Logger simple.
 */
public class Main {

    public static void main(String[] args) {
        Logger logger = System.out::println; // Logger que imprime en consola

        GestorDeTareas gestor = new GestorDeTareas(logger);

        gestor.agregarTarea("Comprar leche");
        gestor.agregarTarea("Estudiar para el parcial");

        gestor.completarTarea(0);

        System.out.println("Listado de tareas:");
        for (Tarea tarea : gestor.listarTareas()) {
            System.out.println(tarea);
        }
    }
}
// Este código es un ejemplo de cómo usar el GestorDeTareas con un Logger simple.
// Puedes ejecutar este código para ver cómo se agregan y completan tareas, y cómo se registran las acciones en la consola.