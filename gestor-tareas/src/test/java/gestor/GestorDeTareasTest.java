package gestor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class GestorDeTareasTest {

    private GestorDeTareas gestor;
    private Logger mockLogger;

    @BeforeEach
    void setUp() {
        mockLogger = mock(Logger.class);
        gestor = new GestorDeTareas(mockLogger);
    }

    @Test
    void testAgregarTarea() {
        gestor.agregarTarea("Estudiar para el parcial");

        List<Tarea> tareas = gestor.listarTareas();
        assertEquals(1, tareas.size());
        assertEquals("Estudiar para el parcial", tareas.get(0).getDescripcion());
        assertFalse(tareas.get(0).isCompletada());

        verify(mockLogger).log("Tarea agregada: Estudiar para el parcial");
    }

    @Test
    void testCompletarTarea() {
        gestor.agregarTarea("Hacer los tests");

        gestor.completarTarea(0);

        List<Tarea> tareas = gestor.listarTareas();
        assertTrue(tareas.get(0).isCompletada());
        verify(mockLogger).log("Tarea completada: Hacer los tests");
    }

    @Test
    void testListarTareas() {
        gestor.agregarTarea("Tarea 1");
        gestor.agregarTarea("Tarea 2");

        List<Tarea> tareas = gestor.listarTareas();
        assertEquals(2, tareas.size());
        assertEquals("Tarea 1", tareas.get(0).getDescripcion());
        assertEquals("Tarea 2", tareas.get(1).getDescripcion());
    }

    @Test
    void testCompletarTareaConIndiceInvalidoLanzaExcepcion() {
    gestor.agregarTarea("Tarea 1");
    verify(mockLogger).log("Tarea agregada: Tarea 1"); // ✅ esto sí se espera

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        gestor.completarTarea(5); // índice fuera de rango
    });

    assertEquals("Índice de tarea inválido: 5", exception.getMessage());

    // No log esperado para completarTarea porque falló antes del log
    verifyNoMoreInteractions(mockLogger); // ahora sí correcto
    }
}


