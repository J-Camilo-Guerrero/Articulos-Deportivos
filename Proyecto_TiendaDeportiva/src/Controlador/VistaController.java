package Controlador;

import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaController {

    private Vista vista;

    // Constructor que recibe la vista
    public VistaController (Vista vista) {
        this.vista = vista;
        inicializarControlador();
    }

    // Método para inicializar los listeners y acciones
    private void inicializarControlador() {
        // Aquí puedes agregar listeners a los componentes de la vista.
        // Ejemplo: manejo de pestañas o botones.
        // Puedes agregar ActionListeners u otros manejadores de eventos aquí.
    }

    // Método para mostrar la interfaz
    public void mostrarVista() {
        vista.mostrarInterfaz();
    }

    // Métodos adicionales para manejar la lógica de la aplicación
}
