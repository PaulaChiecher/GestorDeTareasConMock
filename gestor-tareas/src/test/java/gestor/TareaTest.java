package gestor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TareaTest {

    @Test
    void testConstructorYGetters() {
        Tarea tarea = new Tarea("Hacer resumen");
        assertEquals("Hacer resumen", tarea.getDescripcion());
        assertFalse(tarea.isCompletada());
    }

    @Test
    void testCompletar() {
        Tarea tarea = new Tarea("Ir al súper");
        tarea.completar();
        assertTrue(tarea.isCompletada());
    }

    @Test
    void testToStringPendiente() {
        Tarea tarea = new Tarea("Leer libro");
        assertEquals("Leer libro (pendiente)", tarea.toString());
    }

    @Test
    void testToStringCompletada() {
        Tarea tarea = new Tarea("Leer libro");
        tarea.completar();
        assertEquals("Leer libro (completada)", tarea.toString());
    }
}
