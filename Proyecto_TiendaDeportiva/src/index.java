import Vista.Vista;
import Controlador.VistaController;

public class index {
    public static void main(String[] args) {
        // Crear la vista
        Vista vista = new Vista();

        // Crear el controlador pasando la vista
        VistaController controlador = new VistaController(vista);

        // Mostrar la vista
        controlador.mostrarVista();
    }
}
